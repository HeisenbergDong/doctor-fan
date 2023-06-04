package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FWarning;

/**
 * 提醒Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFWarningService 
{
    /**
     * 查询提醒
     * 
     * @param id 提醒主键
     * @return 提醒
     */
    public FWarning selectFWarningById(Long id);

    /**
     * 查询提醒列表
     * 
     * @param fWarning 提醒
     * @return 提醒集合
     */
    public List<FWarning> selectFWarningList(FWarning fWarning);

    /**
     * 新增提醒
     * 
     * @param fWarning 提醒
     * @return 结果
     */
    public int insertFWarning(FWarning fWarning);

    /**
     * 修改提醒
     * 
     * @param fWarning 提醒
     * @return 结果
     */
    public int updateFWarning(FWarning fWarning);

    /**
     * 批量删除提醒
     * 
     * @param ids 需要删除的提醒主键集合
     * @return 结果
     */
    public int deleteFWarningByIds(Long[] ids);

    /**
     * 删除提醒信息
     * 
     * @param id 提醒主键
     * @return 结果
     */
    public int deleteFWarningById(Long id);
}
