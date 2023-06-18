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
import com.ruoyi.system.domain.FVisitForm;
import com.ruoyi.system.service.IFVisitFormService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 问诊单关联Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/visit/form")
public class FVisitFormController extends BaseController
{
    @Autowired
    private IFVisitFormService fVisitFormService;

    /**
     * 查询问诊单关联列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:list')")
    @GetMapping("/list")
    public TableDataInfo list(FVisitForm fVisitForm)
    {
        startPage();
        List<FVisitForm> list = fVisitFormService.selectFVisitFormList(fVisitForm);
        return getDataTable(list);
    }

    /**
     * 导出问诊单关联列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:export')")
    @Log(title = "问诊单关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FVisitForm fVisitForm)
    {
        List<FVisitForm> list = fVisitFormService.selectFVisitFormList(fVisitForm);
        ExcelUtil<FVisitForm> util = new ExcelUtil<FVisitForm>(FVisitForm.class);
        util.exportExcel(response, list, "问诊单关联数据");
    }

    /**
     * 获取问诊单关联详细信息
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fVisitFormService.selectFVisitFormById(id));
    }

    /**
     * 新增问诊单关联
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:add')")
    @Log(title = "问诊单关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FVisitForm fVisitForm)
    {
        return toAjax(fVisitFormService.insertFVisitForm(fVisitForm));
    }

    /**
     * 修改问诊单关联
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:edit')")
    @Log(title = "问诊单关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FVisitForm fVisitForm)
    {
        return toAjax(fVisitFormService.updateFVisitForm(fVisitForm));
    }

    /**
     * 删除问诊单关联
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:remove')")
    @Log(title = "问诊单关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fVisitFormService.deleteFVisitFormByIds(ids));
    }
}
