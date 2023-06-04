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
import com.ruoyi.system.domain.FReg;
import com.ruoyi.system.service.IFRegService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 挂号Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/reg")
public class FRegController extends BaseController
{
    @Autowired
    private IFRegService fRegService;

    /**
     * 查询挂号列表
     */
    @PreAuthorize("@ss.hasPermi('system:reg:list')")
    @GetMapping("/list")
    public TableDataInfo list(FReg fReg)
    {
        startPage();
        List<FReg> list = fRegService.selectFRegList(fReg);
        return getDataTable(list);
    }

    /**
     * 导出挂号列表
     */
    @PreAuthorize("@ss.hasPermi('system:reg:export')")
    @Log(title = "挂号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FReg fReg)
    {
        List<FReg> list = fRegService.selectFRegList(fReg);
        ExcelUtil<FReg> util = new ExcelUtil<FReg>(FReg.class);
        util.exportExcel(response, list, "挂号数据");
    }

    /**
     * 获取挂号详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:reg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fRegService.selectFRegById(id));
    }

    /**
     * 新增挂号
     */
    @PreAuthorize("@ss.hasPermi('system:reg:add')")
    @Log(title = "挂号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Validated FReg fReg)
    {
        fReg.setCreateBy(getUserId().toString());
        fReg.setUpdateBy(getUserId().toString());
        return success(fRegService.insertFReg(fReg));
    }

    /**
     * 修改挂号
     */
    @PreAuthorize("@ss.hasPermi('system:reg:edit')")
    @Log(title = "挂号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FReg fReg)
    {
        return toAjax(fRegService.updateFReg(fReg));
    }

    /**
     * 删除挂号
     */
    @PreAuthorize("@ss.hasPermi('system:reg:remove')")
    @Log(title = "挂号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fRegService.deleteFRegByIds(ids));
    }
}
