package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FPoint;

/**
 * 推荐人折扣积分Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFPointService {
    /**
     * 查询推荐人折扣积分
     * 
     * @param id 推荐人折扣积分主键
     * @return 推荐人折扣积分
     */
    FPoint selectFPointById(Long id);

    /**
     * 查询推荐人折扣积分列表
     * 
     * @param fPoint 推荐人折扣积分
     * @return 推荐人折扣积分集合
     */
    List<FPoint> selectFPointList(FPoint fPoint);

    /**
     * 新增推荐人折扣积分
     * 
     * @param fPoint 推荐人折扣积分
     * @return 结果
     */
    int insertFPoint(FPoint fPoint);

    /**
     * 修改推荐人折扣积分
     * 
     * @param fPoint 推荐人折扣积分
     * @return 结果
     */
    int updateFPoint(FPoint fPoint);

    /**
     * 批量删除推荐人折扣积分
     * 
     * @param ids 需要删除的推荐人折扣积分主键集合
     * @return 结果
     */
    int deleteFPointByIds(Long[] ids);

    /**
     * 删除推荐人折扣积分信息
     * 
     * @param id 推荐人折扣积分主键
     * @return 结果
     */
    int deleteFPointById(Long id);
}
