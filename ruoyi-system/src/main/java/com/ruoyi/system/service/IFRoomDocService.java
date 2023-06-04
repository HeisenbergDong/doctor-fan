package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FRoomDoc;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-05-30
 */
public interface IFRoomDocService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FRoomDoc selectFRoomDocById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fRoomDoc 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FRoomDoc> selectFRoomDocList(FRoomDoc fRoomDoc);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fRoomDoc 【请填写功能名称】
     * @return 结果
     */
    public int insertFRoomDoc(FRoomDoc fRoomDoc);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fRoomDoc 【请填写功能名称】
     * @return 结果
     */
    public int updateFRoomDoc(FRoomDoc fRoomDoc);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFRoomDocByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFRoomDocById(Long id);
}
