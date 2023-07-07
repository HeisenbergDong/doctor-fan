package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FPointHistoryMapper;
import com.ruoyi.system.domain.FPointHistory;
import com.ruoyi.system.service.IFPointHistoryService;

/**
 * 推荐人折扣积分Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-07
 */
@Service
public class FPointHistoryServiceImpl implements IFPointHistoryService 
{
    @Autowired
    private FPointHistoryMapper fPointHistoryMapper;

    /**
     * 查询推荐人折扣积分
     * 
     * @param id 推荐人折扣积分主键
     * @return 推荐人折扣积分
     */
    @Override
    public FPointHistory selectFPointHistoryById(Long id)
    {
        return fPointHistoryMapper.selectFPointHistoryById(id);
    }

    /**
     * 查询推荐人折扣积分列表
     * 
     * @param fPointHistory 推荐人折扣积分
     * @return 推荐人折扣积分
     */
    @Override
    public List<FPointHistory> selectFPointHistoryList(FPointHistory fPointHistory)
    {
        return fPointHistoryMapper.selectFPointHistoryList(fPointHistory);
    }

    /**
     * 新增推荐人折扣积分
     * 
     * @param fPointHistory 推荐人折扣积分
     * @return 结果
     */
    @Override
    public int insertFPointHistory(FPointHistory fPointHistory)
    {
        return fPointHistoryMapper.insertFPointHistory(fPointHistory);
    }

    /**
     * 修改推荐人折扣积分
     * 
     * @param fPointHistory 推荐人折扣积分
     * @return 结果
     */
    @Override
    public int updateFPointHistory(FPointHistory fPointHistory)
    {
        return fPointHistoryMapper.updateFPointHistory(fPointHistory);
    }

    /**
     * 批量删除推荐人折扣积分
     * 
     * @param ids 需要删除的推荐人折扣积分主键
     * @return 结果
     */
    @Override
    public int deleteFPointHistoryByIds(Long[] ids)
    {
        return fPointHistoryMapper.deleteFPointHistoryByIds(ids);
    }

    /**
     * 删除推荐人折扣积分信息
     * 
     * @param id 推荐人折扣积分主键
     * @return 结果
     */
    @Override
    public int deleteFPointHistoryById(Long id)
    {
        return fPointHistoryMapper.deleteFPointHistoryById(id);
    }
}
