package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FRoom;

/**
 * 诊室Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-30
 */
public interface FRoomMapper 
{
    /**
     * 查询诊室
     * 
     * @param id 诊室主键
     * @return 诊室
     */
    public FRoom selectFRoomById(Long id);

    /**
     * 查询诊室列表
     * 
     * @param fRoom 诊室
     * @return 诊室集合
     */
    public List<FRoom> selectFRoomList(FRoom fRoom);

    /**
     * 新增诊室
     * 
     * @param fRoom 诊室
     * @return 结果
     */
    public int insertFRoom(FRoom fRoom);

    /**
     * 修改诊室
     * 
     * @param fRoom 诊室
     * @return 结果
     */
    public int updateFRoom(FRoom fRoom);

    /**
     * 删除诊室
     * 
     * @param id 诊室主键
     * @return 结果
     */
    public int deleteFRoomById(Long id);

    /**
     * 批量删除诊室
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFRoomByIds(Long[] ids);
}
