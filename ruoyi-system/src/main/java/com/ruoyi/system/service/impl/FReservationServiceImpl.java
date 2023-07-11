package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.FPatient;
import com.ruoyi.system.service.IFPatientService;
import com.ruoyi.system.service.ISocketMessageService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FReservationMapper;
import com.ruoyi.system.domain.FReservation;
import com.ruoyi.system.service.IFReservationService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * 预约Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FReservationServiceImpl implements IFReservationService 
{
    @Autowired
    private FReservationMapper fReservationMapper;

    @Autowired
    private IFPatientService patientService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISocketMessageService socketMessageService;

    /**
     * 查询预约
     * 
     * @param id 预约主键
     * @return 预约
     */
    @Override
    public FReservation selectFReservationById(Long id) {
        FReservation fReservation = fReservationMapper.selectFReservationById(id);
        FPatient patient = patientService.selectFPatientById(fReservation.getPatientId());
        fReservation.setLogNo(patient.getLogNo());
        return fReservation;
    }

    /**
     * 查询预约列表
     * 
     * @param fReservation 预约
     * @return 预约
     */
    @Override
    public List<FReservation> selectFReservationList(FReservation fReservation) {
        List<FReservation> reservationList = fReservationMapper.selectFReservationList(fReservation);
        if(CollectionUtils.isEmpty(reservationList)){
            return reservationList;
        }
        for(FReservation reservation: reservationList){
            FPatient patient = patientService.selectFPatientById(reservation.getPatientId());
            reservation.setLogNo(patient.getLogNo());
        }
        return reservationList;
    }

    /**
     * 新增预约
     * 
     * @param fReservation 预约
     * @return 结果
     */
    @Override
    public int insertFReservation(FReservation fReservation){
        /** 校验患者信息和医生信息 */
        checkUser(fReservation);
        /** 校验是否重复预约 */
        checkRepeat(fReservation);

        fReservation.setCreateTime(DateUtils.getNowDate());
        fReservation.setUpdateTime(DateUtils.getNowDate());
        int result = fReservationMapper.insertFReservation(fReservation);
        if(0 != result){
            socketMessageService.sendBroadcast(fReservation.getDocName(),"/topic/reservation",fReservationMapper.selectFReservationById(fReservation.getId()));
        }
        return result;
    }

    private void checkRepeat(FReservation fReservation){
        /** 校验患者信息是否正确 */
        FReservation reservation = new FReservation();
        reservation.setPatientId(fReservation.getPatientId());
        reservation.setPreDate(fReservation.getPreDate());
        List<FReservation> reservationList = fReservationMapper.selectFReservationList(reservation);
        if(!CollectionUtils.isEmpty(reservationList)){
            throw new ServiceException("不能重复预约！");
        }
    }

    private void checkUser(FReservation fReservation){
        /** 校验患者信息是否正确 */
        if(ObjectUtils.isEmpty(patientService.selectFPatientById(fReservation.getPatientId()))){
            throw new ServiceException("患者信息不存在！");
        }
        /** 校验医生信息是否正确 */
        if(ObjectUtils.isEmpty(userService.selectUserById(fReservation.getDocId()))){
            throw new ServiceException("医生信息不存在！");
        }
    }

    /**
     * 修改预约
     * 
     * @param fReservation 预约
     * @return 结果
     */
    @Override
    public int updateFReservation(FReservation fReservation){
        /** 校验患者信息和医生信息 */
        checkUser(fReservation);

        fReservation.setUpdateTime(DateUtils.getNowDate());
        return fReservationMapper.updateFReservation(fReservation);
    }

    /**
     * 批量删除预约
     * 
     * @param ids 需要删除的预约主键
     * @return 结果
     */
    @Override
    public int deleteFReservationByIds(Long[] ids)
    {
        return fReservationMapper.deleteFReservationByIds(ids);
    }

    /**
     * 删除预约信息
     * 
     * @param id 预约主键
     * @return 结果
     */
    @Override
    public int deleteFReservationById(Long id)
    {
        return fReservationMapper.deleteFReservationById(id);
    }
}
