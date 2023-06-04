package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FRoomDocMapper;
import com.ruoyi.system.domain.FRoomDoc;
import com.ruoyi.system.service.IFRoomDocService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-30
 */
@Service
public class FRoomDocServiceImpl implements IFRoomDocService 
{
    @Autowired
    private FRoomDocMapper fRoomDocMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FRoomDoc selectFRoomDocById(Long id)
    {
        return fRoomDocMapper.selectFRoomDocById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fRoomDoc 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FRoomDoc> selectFRoomDocList(FRoomDoc fRoomDoc)
    {
        return fRoomDocMapper.selectFRoomDocList(fRoomDoc);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fRoomDoc 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFRoomDoc(FRoomDoc fRoomDoc)
    {
        return fRoomDocMapper.insertFRoomDoc(fRoomDoc);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fRoomDoc 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFRoomDoc(FRoomDoc fRoomDoc)
    {
        return fRoomDocMapper.updateFRoomDoc(fRoomDoc);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFRoomDocByIds(Long[] ids)
    {
        return fRoomDocMapper.deleteFRoomDocByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFRoomDocById(Long id)
    {
        return fRoomDocMapper.deleteFRoomDocById(id);
    }
}
