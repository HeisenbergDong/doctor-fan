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
import com.ruoyi.system.domain.FPointValue;
import com.ruoyi.system.service.IFPointValueService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 推荐人折扣积分Controller
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@RestController
@RequestMapping("/doc/point/value")
public class FPointValueController extends BaseController
{
    @Autowired
    private IFPointValueService fPointValueService;

    /**
     * 查询推荐人折扣积分列表
     */
    //@PreAuthorize("@ss.hasPermi('system:value:list')")
    @GetMapping("/list")
    public TableDataInfo list(FPointValue fPointValue)
    {
        startPage();
        List<FPointValue> list = fPointValueService.selectFPointValueList(fPointValue);
        return getDataTable(list);
    }

    /**
     * 导出推荐人折扣积分列表
     */
    //@PreAuthorize("@ss.hasPermi('system:value:export')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FPointValue fPointValue)
    {
        List<FPointValue> list = fPointValueService.selectFPointValueList(fPointValue);
        ExcelUtil<FPointValue> util = new ExcelUtil<FPointValue>(FPointValue.class);
        util.exportExcel(response, list, "推荐人折扣积分数据");
    }

    /**
     * 获取推荐人折扣积分详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:value:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fPointValueService.selectFPointValueById(id));
    }

    /**
     * 新增推荐人折扣积分
     */
    //@PreAuthorize("@ss.hasPermi('system:value:add')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FPointValue fPointValue)
    {
        return toAjax(fPointValueService.insertFPointValue(fPointValue));
    }

    /**
     * 修改推荐人折扣积分
     */
    //@PreAuthorize("@ss.hasPermi('system:value:edit')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FPointValue fPointValue)
    {
        return toAjax(fPointValueService.updateFPointValue(fPointValue));
    }

    /**
     * 删除推荐人折扣积分
     */
    //@PreAuthorize("@ss.hasPermi('system:value:remove')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fPointValueService.deleteFPointValueByIds(ids));
    }
}
