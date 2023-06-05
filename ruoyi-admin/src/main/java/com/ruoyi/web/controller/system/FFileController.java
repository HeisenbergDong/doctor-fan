package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.FFile;
import com.ruoyi.system.service.IFFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文件Controller
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/doc/file")
public class FFileController extends BaseController
{
    @Autowired
    private IFFileService fFileService;

    /**
     * 查询文件列表
     */
    @PreAuthorize("@ss.hasPermi('doc:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(FFile fFile)
    {
        startPage();
        List<FFile> list = fFileService.selectFFileList(fFile);
        return getDataTable(list);
    }

    /**
     * 导出文件列表
     */
    @PreAuthorize("@ss.hasPermi('doc:file:export')")
    @Log(title = "文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FFile fFile)
    {
        List<FFile> list = fFileService.selectFFileList(fFile);
        ExcelUtil<FFile> util = new ExcelUtil<FFile>(FFile.class);
        util.exportExcel(response, list, "文件数据");
    }

    /**
     * 获取文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('doc:file:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fFileService.selectFFileById(id));
    }

    /**
     * 新增文件
     */
    @PreAuthorize("@ss.hasPermi('doc:file:add')")
    @Log(title = "文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FFile fFile)
    {
        return toAjax(fFileService.insertFFile(fFile));
    }

    /**
     * 修改文件
     */
    @PreAuthorize("@ss.hasPermi('doc:file:edit')")
    @Log(title = "文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FFile fFile)
    {
        return toAjax(fFileService.updateFFile(fFile));
    }

    /**
     * 删除文件
     */
    @PreAuthorize("@ss.hasPermi('doc:file:remove')")
    @Log(title = "文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fFileService.deleteFFileByIds(ids));
    }
}
