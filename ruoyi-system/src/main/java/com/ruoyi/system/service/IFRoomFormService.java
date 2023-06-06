package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FRoomForm;

/**
 * 诊室和单类型关联关系Service接口
 * 
 * @author ruoyi
 * @date 2023-06-05
 */
public interface IFRoomFormService 
{
    /**
     * 查询诊室和单类型关联关系
     * 
     * @param id 诊室和单类型关联关系主键
     * @return 诊室和单类型关联关系
     */
    public FRoomForm selectFRoomFormById(Long id);

    /**
     * 查询诊室和单类型关联关系列表
     * 
     * @param fRoomForm 诊室和单类型关联关系
     * @return 诊室和单类型关联关系集合
     */
    public List<FRoomForm> selectFRoomFormList(FRoomForm fRoomForm);

    /**
     * 新增诊室和单类型关联关系
     * 
     * @param fRoomForm 诊室和单类型关联关系
     * @return 结果
     */
    public int insertFRoomForm(FRoomForm fRoomForm);

    /**
     * 修改诊室和单类型关联关系
     * 
     * @param fRoomForm 诊室和单类型关联关系
     * @return 结果
     */
    public int updateFRoomForm(FRoomForm fRoomForm);

    /**
     * 批量删除诊室和单类型关联关系
     * 
     * @param ids 需要删除的诊室和单类型关联关系主键集合
     * @return 结果
     */
    public int deleteFRoomFormByIds(Long[] ids);

    /**
     * 删除诊室和单类型关联关系信息
     * 
     * @param id 诊室和单类型关联关系主键
     * @return 结果
     */
    public int deleteFRoomFormById(Long id);
}
