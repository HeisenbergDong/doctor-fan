package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FDocImageMapper;
import com.ruoyi.system.domain.FDocImage;
import com.ruoyi.system.service.IFDocImageService;

/**
 * 医生签名关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-30
 */
@Service
public class FDocImageServiceImpl implements IFDocImageService 
{
    @Autowired
    private FDocImageMapper fDocImageMapper;

    /**
     * 查询医生签名关系
     * 
     * @param id 医生签名关系主键
     * @return 医生签名关系
     */
    @Override
    public FDocImage selectFDocImageById(Long id)
    {
        return fDocImageMapper.selectFDocImageById(id);
    }

    /**
     * 查询医生签名关系列表
     * 
     * @param fDocImage 医生签名关系
     * @return 医生签名关系
     */
    @Override
    public List<FDocImage> selectFDocImageList(FDocImage fDocImage)
    {
        return fDocImageMapper.selectFDocImageList(fDocImage);
    }

    /**
     * 新增医生签名关系
     * 
     * @param fDocImage 医生签名关系
     * @return 结果
     */
    @Override
    public int insertFDocImage(FDocImage fDocImage){
        fDocImage.setCreateTime(DateUtils.getNowDate());
        fDocImage.setUpdateTime(DateUtils.getNowDate());
        return fDocImageMapper.insertFDocImage(fDocImage);
    }

    /**
     * 修改医生签名关系
     * 
     * @param fDocImage 医生签名关系
     * @return 结果
     */
    @Override
    public int updateFDocImage(FDocImage fDocImage){
        fDocImage.setUpdateTime(DateUtils.getNowDate());
        return fDocImageMapper.updateFDocImage(fDocImage);
    }

    /**
     * 批量删除医生签名关系
     * 
     * @param ids 需要删除的医生签名关系主键
     * @return 结果
     */
    @Override
    public int deleteFDocImageByIds(Long[] ids)
    {
        return fDocImageMapper.deleteFDocImageByIds(ids);
    }

    /**
     * 删除医生签名关系信息
     * 
     * @param id 医生签名关系主键
     * @return 结果
     */
    @Override
    public int deleteFDocImageById(Long id)
    {
        return fDocImageMapper.deleteFDocImageById(id);
    }
}
