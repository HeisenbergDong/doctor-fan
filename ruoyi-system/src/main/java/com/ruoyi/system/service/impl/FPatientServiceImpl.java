package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FPatientMapper;
import com.ruoyi.system.domain.FPatient;
import com.ruoyi.system.service.IFPatientService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

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
    public FPatient selectFPatientById(Long id) {
        FPatient fPatient = fPatientMapper.selectFPatientById(id);
        /** 通过releaseId查询所有亲属信息 */
        if(ObjectUtils.isEmpty(fPatient)){
            return fPatient;
        }
        List<FPatient> fReleaseList = new ArrayList<>();
        String[] releaseIds = fPatient.getReleaseId().split(",");
        for(String r: releaseIds){
            FPatient patient = fPatientMapper.selectFPatientById(Long.parseLong(r));
            fReleaseList.add(patient);
        }
        fPatient.setFReleaseList(fReleaseList);
        return fPatient;
    }

    /**
     * 查询患者信息列表
     *
     * @param fPatient 患者信息
     * @return 患者信息
     */
    @Override
    public List<FPatient> selectFPatientList(FPatient fPatient) {
        List<FPatient> patientList = fPatientMapper.selectFPatientList(fPatient);
        /** 通过releaseId查询所有亲属信息 */
        for(FPatient p : patientList){
            if(ObjectUtils.isEmpty(p.getReleaseId())){
                continue;
            }
            List<FPatient> fReleaseList = new ArrayList<>();
            String[] releaseIds = p.getReleaseId().split(",");
            for(String r: releaseIds){
                FPatient patient = fPatientMapper.selectFPatientById(Long.parseLong(r));
                fReleaseList.add(patient);
            }
            p.setFReleaseList(fReleaseList);
        }
        return patientList;
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
    public int updateFPatient(FPatient fPatient) {
        /** 如果是新增亲属关系，绑定releaseId、releaseTag,同时将亲属信息新增或更新到表 */
        if(!CollectionUtils.isEmpty(fPatient.getFReleaseList())){
            StringBuilder releaseId = new StringBuilder();
            StringBuilder releaseTag = new StringBuilder();
            for(FPatient release : fPatient.getFReleaseList()){
                if(ObjectUtils.isEmpty(release.getId())){
                    release.setCreateTime(DateUtils.getNowDate());
                    release.setUpdateTime(DateUtils.getNowDate());
                    release.setCreateBy(fPatient.getCreateBy());
                    release.setUpdateBy(fPatient.getUpdateBy());
                    fPatientMapper.insertFPatient(release);
                }else{
                    release.setUpdateTime(DateUtils.getNowDate());
                    release.setUpdateBy(fPatient.getUpdateBy());
                    fPatientMapper.updateFPatient(release);
                }
                releaseId.append(release.getId());
                releaseTag.append(release.getReleaseTag());
                releaseId.append(",");
                releaseTag.append(",");
            }
            fPatient.setReleaseId(releaseId.toString());
            fPatient.setReleaseTag(releaseTag.toString());
        }

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
