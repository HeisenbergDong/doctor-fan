package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FFormPhy;

/**
 * 生物测量仪Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public interface FFormPhyMapper
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
     * 删除生物测量仪
     * 
     * @param id 生物测量仪主键
     * @return 结果
     */
    int deleteFFormPhyById(Long id);

    /**
     * 批量删除生物测量仪
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFFormPhyByIds(Long[] ids);
}
