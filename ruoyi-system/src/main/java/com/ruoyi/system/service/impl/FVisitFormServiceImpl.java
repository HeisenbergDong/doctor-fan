package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FVisitFormMapper;
import com.ruoyi.system.domain.FVisitForm;
import com.ruoyi.system.service.IFVisitFormService;

/**
 * 问诊单关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FVisitFormServiceImpl implements IFVisitFormService 
{
    @Autowired
    private FVisitFormMapper fVisitFormMapper;

    /**
     * 查询问诊单关联
     * 
     * @param id 问诊单关联主键
     * @return 问诊单关联
     */
    @Override
    public FVisitForm selectFVisitFormById(Long id)
    {
        return fVisitFormMapper.selectFVisitFormById(id);
    }

    /**
     * 查询问诊单关联列表
     * 
     * @param fVisitForm 问诊单关联
     * @return 问诊单关联
     */
    @Override
    public List<FVisitForm> selectFVisitFormList(FVisitForm fVisitForm)
    {
        return fVisitFormMapper.selectFVisitFormList(fVisitForm);
    }

    /**
     * 新增问诊单关联
     * 
     * @param fVisitForm 问诊单关联
     * @return 结果
     */
    @Override
    public int insertFVisitForm(FVisitForm fVisitForm)
    {
        return fVisitFormMapper.insertFVisitForm(fVisitForm);
    }

    /**
     * 修改问诊单关联
     * 
     * @param fVisitForm 问诊单关联
     * @return 结果
     */
    @Override
    public int updateFVisitForm(FVisitForm fVisitForm)
    {
        return fVisitFormMapper.updateFVisitForm(fVisitForm);
    }

    /**
     * 批量删除问诊单关联
     * 
     * @param ids 需要删除的问诊单关联主键
     * @return 结果
     */
    @Override
    public int deleteFVisitFormByIds(Long[] ids)
    {
        return fVisitFormMapper.deleteFVisitFormByIds(ids);
    }

    /**
     * 删除问诊单关联信息
     * 
     * @param id 问诊单关联主键
     * @return 结果
     */
    @Override
    public int deleteFVisitFormById(Long id)
    {
        return fVisitFormMapper.deleteFVisitFormById(id);
    }
}
