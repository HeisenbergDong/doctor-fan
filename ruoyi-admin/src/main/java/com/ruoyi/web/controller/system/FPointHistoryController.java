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
import com.ruoyi.system.domain.FPointHistory;
import com.ruoyi.system.service.IFPointHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 推荐人折扣积分Controller
 * 
 * @author ruoyi
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/system/history")
public class FPointHistoryController extends BaseController
{
    @Autowired
    private IFPointHistoryService fPointHistoryService;

    /**
     * 查询推荐人折扣积分列表
     */
    //@PreAuthorize("@ss.hasPermi('system:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(FPointHistory fPointHistory)
    {
        startPage();
        List<FPointHistory> list = fPointHistoryService.selectFPointHistoryList(fPointHistory);
        return getDataTable(list);
    }

    /**
     * 导出推荐人折扣积分列表
     */
    //@PreAuthorize("@ss.hasPermi('system:history:export')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FPointHistory fPointHistory)
    {
        List<FPointHistory> list = fPointHistoryService.selectFPointHistoryList(fPointHistory);
        ExcelUtil<FPointHistory> util = new ExcelUtil<FPointHistory>(FPointHistory.class);
        util.exportExcel(response, list, "推荐人折扣积分数据");
    }

    /**
     * 获取推荐人折扣积分详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fPointHistoryService.selectFPointHistoryById(id));
    }

    /**
     * 新增推荐人折扣积分
     */
    //@PreAuthorize("@ss.hasPermi('system:history:add')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FPointHistory fPointHistory)
    {
        return toAjax(fPointHistoryService.insertFPointHistory(fPointHistory));
    }

    /**
     * 修改推荐人折扣积分
     */
    //@PreAuthorize("@ss.hasPermi('system:history:edit')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FPointHistory fPointHistory)
    {
        return toAjax(fPointHistoryService.updateFPointHistory(fPointHistory));
    }

    /**
     * 删除推荐人折扣积分
     */
    //@PreAuthorize("@ss.hasPermi('system:history:remove')")
    @Log(title = "推荐人折扣积分", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fPointHistoryService.deleteFPointHistoryByIds(ids));
    }
}
