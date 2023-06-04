package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FVisit;

/**
 * 就诊Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface FVisitMapper
{
    /**
     * 查询就诊
     * 
     * @param id 就诊主键
     * @return 就诊
     */
    FVisit selectFVisitById(Long id);

    /**
     * 查询就诊列表
     * 
     * @param fVisit 就诊
     * @return 就诊集合
     */
    List<FVisit> selectFVisitList(FVisit fVisit);

    /**
     * 新增就诊
     * 
     * @param fVisit 就诊
     * @return 结果
     */
    int insertFVisit(FVisit fVisit);

    /**
     * 修改就诊
     * 
     * @param fVisit 就诊
     * @return 结果
     */
    int updateFVisit(FVisit fVisit);

    /**
     * 删除就诊
     * 
     * @param id 就诊主键
     * @return 结果
     */
    int deleteFVisitById(Long id);

    /**
     * 批量删除就诊
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFVisitByIds(Long[] ids);
}
