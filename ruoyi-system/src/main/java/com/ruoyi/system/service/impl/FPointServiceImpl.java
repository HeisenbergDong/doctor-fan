package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.common.enums.PointType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.FPatient;
import com.ruoyi.system.domain.FPointValue;
import com.ruoyi.system.service.IFPointValueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FPointMapper;
import com.ruoyi.system.domain.FPoint;
import com.ruoyi.system.service.IFPointService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * 推荐人折扣积分Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FPointServiceImpl implements IFPointService {
    @Autowired
    private FPointMapper fPointMapper;

    @Autowired
    private IFPointValueService pointValueService;

    @Autowired
    private FPatientServiceImpl patientService;

    /**
     * 查询推荐人折扣积分
     * 
     * @param id 推荐人折扣积分主键
     * @return 推荐人折扣积分
     */
    @Override
    public FPoint selectFPointById(Long id)
    {
        return fPointMapper.selectFPointById(id);
    }

    /**
     * 查询推荐人折扣积分列表
     * 
     * @param fPoint 推荐人折扣积分
     * @return 推荐人折扣积分
     */
    @Override
    public List<FPoint> selectFPointList(FPoint fPoint){
        return fPointMapper.selectFPointList(fPoint);
    }

    /**
     * 新增推荐人折扣积分
     * 
     * @param fPoint 推荐人折扣积分
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertFPoint(FPoint fPoint) {
        /** 检查推荐人和被推荐人信息 前端输入推荐人信息，查询是否存在，如果不存在，前端直接调用患者新增接口插入患者信息，如果存在，直接返回推荐人信息*/
        checkPatient(fPoint);

        /** 计算折扣or积分 */
        calculatePoint(fPoint);

        fPoint.setUpdateTime(DateUtils.getNowDate());
        fPoint.setCreateTime(DateUtils.getNowDate());
        int result = fPointMapper.insertFPoint(fPoint);

        /** 计算总镜片数量，同时将最终折扣、积分、镜片数量写入结果表 */
        int glassesNum = 0;
        BigDecimal pointNum = new BigDecimal("0");
        BigDecimal pointScore = new BigDecimal("0");
        FPoint point = new FPoint();
        point.setPointPatientId(fPoint.getPointPatientId());

        point.setPointType(PointType.ZERO.getCode());
        List<FPoint> fPointZeroList = fPointMapper.selectFPointList(point);
        if(!CollectionUtils.isEmpty(fPointZeroList)){
            for(FPoint p:fPointZeroList){
                glassesNum = glassesNum + p.getGlassesNum();
            }
            pointNum = fPointZeroList.get(0).getPointNum();
        }

        point.setPointType(PointType.ONE.getCode());
        List<FPoint> fPointOneList = fPointMapper.selectFPointList(point);
        if(!CollectionUtils.isEmpty(fPointOneList)){
            for(FPoint p:fPointOneList){
                glassesNum = glassesNum + p.getGlassesNum();
            }
            pointScore = fPointOneList.get(0).getPointScore();
        }

        FPointValue pointValue = new FPointValue();
        pointValue.setPointPatientId(fPoint.getPointPatientId());
        List<FPointValue> pointValueList = pointValueService.selectFPointValueList(pointValue);
        if(!CollectionUtils.isEmpty(pointValueList)){
            for(FPointValue fPointValue : pointValueList){
                pointValueService.deleteFPointValueById(fPointValue.getId());
            }
        }
        BeanUtils.copyProperties(fPoint,pointValue);
        pointValue.setGlassesNum(glassesNum);
        pointValue.setPointNum(pointNum);
        pointValue.setPointScore(pointScore);
        pointValueService.insertFPointValue(pointValue);

        return result;
    }

    private void calculatePoint(FPoint fPoint) {
        /** 0-折扣:9-0.25*片数 1-积分:片数*250  */
        FPoint point = new FPoint();
        point.setPointPatientId(fPoint.getPointPatientId());
        point.setPointType(fPoint.getPointType());
        if(PointType.ZERO.getCode().equals(fPoint.getPointType())){
            List<FPoint> pointList = fPointMapper.selectFPointList(point);
            BigDecimal coefficient = new BigDecimal("9");
            coefficient = CollectionUtils.isEmpty(pointList)?coefficient:pointList.get(0).getPointNum();
            BigDecimal b = new BigDecimal("0.25").multiply(new BigDecimal(fPoint.getGlassesNum()));
            fPoint.setPointNum(coefficient.subtract(b).setScale(2,BigDecimal.ROUND_HALF_DOWN));
        }else{
            List<FPoint> pointList = fPointMapper.selectFPointList(point);
            BigDecimal coefficient = new BigDecimal("250");
            coefficient = CollectionUtils.isEmpty(pointList)?coefficient:pointList.get(0).getPointScore();
            fPoint.setPointScore(coefficient.multiply(new BigDecimal(fPoint.getGlassesNum())).setScale(2,BigDecimal.ROUND_HALF_DOWN));
        }
    }

    private void checkPatient(FPoint fPoint) {
        /** 推荐人和被推荐人不能是同一个人 */
        if(fPoint.getNewPatientPhone().equals(fPoint.getPointPatientPhone()) ||
                (!ObjectUtils.isEmpty(fPoint.getNewPatientId())) && fPoint.getNewPatientId().equals(fPoint.getPointPatientId())){
            throw new ServiceException("不能推荐自己！");
        }
        /** 检查被推荐人信息 */
        FPatient pointPatient = new FPatient();
        pointPatient.setPhone(fPoint.getPointPatientPhone());
        pointPatient.setName(fPoint.getPointPatientName());
        pointPatient.setIdCard(fPoint.getPointPatientIdCard());
        List<FPatient> pointPatients = patientService.selectFPatientList(pointPatient);
        if(CollectionUtils.isEmpty(pointPatients)){
            throw new ServiceException("推荐人信息不存在！");
        }else{
            fPoint.setPointPatientId(pointPatients.get(0).getId());
        }
        /** 检查推荐人信息 如果不存在，新建立推荐人 */
        FPatient newPatient = new FPatient();
        newPatient.setPhone(fPoint.getNewPatientPhone());
        newPatient.setName(fPoint.getNewPatientName());
        newPatient.setIdCard(fPoint.getNewPatientIdCard());
        List<FPatient> newPatients = patientService.selectFPatientList(newPatient);
        if(CollectionUtils.isEmpty(newPatients)){
            newPatient.setCreateBy(fPoint.getCreateBy());
            patientService.insertFPatient(newPatient);
            fPoint.setNewPatientId(newPatient.getId());
        }else{
            fPoint.setNewPatientId(newPatients.get(0).getId());
        }
    }

    /**
     * 修改推荐人折扣积分
     * 
     * @param fPoint 推荐人折扣积分
     * @return 结果
     */
    @Override
    public int updateFPoint(FPoint fPoint) {
        fPoint.setUpdateTime(DateUtils.getNowDate());
        return fPointMapper.updateFPoint(fPoint);
    }

    /**
     * 批量删除推荐人折扣积分
     * 
     * @param ids 需要删除的推荐人折扣积分主键
     * @return 结果
     */
    @Override
    public int deleteFPointByIds(Long[] ids)
    {
        return fPointMapper.deleteFPointByIds(ids);
    }

    /**
     * 删除推荐人折扣积分信息
     * 
     * @param id 推荐人折扣积分主键
     * @return 结果
     */
    @Override
    public int deleteFPointById(Long id)
    {
        return fPointMapper.deleteFPointById(id);
    }
}
