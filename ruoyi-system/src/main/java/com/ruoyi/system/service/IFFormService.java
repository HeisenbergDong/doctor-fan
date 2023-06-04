package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FForm;

/**
 * 单Service接口
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
public interface IFFormService 
{
    /**
     * 查询单
     * 
     * @param id 单主键
     * @return 单
     */
    public FForm selectFFormById(Long id);

    /**
     * 查询单列表
     * 
     * @param fForm 单
     * @return 单集合
     */
    public List<FForm> selectFFormList(FForm fForm);

    /**
     * 新增单
     * 
     * @param fForm 单
     * @return 结果
     */
    public int insertFForm(FForm fForm);

    /**
     * 修改单
     * 
     * @param fForm 单
     * @return 结果
     */
    public int updateFForm(FForm fForm);

    /**
     * 批量删除单
     * 
     * @param ids 需要删除的单主键集合
     * @return 结果
     */
    public int deleteFFormByIds(Long[] ids);

    /**
     * 删除单信息
     * 
     * @param id 单主键
     * @return 结果
     */
    public int deleteFFormById(Long id);
}
