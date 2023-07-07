package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FPointHistory;

/**
 * 推荐人折扣积分Service接口
 * 
 * @author ruoyi
 * @date 2023-07-07
 */
public interface IFPointHistoryService 
{
    /**
     * 查询推荐人折扣积分
     * 
     * @param id 推荐人折扣积分主键
     * @return 推荐人折扣积分
     */
    public FPointHistory selectFPointHistoryById(Long id);

    /**
     * 查询推荐人折扣积分列表
     * 
     * @param fPointHistory 推荐人折扣积分
     * @return 推荐人折扣积分集合
     */
    public List<FPointHistory> selectFPointHistoryList(FPointHistory fPointHistory);

    /**
     * 新增推荐人折扣积分
     * 
     * @param fPointHistory 推荐人折扣积分
     * @return 结果
     */
    public int insertFPointHistory(FPointHistory fPointHistory);

    /**
     * 修改推荐人折扣积分
     * 
     * @param fPointHistory 推荐人折扣积分
     * @return 结果
     */
    public int updateFPointHistory(FPointHistory fPointHistory);

    /**
     * 批量删除推荐人折扣积分
     * 
     * @param ids 需要删除的推荐人折扣积分主键集合
     * @return 结果
     */
    public int deleteFPointHistoryByIds(Long[] ids);

    /**
     * 删除推荐人折扣积分信息
     * 
     * @param id 推荐人折扣积分主键
     * @return 结果
     */
    public int deleteFPointHistoryById(Long id);
}
