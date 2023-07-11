package com.ruoyi.system.service.impl;

import java.util.List;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.ruoyi.common.enums.WarningType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FWarningMapper;
import com.ruoyi.system.domain.FWarning;
import com.ruoyi.system.service.IFWarningService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * 提醒Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FWarningServiceImpl implements IFWarningService {
    @Autowired
    private FWarningMapper fWarningMapper;

    /**
     * 查询提醒
     * 
     * @param id 提醒主键
     * @return 提醒
     */
    @Override
    public FWarning selectFWarningById(Long id) {
        FWarning warning = fWarningMapper.selectFWarningById(id);
        warning.setWarningTypeName(warning.getWarningType()== WarningType.ZERO.getCode()?WarningType.ZERO.getInfo():WarningType.ONE.getInfo());
        return warning;
    }

    /**
     * 查询提醒列表
     * 
     * @param fWarning 提醒
     * @return 提醒
     */
    @Override
    public List<FWarning> selectFWarningList(FWarning fWarning) {
        List<FWarning> warnings = fWarningMapper.selectFWarningList(fWarning);
        if(!CollectionUtils.isEmpty(warnings)){
            warnings.forEach(w->{
                w.setWarningTypeName(w.getWarningType()== WarningType.ZERO.getCode()?WarningType.ZERO.getInfo():WarningType.ONE.getInfo());
            });
        }
        return warnings;
    }

    /**
     * 新增提醒
     * 
     * @param fWarning 提醒
     * @return 结果
     */
    @Override
    public int insertFWarning(FWarning fWarning) {
        fWarning.setCreateTime(DateUtils.getNowDate());
        fWarning.setUpdateTime(DateUtils.getNowDate());
        return fWarningMapper.insertFWarning(fWarning);
    }

    @Override
    public int batchFWarning(FWarning fWarning) {
        checkParam(fWarning);
        for(int i = 0; i<= DateUtil.between(fWarning.getStartDate(),fWarning.getEndDate(), DateUnit.DAY); i++){
            fWarning.setWarningDate(DateUtil.offsetDay(fWarning.getStartDate(),i));
            List<FWarning> warningList = fWarningMapper.selectFWarningList(fWarning);
            if(CollectionUtils.isEmpty(warningList)){
                fWarning.setId(null);
                fWarning.setCreateTime(DateUtils.getNowDate());
                fWarning.setUpdateTime(DateUtils.getNowDate());
                fWarningMapper.insertFWarning(fWarning);
            }else{
                warningList.get(0).setWarningDate(fWarning.getWarningDate());
                warningList.get(0).setNum(fWarning.getNum());
                warningList.get(0).setUpdateTime(DateUtils.getNowDate());
                fWarningMapper.updateFWarning(warningList.get(0));
            }
        }
        return 1;
    }

    private void checkParam(FWarning fWarning){
        if(ObjectUtils.isEmpty(fWarning.getStartDate()) || ObjectUtils.isEmpty(fWarning.getEndDate())){
            throw new ServiceException("起始日期和结束日期均不能为空！");
        }
        if(fWarning.getStartDate().after(fWarning.getEndDate())){
            throw new ServiceException("起始日期不能大于结束日期！");
        }
    }

    /**
     * 修改提醒
     * 
     * @param fWarning 提醒
     * @return 结果
     */
    @Override
    public int updateFWarning(FWarning fWarning)
    {
        fWarning.setUpdateTime(DateUtils.getNowDate());
        return fWarningMapper.updateFWarning(fWarning);
    }

    /**
     * 批量删除提醒
     * 
     * @param ids 需要删除的提醒主键
     * @return 结果
     */
    @Override
    public int deleteFWarningByIds(Long[] ids)
    {
        return fWarningMapper.deleteFWarningByIds(ids);
    }

    /**
     * 删除提醒信息
     * 
     * @param id 提醒主键
     * @return 结果
     */
    @Override
    public int deleteFWarningById(Long id)
    {
        return fWarningMapper.deleteFWarningById(id);
    }
}
