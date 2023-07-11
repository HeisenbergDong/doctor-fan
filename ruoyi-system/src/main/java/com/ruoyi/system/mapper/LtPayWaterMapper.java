package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.LtPayWater;

import java.util.List;

/**
 * 支付流水Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-14
 */
public interface LtPayWaterMapper 
{
    /**
     * 查询支付流水
     * 
     * @param id 支付流水主键
     * @return 支付流水
     */
    public LtPayWater selectLtPayWaterById(Long id);

    /**
     * 查询支付流水列表
     * 
     * @param ltPayWater 支付流水
     * @return 支付流水集合
     */
    public List<LtPayWater> selectLtPayWaterList(LtPayWater ltPayWater);

    /**
     * 新增支付流水
     * 
     * @param ltPayWater 支付流水
     * @return 结果
     */
    public int insertLtPayWater(LtPayWater ltPayWater);

    /**
     * 修改支付流水
     * 
     * @param ltPayWater 支付流水
     * @return 结果
     */
    public int updateLtPayWater(LtPayWater ltPayWater);

    /**
     * 删除支付流水
     * 
     * @param id 支付流水主键
     * @return 结果
     */
    public int deleteLtPayWaterById(Long id);

    /**
     * 批量删除支付流水
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLtPayWaterByIds(Long[] ids);
}
