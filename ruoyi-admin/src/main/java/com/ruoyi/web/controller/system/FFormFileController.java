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
import com.ruoyi.system.domain.FFormFile;
import com.ruoyi.system.service.IFFormFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 单和文件关联关系Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/form/file")
public class FFormFileController extends BaseController
{
    @Autowired
    private IFFormFileService fFormFileService;

    /**
     * 查询单和文件关联关系列表
     */
    @PreAuthorize("@ss.hasPermi('system:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(FFormFile fFormFile)
    {
        startPage();
        List<FFormFile> list = fFormFileService.selectFFormFileList(fFormFile);
        return getDataTable(list);
    }

    /**
     * 导出单和文件关联关系列表
     */
    @PreAuthorize("@ss.hasPermi('system:file:export')")
    @Log(title = "单和文件关联关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FFormFile fFormFile)
    {
        List<FFormFile> list = fFormFileService.selectFFormFileList(fFormFile);
        ExcelUtil<FFormFile> util = new ExcelUtil<FFormFile>(FFormFile.class);
        util.exportExcel(response, list, "单和文件关联关系数据");
    }

    /**
     * 获取单和文件关联关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:file:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fFormFileService.selectFFormFileById(id));
    }

    /**
     * 新增单和文件关联关系
     */
    @PreAuthorize("@ss.hasPermi('system:file:add')")
    @Log(title = "单和文件关联关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FFormFile fFormFile)
    {
        return toAjax(fFormFileService.insertFFormFile(fFormFile));
    }

    /**
     * 修改单和文件关联关系
     */
    @PreAuthorize("@ss.hasPermi('system:file:edit')")
    @Log(title = "单和文件关联关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FFormFile fFormFile)
    {
        return toAjax(fFormFileService.updateFFormFile(fFormFile));
    }

    /**
     * 删除单和文件关联关系
     */
    @PreAuthorize("@ss.hasPermi('system:file:remove')")
    @Log(title = "单和文件关联关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fFormFileService.deleteFFormFileByIds(ids));
    }
}
