package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.enums.DipatchStatus;
import com.ruoyi.common.exception.ServiceException;
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
import com.ruoyi.system.domain.FWait;
import com.ruoyi.system.service.IFWaitService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 排队Controller
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@RestController
@RequestMapping("/doc/wait")
public class FWaitController extends BaseController
{
    @Autowired
    private IFWaitService fWaitService;

    /**
     * 查询排队列表
     */
    @PreAuthorize("@ss.hasPermi('doc:wait:list')")
    @GetMapping("/list")
    public TableDataInfo list(FWait fWait)
    {
        startPage();
        List<FWait> list = fWaitService.selectFWaitList(fWait);
        return getDataTable(list);
    }

    /**
     * 导出排队列表
     */
    @PreAuthorize("@ss.hasPermi('doc:wait:export')")
    @Log(title = "排队", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FWait fWait)
    {
        List<FWait> list = fWaitService.selectFWaitList(fWait);
        ExcelUtil<FWait> util = new ExcelUtil<FWait>(FWait.class);
        util.exportExcel(response, list, "排队数据");
    }

    /**
     * 获取排队详细信息
     */
    @PreAuthorize("@ss.hasPermi('doc:wait:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fWaitService.selectFWaitById(id));
    }

    /**
     * 新增排队
     */
    @PreAuthorize("@ss.hasPermi('doc:wait:add')")
    @Log(title = "指派", businessType = BusinessType.INSERT)
    @PostMapping("/dispatch")
    public AjaxResult dispatch(@RequestBody @Validated FWait fWait){
        fWait.setCreateBy(getUserId().toString());
        fWait.setUpdateBy(getUserId().toString());
        return toAjax(fWaitService.dispatch(fWait));
    }

    /**
     * 修改排队
     */
    @PreAuthorize("@ss.hasPermi('doc:wait:edit')")
    @Log(title = "叫号", businessType = BusinessType.UPDATE)
    @PostMapping("/call")
    public AjaxResult call(@RequestBody @Validated FWait fWait){
        /** 只有队列中的患者才可以被叫号 */
        if(!fWait.getPatientStatus().equals(DipatchStatus.ZERO.getCode())){
            throw new ServiceException("客人不是排队中的状态，请确认！");
        }
        fWait.setUpdateBy(getUserId().toString());
        return toAjax(fWaitService.call(fWait));
    }

    /**
     * 删除排队
     */
    @PreAuthorize("@ss.hasPermi('doc:wait:remove')")
    @Log(title = "排队", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fWaitService.deleteFWaitByIds(ids));
    }
}
