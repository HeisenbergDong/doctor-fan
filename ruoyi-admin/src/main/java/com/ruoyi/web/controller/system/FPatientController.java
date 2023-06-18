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
import com.ruoyi.system.domain.FPatient;
import com.ruoyi.system.service.IFPatientService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者信息Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/patient")
public class FPatientController extends BaseController {
    @Autowired
    private IFPatientService fPatientService;

    /**
     * 查询患者信息列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:patient:list')")
    @GetMapping("/list")
    public TableDataInfo list(FPatient fPatient) {
        startPage();
        List<FPatient> list = fPatientService.selectFPatientList(fPatient);
        return getDataTable(list);
    }

    /**
     * 导出患者信息列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:patient:export')")
    @Log(title = "患者信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FPatient fPatient)
    {
        List<FPatient> list = fPatientService.selectFPatientList(fPatient);
        ExcelUtil<FPatient> util = new ExcelUtil<FPatient>(FPatient.class);
        util.exportExcel(response, list, "患者信息数据");
    }

    /**
     * 获取患者信息详细信息
     */
    //@PreAuthorize("@ss.hasPermi('doc:patient:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(fPatientService.selectFPatientById(id));
    }

    /**
     * 新增患者信息
     */
    //@PreAuthorize("@ss.hasPermi('doc:patient:add')")
    @Log(title = "患者信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FPatient fPatient) {
        return toAjax(fPatientService.insertFPatient(fPatient));
    }

    /**
     * 修改患者信息
     */
    //@PreAuthorize("@ss.hasPermi('doc:patient:edit')")
    @Log(title = "患者信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FPatient fPatient)
    {
        return toAjax(fPatientService.updateFPatient(fPatient));
    }

    /**
     * 删除患者信息
     */
    //@PreAuthorize("@ss.hasPermi('doc:patient:remove')")
    @Log(title = "患者信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fPatientService.deleteFPatientByIds(ids));
    }
}
