package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FFileMapper;
import com.ruoyi.system.domain.FFile;
import com.ruoyi.system.service.IFFileService;

/**
 * 文件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@Service
public class FFileServiceImpl implements IFFileService 
{
    @Autowired
    private FFileMapper fFileMapper;

    /**
     * 查询文件
     * 
     * @param id 文件主键
     * @return 文件
     */
    @Override
    public FFile selectFFileById(Long id)
    {
        return fFileMapper.selectFFileById(id);
    }

    /**
     * 查询文件列表
     * 
     * @param fFile 文件
     * @return 文件
     */
    @Override
    public List<FFile> selectFFileList(FFile fFile)
    {
        return fFileMapper.selectFFileList(fFile);
    }

    /**
     * 新增文件
     * 
     * @param fFile 文件
     * @return 结果
     */
    @Override
    public int insertFFile(FFile fFile)
    {
        fFile.setCreateTime(DateUtils.getNowDate());
        return fFileMapper.insertFFile(fFile);
    }

    /**
     * 修改文件
     * 
     * @param fFile 文件
     * @return 结果
     */
    @Override
    public int updateFFile(FFile fFile)
    {
        fFile.setUpdateTime(DateUtils.getNowDate());
        return fFileMapper.updateFFile(fFile);
    }

    /**
     * 批量删除文件
     * 
     * @param ids 需要删除的文件主键
     * @return 结果
     */
    @Override
    public int deleteFFileByIds(Long[] ids)
    {
        return fFileMapper.deleteFFileByIds(ids);
    }

    /**
     * 删除文件信息
     * 
     * @param id 文件主键
     * @return 结果
     */
    @Override
    public int deleteFFileById(Long id)
    {
        return fFileMapper.deleteFFileById(id);
    }
}
