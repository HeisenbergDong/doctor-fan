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
import com.ruoyi.system.domain.FFormPhy;
import com.ruoyi.system.service.IFFormPhyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生物测量仪Controller
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@RestController
@RequestMapping("/doc/phy")
public class FFormPhyController extends BaseController
{
    @Autowired
    private IFFormPhyService fFormPhyService;

    /**
     * 查询生物测量仪列表
     */
    //@PreAuthorize("@ss.hasPermi('system:phy:list')")
    @GetMapping("/list")
    public TableDataInfo list(FFormPhy fFormPhy)
    {
        startPage();
        List<FFormPhy> list = fFormPhyService.selectFFormPhyList(fFormPhy);
        return getDataTable(list);
    }

    @GetMapping(value = "/{patientId}")
    public AjaxResult dateList(@PathVariable("patientId") Long patientId){
        FFormPhy fFormPhy = new FFormPhy();
        fFormPhy.setPatientId(patientId);
        List<FFormPhy> list = fFormPhyService.selectDateList(fFormPhy);
        return success(list);
    }

    /**
     * 导出生物测量仪列表
     */
    //@PreAuthorize("@ss.hasPermi('system:phy:export')")
    @Log(title = "生物测量仪", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FFormPhy fFormPhy)
    {
        List<FFormPhy> list = fFormPhyService.selectFFormPhyList(fFormPhy);
        ExcelUtil<FFormPhy> util = new ExcelUtil<FFormPhy>(FFormPhy.class);
        util.exportExcel(response, list, "生物测量仪数据");
    }

    /**
     * 获取生物测量仪详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:phy:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fFormPhyService.selectFFormPhyById(id));
    }

    /**
     * 新增生物测量仪
     */
    //@PreAuthorize("@ss.hasPermi('system:phy:add')")
    @Log(title = "生物测量仪", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Validated FFormPhy fFormPhy)
    {
        return toAjax(fFormPhyService.insertFFormPhy(fFormPhy));
    }

    /**
     * 修改生物测量仪
     */
    //@PreAuthorize("@ss.hasPermi('system:phy:edit')")
    @Log(title = "生物测量仪", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody @Validated FFormPhy fFormPhy)
    {
        return toAjax(fFormPhyService.updateFFormPhy(fFormPhy));
    }

    /**
     * 删除生物测量仪
     */
    //@PreAuthorize("@ss.hasPermi('system:phy:remove')")
    @Log(title = "生物测量仪", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fFormPhyService.deleteFFormPhyByIds(ids));
    }
}
