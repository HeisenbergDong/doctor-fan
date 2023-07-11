package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FRemind;

/**
 * 提醒Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface FRemindMapper
{
    /**
     * 查询提醒
     * 
     * @param id 提醒主键
     * @return 提醒
     */
    FRemind selectFRemindById(Long id);

    /**
     * 查询提醒列表
     * 
     * @param fRemind 提醒
     * @return 提醒集合
     */
    List<FRemind> selectFRemindList(FRemind fRemind);

    /**
     * 新增提醒
     * 
     * @param fRemind 提醒
     * @return 结果
     */
    int insertFRemind(FRemind fRemind);

    /**
     * 修改提醒
     * 
     * @param fRemind 提醒
     * @return 结果
     */
    int updateFRemind(FRemind fRemind);

    /**
     * 删除提醒
     * 
     * @param id 提醒主键
     * @return 结果
     */
    int deleteFRemindById(Long id);

    /**
     * 批量删除提醒
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFRemindByIds(Long[] ids);
}
