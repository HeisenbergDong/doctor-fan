package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.enums.DipatchStatus;
import com.ruoyi.common.enums.RoomNo;
import com.ruoyi.common.enums.YesOrNo;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.FPatient;
import com.ruoyi.system.domain.FVisit;
import com.ruoyi.system.service.IFPatientService;
import com.ruoyi.system.service.IFVisitService;
import com.ruoyi.system.service.ISocketMessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FWaitMapper;
import com.ruoyi.system.domain.FWait;
import com.ruoyi.system.service.IFWaitService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * 排队Service业务层处理
 *
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FWaitServiceImpl implements IFWaitService
{
    @Autowired
    private FWaitMapper fWaitMapper;

    @Autowired
    private IFVisitService visitService;

    @Autowired
    private IFPatientService patientService;

    @Autowired
    private ISocketMessageService socketMessageService;

    /**
     * 查询排队
     *
     * @param id 排队主键
     * @return 排队
     */
    @Override
    public FWait selectFWaitById(Long id)
    {
        return fWaitMapper.selectFWaitById(id);
    }

    /**
     * 查询排队列表
     *
     * @param fWait 排队
     * @return 排队
     */
    @Override
    public List<FWait> selectFWaitList(FWait fWait) {
        List<FWait> waits = fWaitMapper.selectFWaitList(fWait);
        return waits;
    }

    public int insertFWait(FWait fWait){
        fWait.setCreateTime(DateUtils.getNowDate());
        fWait.setUpdateTime(DateUtils.getNowDate());
        return fWaitMapper.insertFWait(fWait);
    }

    /**
     * 指派
     *
     * @param fWait 排队
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int dispatch(FWait fWait){
        /** 相同(患者、诊室、医生、状态)不能重复指派 **/
        FWait w = new FWait();
        w.setPatientId(fWait.getPatientId());
        w.setRoom(fWait.getRoom());
        w.setReceptionDocId(fWait.getReceptionDocId());
        w.setPatientStatus(fWait.getPatientStatus());
        if(!CollectionUtils.isEmpty(fWaitMapper.selectFWaitList(w))){
            throw new ServiceException("不能重复指派！");
        }
        /** 更新原状态为已完成 */
        FWait wait = fWaitMapper.selectFWaitById(fWait.getId());
        if(!ObjectUtils.isEmpty(wait)){
            wait.setPatientStatus(DipatchStatus.TWO.getCode());
            fWaitMapper.updateFWait(wait);
        }
        /** 插入新的队列一条数据 状态为0-排队中 */
        fWait.setParentId(fWait.getId());
        fWait.setCreateTime(DateUtils.getNowDate());
        fWait.setUpdateTime(DateUtils.getNowDate());
        fWait.setPatientStatus(DipatchStatus.ZERO.getCode());
        fWait.setId(null);
        int result = fWaitMapper.insertFWait(fWait);
        if(0 != result){
            socketMessageService.sendBroadcast(fWait.getRoom(),"/topic/game_chat",fWaitMapper.selectFWaitById(fWait.getId()));
        }
        return result;
    }

    /**
     * 叫号
     *
     * @param fWait 排队
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int call(FWait fWait){
        /** 检查医生名下患者是否还有进行中的患者，如果有，不能叫号 */
        FWait w = new FWait();
        w.setReceptionDocId(fWait.getReceptionDocId());
        w.setPatientStatus(DipatchStatus.ONE.getCode());
        w.setDelFlag(YesOrNo.NO.getCode());
        List<FWait> waits = fWaitMapper.selectFWaitList(w);
        if(!CollectionUtils.isEmpty(waits)){
            throw new ServiceException("请检查你名下是否有客人未指派！");
        }
        /** 查询患者是否是新诊患者，方便后期统计 */
        FPatient fPatient = patientService.selectFPatientById(fWait.getPatientId());
        /** 将患者加入到就诊表 */
        FVisit fVisit = new FVisit();
        BeanUtils.copyProperties(fWait,fVisit);
        fVisit.setId(null);
        fVisit.setDocId(fWait.getReceptionDocId());
        fVisit.setDocName(fWait.getReceptionDocName());
        fVisit.setNewPatient(fPatient.getNewPatient());
        fVisit.setVisitTime(DateUtils.getNowDate());
        visitService.insertFVisit(fVisit);
        /** 只可以更新患者状态、排队时间；即只能叫号和调整排队顺序 */
        FWait wait = new FWait();
        BeanUtils.copyProperties(fWait,wait);
        wait.setId(fWait.getId());
        wait.setPatientStatus(DipatchStatus.ONE.getCode());
        wait.setWaitTime(fWait.getWaitTime());
        wait.setUpdateBy(fWait.getUpdateBy());
        wait.setUpdateTime(DateUtils.getNowDate());
        int result = fWaitMapper.updateFWait(wait);
        if(0 == result){
            throw new ServiceException("列表中患者不存在，或者已被其他医生接待！");
        }else{
            socketMessageService.sendBroadcast("1","/queue/1",wait);
        }
        return result;
    }

    /**
     * 批量删除排队
     *
     * @param ids 需要删除的排队主键
     * @return 结果
     */
    @Override
    public int deleteFWaitByIds(Long[] ids)
    {
        return fWaitMapper.deleteFWaitByIds(ids);
    }

    /**
     * 删除排队信息
     *
     * @param id 排队主键
     * @return 结果
     */
    @Override
    public int deleteFWaitById(Long id)
    {
        return fWaitMapper.deleteFWaitById(id);
    }
}
