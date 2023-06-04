package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FFormFileMapper;
import com.ruoyi.system.domain.FFormFile;
import com.ruoyi.system.service.IFFormFileService;

/**
 * 单和文件关联关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class FFormFileServiceImpl implements IFFormFileService 
{
    @Autowired
    private FFormFileMapper fFormFileMapper;

    /**
     * 查询单和文件关联关系
     * 
     * @param id 单和文件关联关系主键
     * @return 单和文件关联关系
     */
    @Override
    public FFormFile selectFFormFileById(Long id)
    {
        return fFormFileMapper.selectFFormFileById(id);
    }

    /**
     * 查询单和文件关联关系列表
     * 
     * @param fFormFile 单和文件关联关系
     * @return 单和文件关联关系
     */
    @Override
    public List<FFormFile> selectFFormFileList(FFormFile fFormFile)
    {
        return fFormFileMapper.selectFFormFileList(fFormFile);
    }

    /**
     * 新增单和文件关联关系
     * 
     * @param fFormFile 单和文件关联关系
     * @return 结果
     */
    @Override
    public int insertFFormFile(FFormFile fFormFile)
    {
        return fFormFileMapper.insertFFormFile(fFormFile);
    }

    /**
     * 修改单和文件关联关系
     * 
     * @param fFormFile 单和文件关联关系
     * @return 结果
     */
    @Override
    public int updateFFormFile(FFormFile fFormFile)
    {
        return fFormFileMapper.updateFFormFile(fFormFile);
    }

    /**
     * 批量删除单和文件关联关系
     * 
     * @param ids 需要删除的单和文件关联关系主键
     * @return 结果
     */
    @Override
    public int deleteFFormFileByIds(Long[] ids)
    {
        return fFormFileMapper.deleteFFormFileByIds(ids);
    }

    /**
     * 删除单和文件关联关系信息
     * 
     * @param id 单和文件关联关系主键
     * @return 结果
     */
    @Override
    public int deleteFFormFileById(Long id)
    {
        return fFormFileMapper.deleteFFormFileById(id);
    }
}
