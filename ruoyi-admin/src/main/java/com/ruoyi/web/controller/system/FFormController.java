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
import com.ruoyi.system.domain.FForm;
import com.ruoyi.system.service.IFFormService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 单Controller
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@RestController
@RequestMapping("/doc/form")
public class FFormController extends BaseController
{
    @Autowired
    private IFFormService fFormService;

    /**
     * 查询单列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:list')")
    @GetMapping("/list")
    public TableDataInfo list(FForm fForm) {
        startPage();
        List<FForm> list = fFormService.selectFFormList(fForm);
        return getDataTable(list);
    }

    /**
     * 导出单列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:export')")
    @Log(title = "单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FForm fForm) {
        List<FForm> list = fFormService.selectFFormList(fForm);
        ExcelUtil<FForm> util = new ExcelUtil<FForm>(FForm.class);
        util.exportExcel(response, list, "单数据");
    }

    /**
     * 获取单详细信息
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(fFormService.selectFFormById(id));
    }

    /**
     * 新增单
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:add')")
    @Log(title = "单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Validated FForm fForm) {
        fForm.setCreateBy(getUserId().toString());
        fForm.setUpdateBy(getUserId().toString());
        return toAjax(fFormService.insertFForm(fForm));
    }

    /**
     * 修改单
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:edit')")
    @Log(title = "单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody @Validated FForm fForm) {
        fForm.setUpdateBy(getUserId().toString());
        return toAjax(fFormService.updateFForm(fForm));
    }

    /**
     * 删除单
     */
    //@PreAuthorize("@ss.hasPermi('doc:form:remove')")
    @Log(title = "单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(fFormService.deleteFFormByIds(ids));
    }
}
