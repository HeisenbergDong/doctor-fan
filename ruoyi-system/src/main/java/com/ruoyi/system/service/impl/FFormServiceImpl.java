package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.FVisitForm;
import com.ruoyi.system.mapper.FVisitFormMapper;
import com.ruoyi.system.service.IFVisitFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FFormMapper;
import com.ruoyi.system.domain.FForm;
import com.ruoyi.system.service.IFFormService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@Service
public class FFormServiceImpl implements IFFormService {
    @Autowired
    private FFormMapper fFormMapper;

    @Autowired
    private IFVisitFormService visitFormService;

    /**
     * 查询单
     * 
     * @param id 单主键
     * @return 单
     */
    @Override
    public FForm selectFFormById(Long id)
    {
        return fFormMapper.selectFFormById(id);
    }

    /**
     * 查询单列表
     * 
     * @param fForm 单
     * @return 单
     */
    @Override
    public List<FForm> selectFFormList(FForm fForm)
    {
        return fFormMapper.selectFFormList(fForm);
    }

    /**
     * 新增单
     * 
     * @param fForm 单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertFForm(FForm fForm) {
        fForm.setCreateTime(DateUtils.getNowDate());
        fForm.setUpdateTime(DateUtils.getNowDate());
        int result = fFormMapper.insertFForm(fForm);
        /** 建立问诊单和表单关联关系 */
        FVisitForm visitForm = new FVisitForm();
        visitForm.setFormId(fForm.getId());
        visitForm.setVisitId(fForm.getVisitId());
        visitFormService.insertFVisitForm(visitForm);
        return result;
    }

    /**
     * 修改单
     * 
     * @param fForm 单
     * @return 结果
     */
    @Override
    public int updateFForm(FForm fForm) {
        fForm.setUpdateTime(DateUtils.getNowDate());
        return fFormMapper.updateFForm(fForm);
    }

    /**
     * 批量删除单
     * 
     * @param ids 需要删除的单主键
     * @return 结果
     */
    @Override
    public int deleteFFormByIds(Long[] ids)
    {
        return fFormMapper.deleteFFormByIds(ids);
    }

    /**
     * 删除单信息
     * 
     * @param id 单主键
     * @return 结果
     */
    @Override
    public int deleteFFormById(Long id)
    {
        return fFormMapper.deleteFFormById(id);
    }
}
