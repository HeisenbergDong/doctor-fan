package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FFormPhyMapper;
import com.ruoyi.system.domain.FFormPhy;
import com.ruoyi.system.service.IFFormPhyService;

/**
 * 生物测量仪Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Service
public class FFormPhyServiceImpl implements IFFormPhyService 
{
    @Autowired
    private FFormPhyMapper fFormPhyMapper;

    /**
     * 查询生物测量仪
     * 
     * @param id 生物测量仪主键
     * @return 生物测量仪
     */
    @Override
    public FFormPhy selectFFormPhyById(Long id)
    {
        return fFormPhyMapper.selectFFormPhyById(id);
    }

    /**
     * 查询生物测量仪列表
     * 
     * @param fFormPhy 生物测量仪
     * @return 生物测量仪
     */
    @Override
    public List<FFormPhy> selectFFormPhyList(FFormPhy fFormPhy)
    {
        return fFormPhyMapper.selectFFormPhyList(fFormPhy);
    }

    @Override
    public List<FFormPhy> selectDateList(FFormPhy fFormPhy)
    {
        return fFormPhyMapper.selectDateList(fFormPhy);
    }

    /**
     * 新增生物测量仪
     * 
     * @param fFormPhy 生物测量仪
     * @return 结果
     */
    @Override
    public int insertFFormPhy(FFormPhy fFormPhy) {
        fFormPhy.setCreateTime(DateUtils.getNowDate());
        fFormPhy.setUpdateTime(DateUtils.getNowDate());
        return fFormPhyMapper.insertFFormPhy(fFormPhy);
    }

    /**
     * 修改生物测量仪
     * 
     * @param fFormPhy 生物测量仪
     * @return 结果
     */
    @Override
    public int updateFFormPhy(FFormPhy fFormPhy)
    {
        fFormPhy.setUpdateTime(DateUtils.getNowDate());
        return fFormPhyMapper.updateFFormPhy(fFormPhy);
    }

    /**
     * 批量删除生物测量仪
     * 
     * @param ids 需要删除的生物测量仪主键
     * @return 结果
     */
    @Override
    public int deleteFFormPhyByIds(Long[] ids)
    {
        return fFormPhyMapper.deleteFFormPhyByIds(ids);
    }

    /**
     * 删除生物测量仪信息
     * 
     * @param id 生物测量仪主键
     * @return 结果
     */
    @Override
    public int deleteFFormPhyById(Long id)
    {
        return fFormPhyMapper.deleteFFormPhyById(id);
    }
}
