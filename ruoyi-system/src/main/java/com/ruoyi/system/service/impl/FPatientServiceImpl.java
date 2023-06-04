package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FPatientMapper;
import com.ruoyi.system.domain.FPatient;
import com.ruoyi.system.service.IFPatientService;

/**
 * 患者信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FPatientServiceImpl implements IFPatientService 
{
    @Autowired
    private FPatientMapper fPatientMapper;

    /**
     * 查询患者信息
     * 
     * @param id 患者信息主键
     * @return 患者信息
     */
    @Override
    public FPatient selectFPatientById(Long id)
    {
        return fPatientMapper.selectFPatientById(id);
    }

    /**
     * 查询患者信息列表
     * 
     * @param fPatient 患者信息
     * @return 患者信息
     */
    @Override
    public List<FPatient> selectFPatientList(FPatient fPatient)
    {
        return fPatientMapper.selectFPatientList(fPatient);
    }

    /**
     * 新增患者信息
     * 
     * @param fPatient 患者信息
     * @return 结果
     */
    @Override
    public int insertFPatient(FPatient fPatient) {
        fPatient.setCreateTime(DateUtils.getNowDate());
        fPatient.setUpdateTime(DateUtils.getNowDate());
        return fPatientMapper.insertFPatient(fPatient);
    }

    /**
     * 修改患者信息
     * 
     * @param fPatient 患者信息
     * @return 结果
     */
    @Override
    public int updateFPatient(FPatient fPatient)
    {
        fPatient.setUpdateTime(DateUtils.getNowDate());
        return fPatientMapper.updateFPatient(fPatient);
    }

    /**
     * 批量删除患者信息
     * 
     * @param ids 需要删除的患者信息主键
     * @return 结果
     */
    @Override
    public int deleteFPatientByIds(Long[] ids)
    {
        return fPatientMapper.deleteFPatientByIds(ids);
    }

    /**
     * 删除患者信息信息
     * 
     * @param id 患者信息主键
     * @return 结果
     */
    @Override
    public int deleteFPatientById(Long id)
    {
        return fPatientMapper.deleteFPatientById(id);
    }
}
