package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FRoomFormMapper;
import com.ruoyi.system.domain.FRoomForm;
import com.ruoyi.system.service.IFRoomFormService;

/**
 * 诊室和单类型关联关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-05
 */
@Service
public class FRoomFormServiceImpl implements IFRoomFormService 
{
    @Autowired
    private FRoomFormMapper fRoomFormMapper;

    /**
     * 查询诊室和单类型关联关系
     * 
     * @param id 诊室和单类型关联关系主键
     * @return 诊室和单类型关联关系
     */
    @Override
    public FRoomForm selectFRoomFormById(Long id)
    {
        return fRoomFormMapper.selectFRoomFormById(id);
    }

    /**
     * 查询诊室和单类型关联关系列表
     * 
     * @param fRoomForm 诊室和单类型关联关系
     * @return 诊室和单类型关联关系
     */
    @Override
    public List<FRoomForm> selectFRoomFormList(FRoomForm fRoomForm)
    {
        return fRoomFormMapper.selectFRoomFormList(fRoomForm);
    }

    /**
     * 新增诊室和单类型关联关系
     * 
     * @param fRoomForm 诊室和单类型关联关系
     * @return 结果
     */
    @Override
    public int insertFRoomForm(FRoomForm fRoomForm) {
        fRoomForm.setCreateTime(DateUtils.getNowDate());
        fRoomForm.setUpdateTime(DateUtils.getNowDate());
        return fRoomFormMapper.insertFRoomForm(fRoomForm);
    }

    /**
     * 修改诊室和单类型关联关系
     * 
     * @param fRoomForm 诊室和单类型关联关系
     * @return 结果
     */
    @Override
    public int updateFRoomForm(FRoomForm fRoomForm) {
        fRoomForm.setUpdateTime(DateUtils.getNowDate());
        return fRoomFormMapper.updateFRoomForm(fRoomForm);
    }

    /**
     * 批量删除诊室和单类型关联关系
     * 
     * @param ids 需要删除的诊室和单类型关联关系主键
     * @return 结果
     */
    @Override
    public int deleteFRoomFormByIds(Long[] ids)
    {
        return fRoomFormMapper.deleteFRoomFormByIds(ids);
    }

    /**
     * 删除诊室和单类型关联关系信息
     * 
     * @param id 诊室和单类型关联关系主键
     * @return 结果
     */
    @Override
    public int deleteFRoomFormById(Long id)
    {
        return fRoomFormMapper.deleteFRoomFormById(id);
    }
}
