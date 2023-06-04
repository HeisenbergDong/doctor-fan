package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FVisitForm;

/**
 * 问诊单关联Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface FVisitFormMapper 
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
     * 删除问诊单关联
     * 
     * @param id 问诊单关联主键
     * @return 结果
     */
    public int deleteFVisitFormById(Long id);

    /**
     * 批量删除问诊单关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFVisitFormByIds(Long[] ids);
}
