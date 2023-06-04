package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FVisitMapper;
import com.ruoyi.system.domain.FVisit;
import com.ruoyi.system.service.IFVisitService;

/**
 * 就诊Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FVisitServiceImpl implements IFVisitService 
{
    @Autowired
    private FVisitMapper fVisitMapper;

    /**
     * 查询就诊
     * 
     * @param id 就诊主键
     * @return 就诊
     */
    @Override
    public FVisit selectFVisitById(Long id)
    {
        return fVisitMapper.selectFVisitById(id);
    }

    /**
     * 查询就诊列表
     * 
     * @param fVisit 就诊
     * @return 就诊
     */
    @Override
    public List<FVisit> selectFVisitList(FVisit fVisit)
    {
        return fVisitMapper.selectFVisitList(fVisit);
    }

    /**
     * 新增就诊
     * 
     * @param fVisit 就诊
     * @return 结果
     */
    @Override
    public int insertFVisit(FVisit fVisit) {
        fVisit.setCreateTime(DateUtils.getNowDate());
        fVisit.setUpdateTime(DateUtils.getNowDate());
        return fVisitMapper.insertFVisit(fVisit);
    }

    /**
     * 修改就诊
     * 
     * @param fVisit 就诊
     * @return 结果
     */
    @Override
    public int updateFVisit(FVisit fVisit)
    {
        fVisit.setUpdateTime(DateUtils.getNowDate());
        return fVisitMapper.updateFVisit(fVisit);
    }

    /**
     * 批量删除就诊
     * 
     * @param ids 需要删除的就诊主键
     * @return 结果
     */
    @Override
    public int deleteFVisitByIds(Long[] ids)
    {
        return fVisitMapper.deleteFVisitByIds(ids);
    }

    /**
     * 删除就诊信息
     * 
     * @param id 就诊主键
     * @return 结果
     */
    @Override
    public int deleteFVisitById(Long id)
    {
        return fVisitMapper.deleteFVisitById(id);
    }
}
