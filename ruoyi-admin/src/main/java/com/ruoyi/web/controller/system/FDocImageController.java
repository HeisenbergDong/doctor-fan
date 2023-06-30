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
import com.ruoyi.system.domain.FDocImage;
import com.ruoyi.system.service.IFDocImageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医生签名关系Controller
 * 
 * @author ruoyi
 * @date 2023-06-30
 */
@RestController
@RequestMapping("/doc/image")
public class FDocImageController extends BaseController
{
    @Autowired
    private IFDocImageService fDocImageService;

    /**
     * 查询医生签名关系列表
     */
    //@PreAuthorize("@ss.hasPermi('system:image:list')")
    @GetMapping("/list")
    public TableDataInfo list(FDocImage fDocImage)
    {
        startPage();
        List<FDocImage> list = fDocImageService.selectFDocImageList(fDocImage);
        return getDataTable(list);
    }

    /**
     * 导出医生签名关系列表
     */
    //@PreAuthorize("@ss.hasPermi('system:image:export')")
    @Log(title = "医生签名关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FDocImage fDocImage)
    {
        List<FDocImage> list = fDocImageService.selectFDocImageList(fDocImage);
        ExcelUtil<FDocImage> util = new ExcelUtil<FDocImage>(FDocImage.class);
        util.exportExcel(response, list, "医生签名关系数据");
    }

    /**
     * 获取医生签名关系详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:image:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fDocImageService.selectFDocImageById(id));
    }

    /**
     * 新增医生签名关系
     */
    //@PreAuthorize("@ss.hasPermi('system:image:add')")
    @Log(title = "医生签名关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FDocImage fDocImage){
        fDocImage.setCreateBy(getUserId().toString());
        fDocImage.setUpdateBy(getUserId().toString());
        return toAjax(fDocImageService.insertFDocImage(fDocImage));
    }

    /**
     * 修改医生签名关系
     */
    //@PreAuthorize("@ss.hasPermi('system:image:edit')")
    @Log(title = "医生签名关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FDocImage fDocImage){
        fDocImage.setUpdateBy(getUserId().toString());
        return toAjax(fDocImageService.updateFDocImage(fDocImage));
    }

    /**
     * 删除医生签名关系
     */
    //@PreAuthorize("@ss.hasPermi('system:image:remove')")
    @Log(title = "医生签名关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fDocImageService.deleteFDocImageByIds(ids));
    }
}
