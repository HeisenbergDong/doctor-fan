package com.ruoyi.system.service.impl;

import java.text.ParseException;
import java.util.List;

import com.ruoyi.common.enums.DipatchStatus;
import com.ruoyi.common.enums.RoomNo;
import com.ruoyi.common.enums.YesOrNo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.FPatient;
import com.ruoyi.system.domain.FReservation;
import com.ruoyi.system.domain.FWait;
import com.ruoyi.system.service.IFPatientService;
import com.ruoyi.system.service.IFReservationService;
import com.ruoyi.system.service.IFWaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FRegMapper;
import com.ruoyi.system.domain.FReg;
import com.ruoyi.system.service.IFRegService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 挂号Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FRegServiceImpl implements IFRegService 
{
    @Autowired
    private FRegMapper fRegMapper;

    @Autowired
    private IFPatientService fPatientService;

    @Autowired
    private IFReservationService fReservationService;

    @Autowired
    private IFWaitService waitService;

    /**
     * 查询挂号
     * 
     * @param id 挂号主键
     * @return 挂号
     */
    @Override
    public FReg selectFRegById(Long id)
    {
        return fRegMapper.selectFRegById(id);
    }

    /**
     * 查询挂号列表
     * 
     * @param fReg 挂号
     * @return 挂号
     */
    @Override
    public List<FReg> selectFRegList(FReg fReg)
    {
        return fRegMapper.selectFRegList(fReg);
    }

    /**
     * 新增挂号
     * 
     * @param fReg 挂号
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public FReg insertFReg(FReg fReg){
        FPatient patient = new FPatient();
        patient.setPhone(fReg.getPhone());
        patient.setName(fReg.getName());
        List<FPatient> patients = fPatientService.selectFPatientList(patient);
        /** 如果是空，表示是新患者，插入患者信息 ；如果不是空，说明是再次就诊，更新患者新消息为不是新患者*/
        if (CollectionUtils.isEmpty(patients)) {
            patient.setNewPatient(YesOrNo.YES.getCode());
            patient.setIdCard(fReg.getIdCard());
            patient.setBlack(YesOrNo.NO.getCode());
            patient.setCreateTime(DateUtils.getNowDate());
            patient.setCreateBy(fReg.getCreateBy());
            patient.setUpdateTime(DateUtils.getNowDate());
            patient.setUpdateBy(fReg.getUpdateBy());
            fPatientService.insertFPatient(patient);
        }else{
            patient = patients.get(0);
            patient.setNewPatient(YesOrNo.NO.getCode());
            patient.setUpdateBy(fReg.getUpdateBy());
            fPatientService.updateFPatient(patient);
            /** 判断是否预约 如果已预约更新为已完成  如果不是预约日期不做处理*/
            FReservation reservation = new FReservation();
            reservation.setPatientId(patients.get(0).getId());
            try {
                reservation.setPreDate(DateUtils.parseDate(DateUtils.getDate(),DateUtils.YYYY_MM_DD));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            List<FReservation> reservations = fReservationService.selectFReservationList(reservation);
            if(!CollectionUtils.isEmpty(reservations)){
                reservations.forEach(r->{
                    fReservationService.updateFReservation(r);
                });
            }
        }
        /** 生成编号 日期+5位顺序号 + 前端输入的内容 */
        fReg.setRegNo(generatorRegNo(fReg.getRegNo()));
        fReg.setCreateTime(DateUtils.getNowDate());
        fReg.setUpdateTime(DateUtils.getNowDate());
        fRegMapper.insertFReg(fReg);
        FReg reg = fRegMapper.selectFRegById(fReg.getId());
        /** 挂号成功将患者自动放入分诊队列 */
        FWait fWait = new FWait();
        fWait.setRegNo(fReg.getRegNo());
        fWait.setAssignDocId(Long.parseLong(reg.getCreateBy()));
        fWait.setPatientId(patient.getId());
        fWait.setPatientName(patient.getName());
        fWait.setPatientPhone(patient.getPhone());
        fWait.setRoom(RoomNo.DISPATCH_1.getInfo());
        fWait.setPatientStatus(DipatchStatus.ZERO.getCode());
        fWait.setWaitTime(DateUtils.getTime());
        fWait.setCreateBy(reg.getCreateBy());
        fWait.setUpdateBy(reg.getUpdateBy());
        fWait.setUpdateTime(DateUtils.getNowDate());
        waitService.insertFWait(fWait);
        return reg;
    }

    /**
     * TODO：并发会有问题，暂时不用管
     * @param no
     * @return
     */
    private String generatorRegNo(String no){
        FReg fReg = fRegMapper.selectRegByMaxNo();
        String regNo = fReg==null||fReg.getRegNo()==null?DateUtils.getDate()+"00001":DateUtils.getDate() + String.format("%05d",Long.parseLong(fReg.getRegNo().substring(10,15)) + 1);
        return regNo + no;
    }

    /**
     * 修改挂号
     * 
     * @param fReg 挂号
     * @return 结果
     */
    @Override
    public int updateFReg(FReg fReg)
    {
        fReg.setUpdateTime(DateUtils.getNowDate());
        return fRegMapper.updateFReg(fReg);
    }

    /**
     * 批量删除挂号
     * 
     * @param ids 需要删除的挂号主键
     * @return 结果
     */
    @Override
    public int deleteFRegByIds(Long[] ids)
    {
        return fRegMapper.deleteFRegByIds(ids);
    }

    /**
     * 删除挂号信息
     * 
     * @param id 挂号主键
     * @return 结果
     */
    @Override
    public int deleteFRegById(Long id)
    {
        return fRegMapper.deleteFRegById(id);
    }
}
