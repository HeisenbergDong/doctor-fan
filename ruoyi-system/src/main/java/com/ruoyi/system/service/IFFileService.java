package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FFile;

/**
 * 文件Service接口
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public interface IFFileService 
{
    /**
     * 查询文件
     * 
     * @param id 文件主键
     * @return 文件
     */
    public FFile selectFFileById(Long id);

    /**
     * 查询文件列表
     * 
     * @param fFile 文件
     * @return 文件集合
     */
    public List<FFile> selectFFileList(FFile fFile);

    /**
     * 新增文件
     * 
     * @param fFile 文件
     * @return 结果
     */
    public int insertFFile(FFile fFile);

    /**
     * 修改文件
     * 
     * @param fFile 文件
     * @return 结果
     */
    public int updateFFile(FFile fFile);

    /**
     * 批量删除文件
     * 
     * @param ids 需要删除的文件主键集合
     * @return 结果
     */
    public int deleteFFileByIds(Long[] ids);

    /**
     * 删除文件信息
     * 
     * @param id 文件主键
     * @return 结果
     */
    public int deleteFFileById(Long id);
}
