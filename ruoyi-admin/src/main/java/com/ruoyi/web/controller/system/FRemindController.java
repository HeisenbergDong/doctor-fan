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
import com.ruoyi.system.domain.FRemind;
import com.ruoyi.system.service.IFRemindService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提醒Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/remind")
public class FRemindController extends BaseController
{
    @Autowired
    private IFRemindService fRemindService;

    /**
     * 查询提醒列表
     */
    @PreAuthorize("@ss.hasPermi('system:remind:list')")
    @GetMapping("/list")
    public TableDataInfo list(FRemind fRemind)
    {
        startPage();
        List<FRemind> list = fRemindService.selectFRemindList(fRemind);
        return getDataTable(list);
    }

    /**
     * 导出提醒列表
     */
    @PreAuthorize("@ss.hasPermi('system:remind:export')")
    @Log(title = "提醒", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FRemind fRemind)
    {
        List<FRemind> list = fRemindService.selectFRemindList(fRemind);
        ExcelUtil<FRemind> util = new ExcelUtil<FRemind>(FRemind.class);
        util.exportExcel(response, list, "提醒数据");
    }

    /**
     * 获取提醒详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:remind:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fRemindService.selectFRemindById(id));
    }

    /**
     * 新增提醒
     */
    @PreAuthorize("@ss.hasPermi('system:remind:add')")
    @Log(title = "提醒", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Validated FRemind fRemind) {
        fRemind.setCreateBy(getUserId().toString());
        fRemind.setUpdateBy(getUserId().toString());
        return toAjax(fRemindService.insertFRemind(fRemind));
    }

    /**
     * 修改提醒
     */
    @PreAuthorize("@ss.hasPermi('system:remind:edit')")
    @Log(title = "提醒", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody @Validated FRemind fRemind) {
        fRemind.setUpdateBy(getUserId().toString());
        return toAjax(fRemindService.updateFRemind(fRemind));
    }

    /**
     * 删除提醒
     */
    @PreAuthorize("@ss.hasPermi('system:remind:remove')")
    @Log(title = "提醒", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fRemindService.deleteFRemindByIds(ids));
    }
}
