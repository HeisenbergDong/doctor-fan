package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.FReservation;
import com.ruoyi.system.service.IFPatientService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FRemindMapper;
import com.ruoyi.system.domain.FRemind;
import com.ruoyi.system.service.IFRemindService;
import org.springframework.util.ObjectUtils;

/**
 * 提醒Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FRemindServiceImpl implements IFRemindService 
{
    @Autowired
    private FRemindMapper fRemindMapper;

    @Autowired
    private IFPatientService patientService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询提醒
     * 
     * @param id 提醒主键
     * @return 提醒
     */
    @Override
    public FRemind selectFRemindById(Long id)
    {
        return fRemindMapper.selectFRemindById(id);
    }

    /**
     * 查询提醒列表
     * 
     * @param fRemind 提醒
     * @return 提醒
     */
    @Override
    public List<FRemind> selectFRemindList(FRemind fRemind)
    {
        return fRemindMapper.selectFRemindList(fRemind);
    }

    /**
     * 新增提醒
     * 
     * @param fRemind 提醒
     * @return 结果
     */
    @Override
    public int insertFRemind(FRemind fRemind) {
        /** 校验患者信息和医生信息 */
        checkUser(fRemind);

        fRemind.setCreateTime(DateUtils.getNowDate());
        fRemind.setUpdateTime(DateUtils.getNowDate());
        return fRemindMapper.insertFRemind(fRemind);
    }

    private void checkUser(FRemind fRemind){
        /** 校验患者信息是否正确 */
        if(ObjectUtils.isEmpty(patientService.selectFPatientById(fRemind.getPatientId()))){
            throw new ServiceException("患者信息不存在！");
        }
        /** 校验医生信息是否正确 */
        if(ObjectUtils.isEmpty(userService.selectUserById(fRemind.getDocId()))){
            throw new ServiceException("医生信息不存在！");
        }
    }

    /**
     * 修改提醒
     * 
     * @param fRemind 提醒
     * @return 结果
     */
    @Override
    public int updateFRemind(FRemind fRemind) {
        /** 校验患者信息和医生信息 */
        checkUser(fRemind);

        fRemind.setUpdateTime(DateUtils.getNowDate());
        return fRemindMapper.updateFRemind(fRemind);
    }

    /**
     * 批量删除提醒
     * 
     * @param ids 需要删除的提醒主键
     * @return 结果
     */
    @Override
    public int deleteFRemindByIds(Long[] ids)
    {
        return fRemindMapper.deleteFRemindByIds(ids);
    }

    /**
     * 删除提醒信息
     * 
     * @param id 提醒主键
     * @return 结果
     */
    @Override
    public int deleteFRemindById(Long id)
    {
        return fRemindMapper.deleteFRemindById(id);
    }
}
