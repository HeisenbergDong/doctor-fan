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
import com.ruoyi.system.domain.FVisit;
import com.ruoyi.system.service.IFVisitService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 就诊Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/visit")
public class FVisitController extends BaseController
{
    @Autowired
    private IFVisitService fVisitService;

    /**
     * 查询就诊列表
     */
    @PreAuthorize("@ss.hasPermi('system:visit:list')")
    @GetMapping("/list")
    public TableDataInfo list(FVisit fVisit)
    {
        startPage();
        List<FVisit> list = fVisitService.selectFVisitList(fVisit);
        return getDataTable(list);
    }

    /**
     * 导出就诊列表
     */
    @PreAuthorize("@ss.hasPermi('system:visit:export')")
    @Log(title = "就诊", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FVisit fVisit)
    {
        List<FVisit> list = fVisitService.selectFVisitList(fVisit);
        ExcelUtil<FVisit> util = new ExcelUtil<FVisit>(FVisit.class);
        util.exportExcel(response, list, "就诊数据");
    }

    /**
     * 获取就诊详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:visit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fVisitService.selectFVisitById(id));
    }

    /**
     * 新增就诊
     */
    @PreAuthorize("@ss.hasPermi('system:visit:add')")
    @Log(title = "就诊", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FVisit fVisit) {
        fVisit.setCreateBy(getUserId().toString());
        fVisit.setUpdateBy(getUserId().toString());
        return toAjax(fVisitService.insertFVisit(fVisit));
    }

    /**
     * 修改就诊
     */
    @PreAuthorize("@ss.hasPermi('system:visit:edit')")
    @Log(title = "就诊", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FVisit fVisit) {
        fVisit.setUpdateBy(getUserId().toString());
        return toAjax(fVisitService.updateFVisit(fVisit));
    }

    /**
     * 删除就诊
     */
    @PreAuthorize("@ss.hasPermi('system:visit:remove')")
    @Log(title = "就诊", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fVisitService.deleteFVisitByIds(ids));
    }
}
