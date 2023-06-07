package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FWait;

/**
 * 排队Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFWaitService {
    /**
     * 查询排队
     * 
     * @param id 排队主键
     * @return 排队
     */
    FWait selectFWaitById(Long id);

    /**
     * 查询排队列表
     * 
     * @param fWait 排队
     * @return 排队集合
     */
    List<FWait> selectFWaitList(FWait fWait);

    /**
     * 新增排队
     *
     * @param fWait 排队
     * @return 结果
     */
    int insertFWait(FWait fWait);

    /**
     * 调整排队顺序
     *
     * @param fWait 排队
     * @return 结果
     */
    int adjust(FWait fWait);

    /**
     * 指派
     * 
     * @param fWait 排队
     * @return 结果
     */
    int dispatch(FWait fWait);

    /**
     * 修改排队
     * 
     * @param fWait 排队
     * @return 结果
     */
    int call(FWait fWait);

    /**
     * 批量删除排队
     * 
     * @param ids 需要删除的排队主键集合
     * @return 结果
     */
    int deleteFWaitByIds(Long[] ids);

    /**
     * 删除排队信息
     * 
     * @param id 排队主键
     * @return 结果
     */
    int deleteFWaitById(Long id);
}
