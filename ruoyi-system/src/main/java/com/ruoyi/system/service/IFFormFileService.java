package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FFormFile;

/**
 * 单和文件关联关系Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFFormFileService 
{
    /**
     * 查询单和文件关联关系
     * 
     * @param id 单和文件关联关系主键
     * @return 单和文件关联关系
     */
    public FFormFile selectFFormFileById(Long id);

    /**
     * 查询单和文件关联关系列表
     * 
     * @param fFormFile 单和文件关联关系
     * @return 单和文件关联关系集合
     */
    public List<FFormFile> selectFFormFileList(FFormFile fFormFile);

    /**
     * 新增单和文件关联关系
     * 
     * @param fFormFile 单和文件关联关系
     * @return 结果
     */
    public int insertFFormFile(FFormFile fFormFile);

    /**
     * 修改单和文件关联关系
     * 
     * @param fFormFile 单和文件关联关系
     * @return 结果
     */
    public int updateFFormFile(FFormFile fFormFile);

    /**
     * 批量删除单和文件关联关系
     * 
     * @param ids 需要删除的单和文件关联关系主键集合
     * @return 结果
     */
    public int deleteFFormFileByIds(Long[] ids);

    /**
     * 删除单和文件关联关系信息
     * 
     * @param id 单和文件关联关系主键
     * @return 结果
     */
    public int deleteFFormFileById(Long id);
}
