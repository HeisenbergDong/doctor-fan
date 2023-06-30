package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FDocImage;

/**
 * 医生签名关系Service接口
 * 
 * @author ruoyi
 * @date 2023-06-30
 */
public interface IFDocImageService 
{
    /**
     * 查询医生签名关系
     * 
     * @param id 医生签名关系主键
     * @return 医生签名关系
     */
    public FDocImage selectFDocImageById(Long id);

    /**
     * 查询医生签名关系列表
     * 
     * @param fDocImage 医生签名关系
     * @return 医生签名关系集合
     */
    public List<FDocImage> selectFDocImageList(FDocImage fDocImage);

    /**
     * 新增医生签名关系
     * 
     * @param fDocImage 医生签名关系
     * @return 结果
     */
    public int insertFDocImage(FDocImage fDocImage);

    /**
     * 修改医生签名关系
     * 
     * @param fDocImage 医生签名关系
     * @return 结果
     */
    public int updateFDocImage(FDocImage fDocImage);

    /**
     * 批量删除医生签名关系
     * 
     * @param ids 需要删除的医生签名关系主键集合
     * @return 结果
     */
    public int deleteFDocImageByIds(Long[] ids);

    /**
     * 删除医生签名关系信息
     * 
     * @param id 医生签名关系主键
     * @return 结果
     */
    public int deleteFDocImageById(Long id);
}
