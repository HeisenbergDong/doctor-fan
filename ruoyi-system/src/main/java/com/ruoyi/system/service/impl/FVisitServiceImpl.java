package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.FForm;
import com.ruoyi.system.domain.FVisitForm;
import com.ruoyi.system.service.IFFormService;
import com.ruoyi.system.service.IFVisitFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FVisitMapper;
import com.ruoyi.system.domain.FVisit;
import com.ruoyi.system.service.IFVisitService;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    private IFVisitFormService visitFormService;

    @Autowired
    private IFFormService formService;

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
    public List<FVisit> selectFVisitList(FVisit fVisit){
        List<FVisit> visitList = fVisitMapper.selectFVisitList(fVisit);
        if(CollectionUtils.isEmpty(visitList)){
            return visitList;
        }
        /** 查询就诊记录的表单内容 TODO：循环查询容易导致数据库连接数沾满，后期可以优化成in语句 */
        List<FForm> fFormList = new ArrayList<>();
        for(FVisit visit:visitList){
            FVisitForm visitForm = new FVisitForm();
            visitForm.setVisitId(visit.getId());
            List<FVisitForm> visitFormList = visitFormService.selectFVisitFormList(visitForm);
            if(CollectionUtils.isEmpty(visitFormList)){
                continue;
            }
            for(FVisitForm vf:visitFormList){
                FForm form = formService.selectFFormById(vf.getFormId());
                fFormList.add(form);
            }
            visit.setFFormList(fFormList);
        }
        return visitList;
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
