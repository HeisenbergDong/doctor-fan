package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FVisit;

/**
 * 就诊Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFVisitService 
{
    /**
     * 查询就诊
     * 
     * @param id 就诊主键
     * @return 就诊
     */
    public FVisit selectFVisitById(Long id);

    /**
     * 查询就诊列表
     * 
     * @param fVisit 就诊
     * @return 就诊集合
     */
    public List<FVisit> selectFVisitList(FVisit fVisit);

    /**
     * 新增就诊
     * 
     * @param fVisit 就诊
     * @return 结果
     */
    public int insertFVisit(FVisit fVisit);

    /**
     * 修改就诊
     * 
     * @param fVisit 就诊
     * @return 结果
     */
    public int updateFVisit(FVisit fVisit);

    /**
     * 批量删除就诊
     * 
     * @param ids 需要删除的就诊主键集合
     * @return 结果
     */
    public int deleteFVisitByIds(Long[] ids);

    /**
     * 删除就诊信息
     * 
     * @param id 就诊主键
     * @return 结果
     */
    public int deleteFVisitById(Long id);
}
