package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FReg;

/**
 * 挂号Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFRegService
{
    /**
     * 查询挂号
     * 
     * @param id 挂号主键
     * @return 挂号
     */
    FReg selectFRegById(Long id);

    /**
     * 查询挂号列表
     * 
     * @param fReg 挂号
     * @return 挂号集合
     */
    List<FReg> selectFRegList(FReg fReg);

    /**
     * 新增挂号
     * 
     * @param fReg 挂号
     * @return 结果
     */
    FReg insertFReg(FReg fReg);

    /**
     * 修改挂号
     * 
     * @param fReg 挂号
     * @return 结果
     */
    int updateFReg(FReg fReg);

    /**
     * 批量删除挂号
     * 
     * @param ids 需要删除的挂号主键集合
     * @return 结果
     */
    int deleteFRegByIds(Long[] ids);

    /**
     * 删除挂号信息
     * 
     * @param id 挂号主键
     * @return 结果
     */
    int deleteFRegById(Long id);
}
