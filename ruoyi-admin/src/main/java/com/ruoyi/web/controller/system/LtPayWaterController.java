package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LtPayWater;
import com.ruoyi.system.service.ILtPayWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 支付流水Controller
 *
 * @author ruoyi
 * @date 2022-03-14
 */
@RestController
@RequestMapping("/pay/water")
public class LtPayWaterController extends BaseController
{
    @Autowired
    private ILtPayWaterService ltPayWaterService;

    /**
     * 查询支付流水列表
     */
    @GetMapping("/list")
    public TableDataInfo list(LtPayWater ltPayWater)
    {
        startPage();
        List<LtPayWater> list = ltPayWaterService.selectLtPayWaterList(ltPayWater);
        return getDataTable(list);
    }

    /**
     * 导出支付流水列表
     */
    @Log(title = "支付流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LtPayWater ltPayWater)
    {
        List<LtPayWater> list = ltPayWaterService.selectLtPayWaterList(ltPayWater);
        ExcelUtil<LtPayWater> util = new ExcelUtil<LtPayWater>(LtPayWater.class);
        util.exportExcel(response, list, "支付流水数据");
    }

    /**
     * 获取支付流水详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ltPayWaterService.selectLtPayWaterById(id));
    }

    /**
     * 新增支付流水
     */
    @Log(title = "支付流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LtPayWater ltPayWater)
    {
        return toAjax(ltPayWaterService.insertLtPayWater(ltPayWater));
    }

    /**
     * 修改支付流水
     */
    @Log(title = "支付流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LtPayWater ltPayWater)
    {
        return toAjax(ltPayWaterService.updateLtPayWater(ltPayWater));
    }

    /**
     * 删除支付流水
     */
    @Log(title = "支付流水", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ltPayWaterService.deleteLtPayWaterByIds(ids));
    }
}
