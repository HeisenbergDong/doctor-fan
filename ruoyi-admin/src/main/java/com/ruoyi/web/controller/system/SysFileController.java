package com.ruoyi.web.controller.system;

import com.github.tobato.fastdfs.exception.FdfsServerException;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.system.domain.FFile;
import com.ruoyi.system.service.IFFileService;
import com.ruoyi.system.service.ISysFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.core.domain.R;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * 文件请求处理
 *
 * @author ruoyi
 */
@RestController
public class SysFileController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(SysFileController.class);

    @Autowired
    private ISysFileService sysFileService;

    @Autowired
    private IFFileService fileService;

    /**
     * 文件上传请求
     */
    @PostMapping("upload")
    public R<FFile> upload(MultipartFile file)
    {
        try
        {
            // 上传并返回访问地址
            String url = sysFileService.uploadFile(file);
            FFile fFile = new FFile();
            fFile.setFileName(FileUtils.getName(url));
            fFile.setFileUrl(url);
            fFile.setCreateBy(getUserId().toString());
            fFile.setUpdateBy(getUserId().toString());
            fFile.setCreateTime(DateUtils.getNowDate());
            fFile.setUpdateTime(DateUtils.getNowDate());
            fileService.insertFFile(fFile);
            return R.ok(fFile);
        }
        catch (Exception e)
        {
            log.error("上传文件失败", e);
            return R.fail(e.getMessage());
        }
    }

    @GetMapping("/download")
    public void download(@RequestParam String groupName, @RequestParam String path,HttpServletResponse response ) {
        try {
            // 拆分获取出文件名称,方便一会写入的时候写出正确的文件名(url中的文件名和服务器中是一致的，至少默认是这样的)
            String[] split = path.split("/");
            String imgName=split[split.length-1];
            // 设置请求头为附件模式
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(imgName, "UTF-8"));
            // 调用客户端获取文件字节码
            byte[] imageByte = sysFileService.download(groupName, path);
            // 从response获取响应流
            ServletOutputStream outputStream = response.getOutputStream();
            // 向流写入数据
            outputStream.write(imageByte);
            // 关流
            outputStream.close();
        }catch (FdfsServerException e){
            log.error("文件不存在");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/del")
    public String delFile(@RequestParam String fileId) {
        try {
            sysFileService.delFile(fileId);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "删除失败";
    }
}