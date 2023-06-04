package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FRemind;

/**
 * 提醒Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFRemindService 
{
    /**
     * 查询提醒
     * 
     * @param id 提醒主键
     * @return 提醒
     */
    public FRemind selectFRemindById(Long id);

    /**
     * 查询提醒列表
     * 
     * @param fRemind 提醒
     * @return 提醒集合
     */
    public List<FRemind> selectFRemindList(FRemind fRemind);

    /**
     * 新增提醒
     * 
     * @param fRemind 提醒
     * @return 结果
     */
    public int insertFRemind(FRemind fRemind);

    /**
     * 修改提醒
     * 
     * @param fRemind 提醒
     * @return 结果
     */
    public int updateFRemind(FRemind fRemind);

    /**
     * 批量删除提醒
     * 
     * @param ids 需要删除的提醒主键集合
     * @return 结果
     */
    public int deleteFRemindByIds(Long[] ids);

    /**
     * 删除提醒信息
     * 
     * @param id 提醒主键
     * @return 结果
     */
    public int deleteFRemindById(Long id);
}
