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
import com.ruoyi.system.domain.FRoom;
import com.ruoyi.system.service.IFRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 诊室Controller
 * 
 * @author ruoyi
 * @date 2023-05-30
 */
@RestController
@RequestMapping("/system/room")
public class FRoomController extends BaseController
{
    @Autowired
    private IFRoomService fRoomService;

    /**
     * 查询诊室列表
     */
    @PreAuthorize("@ss.hasPermi('doc:room:list')")
    @GetMapping("/list")
    public TableDataInfo list(FRoom fRoom)
    {
        startPage();
        List<FRoom> list = fRoomService.selectFRoomList(fRoom);
        return getDataTable(list);
    }

    /**
     * 导出诊室列表
     */
    @PreAuthorize("@ss.hasPermi('doc:room:export')")
    @Log(title = "诊室", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FRoom fRoom)
    {
        List<FRoom> list = fRoomService.selectFRoomList(fRoom);
        ExcelUtil<FRoom> util = new ExcelUtil<FRoom>(FRoom.class);
        util.exportExcel(response, list, "诊室数据");
    }

    /**
     * 获取诊室详细信息
     */
    @PreAuthorize("@ss.hasPermi('doc:room:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fRoomService.selectFRoomById(id));
    }

    /**
     * 新增诊室
     */
    @PreAuthorize("@ss.hasPermi('doc:room:add')")
    @Log(title = "诊室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FRoom fRoom)
    {
        return toAjax(fRoomService.insertFRoom(fRoom));
    }

    /**
     * 修改诊室
     */
    @PreAuthorize("@ss.hasPermi('doc:room:edit')")
    @Log(title = "诊室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FRoom fRoom)
    {
        return toAjax(fRoomService.updateFRoom(fRoom));
    }

    /**
     * 删除诊室
     */
    @PreAuthorize("@ss.hasPermi('doc:room:remove')")
    @Log(title = "诊室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fRoomService.deleteFRoomByIds(ids));
    }
}
