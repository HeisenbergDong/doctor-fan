package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FPointValue;

/**
 * 推荐人折扣积分Service接口
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public interface IFPointValueService
{
    /**
     * 查询推荐人折扣积分
     * 
     * @param id 推荐人折扣积分主键
     * @return 推荐人折扣积分
     */
    FPointValue selectFPointValueById(Long id);

    /**
     * 查询推荐人折扣积分列表
     * 
     * @param fPointValue 推荐人折扣积分
     * @return 推荐人折扣积分集合
     */
    List<FPointValue> selectFPointValueList(FPointValue fPointValue);

    /**
     * 新增推荐人折扣积分
     * 
     * @param fPointValue 推荐人折扣积分
     * @return 结果
     */
    int insertFPointValue(FPointValue fPointValue);

    /**
     * 修改推荐人折扣积分
     * 
     * @param fPointValue 推荐人折扣积分
     * @return 结果
     */
    int updateFPointValue(FPointValue fPointValue);

    /**
     * 批量删除推荐人折扣积分
     * 
     * @param ids 需要删除的推荐人折扣积分主键集合
     * @return 结果
     */
    int deleteFPointValueByIds(Long[] ids);

    /**
     * 删除推荐人折扣积分信息
     * 
     * @param id 推荐人折扣积分主键
     * @return 结果
     */
    int deleteFPointValueById(Long id);
}
