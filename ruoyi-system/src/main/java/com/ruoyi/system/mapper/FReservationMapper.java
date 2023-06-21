package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FReservation;

/**
 * 预约Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface FReservationMapper
{
    /**
     * 查询预约
     * 
     * @param id 预约主键
     * @return 预约
     */
    FReservation selectFReservationById(Long id);

    /**
     * 查询预约列表
     * 
     * @param fReservation 预约
     * @return 预约集合
     */
    List<FReservation> selectFReservationList(FReservation fReservation);

    /**
     * 新增预约
     * 
     * @param fReservation 预约
     * @return 结果
     */
    int insertFReservation(FReservation fReservation);

    /**
     * 修改预约
     * 
     * @param fReservation 预约
     * @return 结果
     */
    int updateFReservation(FReservation fReservation);

    /**
     * 删除预约
     * 
     * @param id 预约主键
     * @return 结果
     */
    int deleteFReservationById(Long id);

    /**
     * 批量删除预约
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFReservationByIds(Long[] ids);
}
