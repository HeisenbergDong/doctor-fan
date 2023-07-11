package com.ruoyi.system.service;

import com.ruoyi.system.domain.LtPayWater;

import java.util.List;

/**
 * 支付流水Service接口
 *
 * @author ruoyi
 * @date 2022-03-14
 */
public interface ILtPayWaterService
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

    public int callbackinsertLtPayWater(LtPayWater ltPayWater);

    public int callbackLtPayWater(LtPayWater ltPayWater);

    /**
     * 修改支付流水
     *
     * @param ltPayWater 支付流水
     * @return 结果
     */
    public int updateLtPayWater(LtPayWater ltPayWater);

    /**
     * 批量删除支付流水
     *
     * @param ids 需要删除的支付流水主键集合
     * @return 结果
     */
    public int deleteLtPayWaterByIds(Long[] ids);

    /**
     * 删除支付流水信息
     *
     * @param id 支付流水主键
     * @return 结果
     */
    public int deleteLtPayWaterById(Long id);
}
