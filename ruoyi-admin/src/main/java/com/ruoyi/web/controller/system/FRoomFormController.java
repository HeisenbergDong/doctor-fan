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
import com.ruoyi.system.domain.FRoomForm;
import com.ruoyi.system.service.IFRoomFormService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 诊室和单类型关联关系Controller
 * 
 * @author ruoyi
 * @date 2023-06-05
 */
@RestController
@RequestMapping("/doc/room/form")
public class FRoomFormController extends BaseController
{
    @Autowired
    private IFRoomFormService fRoomFormService;

    /**
     * 查询诊室和单类型关联关系列表
     */
    @PreAuthorize("@ss.hasPermi('doc:form:list')")
    @GetMapping("/list")
    public TableDataInfo list(FRoomForm fRoomForm)
    {
        startPage();
        List<FRoomForm> list = fRoomFormService.selectFRoomFormList(fRoomForm);
        return getDataTable(list);
    }

    /**
     * 导出诊室和单类型关联关系列表
     */
    @PreAuthorize("@ss.hasPermi('doc:form:export')")
    @Log(title = "诊室和单类型关联关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FRoomForm fRoomForm)
    {
        List<FRoomForm> list = fRoomFormService.selectFRoomFormList(fRoomForm);
        ExcelUtil<FRoomForm> util = new ExcelUtil<FRoomForm>(FRoomForm.class);
        util.exportExcel(response, list, "诊室和单类型关联关系数据");
    }

    /**
     * 获取诊室和单类型关联关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('doc:form:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fRoomFormService.selectFRoomFormById(id));
    }

    /**
     * 新增诊室和单类型关联关系
     */
    @PreAuthorize("@ss.hasPermi('doc:form:add')")
    @Log(title = "诊室和单类型关联关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FRoomForm fRoomForm) {
        fRoomForm.setCreateBy(getUserId().toString());
        fRoomForm.setUpdateBy(getUserId().toString());
        return toAjax(fRoomFormService.insertFRoomForm(fRoomForm));
    }

    /**
     * 修改诊室和单类型关联关系
     */
    @PreAuthorize("@ss.hasPermi('doc:form:edit')")
    @Log(title = "诊室和单类型关联关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FRoomForm fRoomForm) {
        fRoomForm.setUpdateBy(getUserId().toString());
        return toAjax(fRoomFormService.updateFRoomForm(fRoomForm));
    }

    /**
     * 删除诊室和单类型关联关系
     */
    @PreAuthorize("@ss.hasPermi('doc:form:remove')")
    @Log(title = "诊室和单类型关联关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fRoomFormService.deleteFRoomFormByIds(ids));
    }
}
