package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.system.domain.FFile;
import com.ruoyi.system.service.IFFileService;
import com.ruoyi.system.service.ISysFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.core.domain.R;

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
}