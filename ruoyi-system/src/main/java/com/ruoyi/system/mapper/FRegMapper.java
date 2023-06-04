package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FReg;

/**
 * 挂号Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface FRegMapper
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
    int insertFReg(FReg fReg);

    /**
     * 修改挂号
     * 
     * @param fReg 挂号
     * @return 结果
     */
    int updateFReg(FReg fReg);

    /**
     * 删除挂号
     * 
     * @param id 挂号主键
     * @return 结果
     */
    int deleteFRegById(Long id);

    /**
     * 批量删除挂号
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFRegByIds(Long[] ids);

    /**
     * 获取编码NO最大的用户
     * @return
     */
    FReg selectRegByMaxNo();
}
