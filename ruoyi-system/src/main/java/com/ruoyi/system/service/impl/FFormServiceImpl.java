package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FFormMapper;
import com.ruoyi.system.domain.FForm;
import com.ruoyi.system.service.IFFormService;

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
    public int insertFForm(FForm fForm) {
        fForm.setCreateTime(DateUtils.getNowDate());
        fForm.setUpdateTime(DateUtils.getNowDate());
        return fFormMapper.insertFForm(fForm);
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
