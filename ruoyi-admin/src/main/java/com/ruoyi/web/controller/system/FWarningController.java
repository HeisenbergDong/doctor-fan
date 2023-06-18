package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.ruoyi.system.domain.FWarning;
import com.ruoyi.system.service.IFWarningService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提醒Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/warning")
public class FWarningController extends BaseController
{
    @Autowired
    private IFWarningService fWarningService;

    /**
     * 查询提醒列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:warning:list')")
    @GetMapping("/list")
    public TableDataInfo list(FWarning fWarning)
    {
        startPage();
        List<FWarning> list = fWarningService.selectFWarningList(fWarning);
        return getDataTable(list);
    }

    /**
     * 导出提醒列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:warning:export')")
    @Log(title = "提醒", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FWarning fWarning)
    {
        List<FWarning> list = fWarningService.selectFWarningList(fWarning);
        ExcelUtil<FWarning> util = new ExcelUtil<FWarning>(FWarning.class);
        util.exportExcel(response, list, "提醒数据");
    }

    /**
     * 获取提醒详细信息
     */
    //@PreAuthorize("@ss.hasPermi('doc:warning:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fWarningService.selectFWarningById(id));
    }

    /**
     * 新增提醒
     */
    //@PreAuthorize("@ss.hasPermi('doc:warning:add')")
    @Log(title = "提醒", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Validated FWarning fWarning) {
        fWarning.setCreateBy(getUserId().toString());
        fWarning.setUpdateBy(getUserId().toString());
        return toAjax(fWarningService.insertFWarning(fWarning));
    }

    /**
     * 修改提醒
     */
    //@PreAuthorize("@ss.hasPermi('doc:warning:edit')")
    @Log(title = "提醒", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FWarning fWarning) {
        fWarning.setUpdateBy(getUserId().toString());
        return toAjax(fWarningService.updateFWarning(fWarning));
    }

    /**
     * 删除提醒
     */
    //@PreAuthorize("@ss.hasPermi('doc:warning:remove')")
    @Log(title = "提醒", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fWarningService.deleteFWarningByIds(ids));
    }
}
