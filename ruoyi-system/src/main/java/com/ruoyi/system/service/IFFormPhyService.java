package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FFormPhy;

/**
 * 生物测量仪Service接口
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public interface IFFormPhyService
{
    /**
     * 查询生物测量仪
     * 
     * @param id 生物测量仪主键
     * @return 生物测量仪
     */
    FFormPhy selectFFormPhyById(Long id);

    /**
     * 查询生物测量仪列表
     * 
     * @param fFormPhy 生物测量仪
     * @return 生物测量仪集合
     */
    List<FFormPhy> selectFFormPhyList(FFormPhy fFormPhy);

    List<FFormPhy> selectDateList(FFormPhy fFormPhy);

    /**
     * 新增生物测量仪
     * 
     * @param fFormPhy 生物测量仪
     * @return 结果
     */
    int insertFFormPhy(FFormPhy fFormPhy);

    /**
     * 修改生物测量仪
     * 
     * @param fFormPhy 生物测量仪
     * @return 结果
     */
    int updateFFormPhy(FFormPhy fFormPhy);

    /**
     * 批量删除生物测量仪
     * 
     * @param ids 需要删除的生物测量仪主键集合
     * @return 结果
     */
    int deleteFFormPhyByIds(Long[] ids);

    /**
     * 删除生物测量仪信息
     * 
     * @param id 生物测量仪主键
     * @return 结果
     */
    int deleteFFormPhyById(Long id);
}
