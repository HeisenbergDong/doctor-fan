package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.LtPayWater;
import com.ruoyi.system.mapper.LtPayWaterMapper;
import com.ruoyi.system.service.ILtPayWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ruoyi.common.utils.SecurityUtils.getUserId;

/**
 * 支付流水Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-14
 */
@Service
public class LtPayWaterServiceImpl implements ILtPayWaterService
{
    @Autowired
    private LtPayWaterMapper ltPayWaterMapper;

    /**
     * 查询支付流水
     *
     * @param id 支付流水主键
     * @return 支付流水
     */
    @Override
    public LtPayWater selectLtPayWaterById(Long id)
    {
        return ltPayWaterMapper.selectLtPayWaterById(id);
    }

    /**
     * 查询支付流水列表
     *
     * @param ltPayWater 支付流水
     * @return 支付流水
     */
    @Override
    public List<LtPayWater> selectLtPayWaterList(LtPayWater ltPayWater)
    {
        return ltPayWaterMapper.selectLtPayWaterList(ltPayWater);
    }

    /**
     * 新增支付流水
     *
     * @param ltPayWater 支付流水
     * @return 结果
     */
    @Override
    public int insertLtPayWater(LtPayWater ltPayWater)
    {
        ltPayWater.setCreateTime(DateUtils.getNowDate());
        ltPayWater.setCreateBy(getUserId()+"");
        ltPayWater.setPayTime(DateUtils.getNowDate());
        return ltPayWaterMapper.insertLtPayWater(ltPayWater);
    }

    @Override
    public int callbackinsertLtPayWater(LtPayWater ltPayWater)
    {
        ltPayWater.setCreateTime(DateUtils.getNowDate());
        ltPayWater.setPayTime(DateUtils.getNowDate());
        return ltPayWaterMapper.insertLtPayWater(ltPayWater);
    }

    /**
     * 新增支付流水-三方
     *
     * @param ltPayWater 支付流水
     * @return 结果
     */
    @Override
    public int callbackLtPayWater(LtPayWater ltPayWater)
    {
        ltPayWater.setCreateTime(DateUtils.getNowDate());
        ltPayWater.setPayTime(DateUtils.getNowDate());
        return ltPayWaterMapper.insertLtPayWater(ltPayWater);
    }

    /**
     * 修改支付流水
     *
     * @param ltPayWater 支付流水
     * @return 结果
     */
    @Override
    public int updateLtPayWater(LtPayWater ltPayWater)
    {
        ltPayWater.setUpdateTime(DateUtils.getNowDate());
        ltPayWater.setUpdateBy(getUserId()+"");
        return ltPayWaterMapper.updateLtPayWater(ltPayWater);
    }

    /**
     * 批量删除支付流水
     *
     * @param ids 需要删除的支付流水主键
     * @return 结果
     */
    @Override
    public int deleteLtPayWaterByIds(Long[] ids)
    {
        return ltPayWaterMapper.deleteLtPayWaterByIds(ids);
    }

    /**
     * 删除支付流水信息
     *
     * @param id 支付流水主键
     * @return 结果
     */
    @Override
    public int deleteLtPayWaterById(Long id)
    {
        return ltPayWaterMapper.deleteLtPayWaterById(id);
    }
}
