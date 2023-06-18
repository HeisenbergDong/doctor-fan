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
import com.ruoyi.system.domain.FReservation;
import com.ruoyi.system.service.IFReservationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预约Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/reservation")
public class FReservationController extends BaseController
{
    @Autowired
    private IFReservationService fReservationService;

    /**
     * 查询预约列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:reservation:list')")
    @GetMapping("/list")
    public TableDataInfo list(FReservation fReservation)
    {
        startPage();
        List<FReservation> list = fReservationService.selectFReservationList(fReservation);
        return getDataTable(list);
    }

    /**
     * 导出预约列表
     */
    //@PreAuthorize("@ss.hasPermi('doc:reservation:export')")
    @Log(title = "预约", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FReservation fReservation)
    {
        List<FReservation> list = fReservationService.selectFReservationList(fReservation);
        ExcelUtil<FReservation> util = new ExcelUtil<FReservation>(FReservation.class);
        util.exportExcel(response, list, "预约数据");
    }

    /**
     * 获取预约详细信息
     */
    //@PreAuthorize("@ss.hasPermi('doc:reservation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fReservationService.selectFReservationById(id));
    }

    /**
     * 新增预约
     */
    //@PreAuthorize("@ss.hasPermi('doc:reservation:add')")
    @Log(title = "预约", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Validated FReservation fReservation){
        fReservation.setCreateBy(getUserId().toString());
        fReservation.setUpdateBy(getUserId().toString());
        return toAjax(fReservationService.insertFReservation(fReservation));
    }

    /**
     * 修改预约
     */
    //@PreAuthorize("@ss.hasPermi('doc:reservation:edit')")
    @Log(title = "预约", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody @Validated FReservation fReservation){
        fReservation.setUpdateBy(getUserId().toString());
        return toAjax(fReservationService.updateFReservation(fReservation));
    }

    /**
     * 删除预约
     */
    //@PreAuthorize("@ss.hasPermi('doc:reservation:remove')")
    @Log(title = "预约", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fReservationService.deleteFReservationByIds(ids));
    }
}
