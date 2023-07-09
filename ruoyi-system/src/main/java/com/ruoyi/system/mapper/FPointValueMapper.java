package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FPointValue;

/**
 * 推荐人折扣积分Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public interface FPointValueMapper 
{
    /**
     * 查询推荐人折扣积分
     * 
     * @param id 推荐人折扣积分主键
     * @return 推荐人折扣积分
     */
    public FPointValue selectFPointValueById(Long id);

    /**
     * 查询推荐人折扣积分列表
     * 
     * @param fPointValue 推荐人折扣积分
     * @return 推荐人折扣积分集合
     */
    public List<FPointValue> selectFPointValueList(FPointValue fPointValue);

    /**
     * 新增推荐人折扣积分
     * 
     * @param fPointValue 推荐人折扣积分
     * @return 结果
     */
    public int insertFPointValue(FPointValue fPointValue);

    /**
     * 修改推荐人折扣积分
     * 
     * @param fPointValue 推荐人折扣积分
     * @return 结果
     */
    public int updateFPointValue(FPointValue fPointValue);

    /**
     * 删除推荐人折扣积分
     * 
     * @param id 推荐人折扣积分主键
     * @return 结果
     */
    public int deleteFPointValueById(Long id);

    /**
     * 批量删除推荐人折扣积分
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFPointValueByIds(Long[] ids);
}
