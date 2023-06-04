package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FReservation;

/**
 * 预约Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFReservationService 
{
    /**
     * 查询预约
     * 
     * @param id 预约主键
     * @return 预约
     */
    public FReservation selectFReservationById(Long id);

    /**
     * 查询预约列表
     * 
     * @param fReservation 预约
     * @return 预约集合
     */
    public List<FReservation> selectFReservationList(FReservation fReservation);

    /**
     * 新增预约
     * 
     * @param fReservation 预约
     * @return 结果
     */
    public int insertFReservation(FReservation fReservation);

    /**
     * 修改预约
     * 
     * @param fReservation 预约
     * @return 结果
     */
    public int updateFReservation(FReservation fReservation);

    /**
     * 批量删除预约
     * 
     * @param ids 需要删除的预约主键集合
     * @return 结果
     */
    public int deleteFReservationByIds(Long[] ids);

    /**
     * 删除预约信息
     * 
     * @param id 预约主键
     * @return 结果
     */
    public int deleteFReservationById(Long id);
}
