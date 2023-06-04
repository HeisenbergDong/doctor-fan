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
import com.ruoyi.system.domain.FPoint;
import com.ruoyi.system.service.IFPointService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 推荐人折扣积分Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/point")
public class FPointController extends BaseController
{
    @Autowired
    private IFPointService fPointService;

    /**
     * 查询推荐人折扣积分列表
     */
    @PreAuthorize("@ss.hasPermi('doc:point:list')")
    @GetMapping("/list")
    public TableDataInfo list(FPoint fPoint)
    {
        startPage();
        List<FPoint> list = fPointService.selectFPointList(fPoint);
        return getDataTable(list);
    }

    /**
     * 导出推荐人折扣积分列表
     */
    @PreAuthorize("@ss.hasPermi('doc:point:export')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FPoint fPoint)
    {
        List<FPoint> list = fPointService.selectFPointList(fPoint);
        ExcelUtil<FPoint> util = new ExcelUtil<FPoint>(FPoint.class);
        util.exportExcel(response, list, "推荐人折扣积分数据");
    }

    /**
     * 获取推荐人折扣积分详细信息
     */
    @PreAuthorize("@ss.hasPermi('doc:point:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fPointService.selectFPointById(id));
    }

    /**
     * 新增推荐人折扣积分
     */
    @PreAuthorize("@ss.hasPermi('doc:point:add')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Validated FPoint fPoint) {
        fPoint.setCreateBy(getUserId().toString());
        fPoint.setUpdateBy(getUserId().toString());
        return toAjax(fPointService.insertFPoint(fPoint));
    }

    /**
     * 修改推荐人折扣积分
     */
    @PreAuthorize("@ss.hasPermi('doc:point:edit')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FPoint fPoint) {
        fPoint.setUpdateBy(getUserId().toString());
        return toAjax(fPointService.updateFPoint(fPoint));
    }

    /**
     * 删除推荐人折扣积分
     */
    @PreAuthorize("@ss.hasPermi('doc:point:remove')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fPointService.deleteFPointByIds(ids));
    }
}
