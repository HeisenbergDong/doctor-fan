package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FRoomMapper;
import com.ruoyi.system.domain.FRoom;
import com.ruoyi.system.service.IFRoomService;

/**
 * 诊室Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-30
 */
@Service
public class FRoomServiceImpl implements IFRoomService 
{
    @Autowired
    private FRoomMapper fRoomMapper;

    /**
     * 查询诊室
     * 
     * @param id 诊室主键
     * @return 诊室
     */
    @Override
    public FRoom selectFRoomById(Long id)
    {
        return fRoomMapper.selectFRoomById(id);
    }

    /**
     * 查询诊室列表
     * 
     * @param fRoom 诊室
     * @return 诊室
     */
    @Override
    public List<FRoom> selectFRoomList(FRoom fRoom)
    {
        return fRoomMapper.selectFRoomList(fRoom);
    }

    /**
     * 新增诊室
     * 
     * @param fRoom 诊室
     * @return 结果
     */
    @Override
    public int insertFRoom(FRoom fRoom)
    {
        fRoom.setCreateTime(DateUtils.getNowDate());
        return fRoomMapper.insertFRoom(fRoom);
    }

    /**
     * 修改诊室
     * 
     * @param fRoom 诊室
     * @return 结果
     */
    @Override
    public int updateFRoom(FRoom fRoom)
    {
        fRoom.setUpdateTime(DateUtils.getNowDate());
        return fRoomMapper.updateFRoom(fRoom);
    }

    /**
     * 批量删除诊室
     * 
     * @param ids 需要删除的诊室主键
     * @return 结果
     */
    @Override
    public int deleteFRoomByIds(Long[] ids)
    {
        return fRoomMapper.deleteFRoomByIds(ids);
    }

    /**
     * 删除诊室信息
     * 
     * @param id 诊室主键
     * @return 结果
     */
    @Override
    public int deleteFRoomById(Long id)
    {
        return fRoomMapper.deleteFRoomById(id);
    }
}
