package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FVisitForm;

/**
 * 问诊单关联Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFVisitFormService 
{
    /**
     * 查询问诊单关联
     * 
     * @param id 问诊单关联主键
     * @return 问诊单关联
     */
    public FVisitForm selectFVisitFormById(Long id);

    /**
     * 查询问诊单关联列表
     * 
     * @param fVisitForm 问诊单关联
     * @return 问诊单关联集合
     */
    public List<FVisitForm> selectFVisitFormList(FVisitForm fVisitForm);

    /**
     * 新增问诊单关联
     * 
     * @param fVisitForm 问诊单关联
     * @return 结果
     */
    public int insertFVisitForm(FVisitForm fVisitForm);

    /**
     * 修改问诊单关联
     * 
     * @param fVisitForm 问诊单关联
     * @return 结果
     */
    public int updateFVisitForm(FVisitForm fVisitForm);

    /**
     * 批量删除问诊单关联
     * 
     * @param ids 需要删除的问诊单关联主键集合
     * @return 结果
     */
    public int deleteFVisitFormByIds(Long[] ids);

    /**
     * 删除问诊单关联信息
     * 
     * @param id 问诊单关联主键
     * @return 结果
     */
    public int deleteFVisitFormById(Long id);
}
