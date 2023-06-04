package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FPatient;

/**
 * 患者信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface FPatientMapper
{
    /**
     * 查询患者信息
     * 
     * @param id 患者信息主键
     * @return 患者信息
     */
    FPatient selectFPatientById(Long id);

    /**
     * 查询患者信息列表
     * 
     * @param fPatient 患者信息
     * @return 患者信息集合
     */
    List<FPatient> selectFPatientList(FPatient fPatient);

    /**
     * 新增患者信息
     * 
     * @param fPatient 患者信息
     * @return 结果
     */
    int insertFPatient(FPatient fPatient);

    /**
     * 修改患者信息
     * 
     * @param fPatient 患者信息
     * @return 结果
     */
    int updateFPatient(FPatient fPatient);

    /**
     * 删除患者信息
     * 
     * @param id 患者信息主键
     * @return 结果
     */
    int deleteFPatientById(Long id);

    /**
     * 批量删除患者信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFPatientByIds(Long[] ids);
}
