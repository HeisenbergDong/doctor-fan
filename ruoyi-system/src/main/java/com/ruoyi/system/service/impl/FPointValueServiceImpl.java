package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FPointValueMapper;
import com.ruoyi.system.domain.FPointValue;
import com.ruoyi.system.service.IFPointValueService;

/**
 * 推荐人折扣积分Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Service
public class FPointValueServiceImpl implements IFPointValueService 
{
    @Autowired
    private FPointValueMapper fPointValueMapper;

    /**
     * 查询推荐人折扣积分
     * 
     * @param id 推荐人折扣积分主键
     * @return 推荐人折扣积分
     */
    @Override
    public FPointValue selectFPointValueById(Long id)
    {
        return fPointValueMapper.selectFPointValueById(id);
    }

    /**
     * 查询推荐人折扣积分列表
     * 
     * @param fPointValue 推荐人折扣积分
     * @return 推荐人折扣积分
     */
    @Override
    public List<FPointValue> selectFPointValueList(FPointValue fPointValue)
    {
        return fPointValueMapper.selectFPointValueList(fPointValue);
    }

    /**
     * 新增推荐人折扣积分
     * 
     * @param fPointValue 推荐人折扣积分
     * @return 结果
     */
    @Override
    public int insertFPointValue(FPointValue fPointValue)
    {
        fPointValue.setCreateTime(DateUtils.getNowDate());
        return fPointValueMapper.insertFPointValue(fPointValue);
    }

    /**
     * 修改推荐人折扣积分
     * 
     * @param fPointValue 推荐人折扣积分
     * @return 结果
     */
    @Override
    public int updateFPointValue(FPointValue fPointValue)
    {
        fPointValue.setUpdateTime(DateUtils.getNowDate());
        return fPointValueMapper.updateFPointValue(fPointValue);
    }

    /**
     * 批量删除推荐人折扣积分
     * 
     * @param ids 需要删除的推荐人折扣积分主键
     * @return 结果
     */
    @Override
    public int deleteFPointValueByIds(Long[] ids)
    {
        return fPointValueMapper.deleteFPointValueByIds(ids);
    }

    /**
     * 删除推荐人折扣积分信息
     * 
     * @param id 推荐人折扣积分主键
     * @return 结果
     */
    @Override
    public int deleteFPointValueById(Long id)
    {
        return fPointValueMapper.deleteFPointValueById(id);
    }
}
