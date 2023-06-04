package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单和文件关联关系对象 f_form_file
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public class FFormFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表单和附件关联id */
    private Long id;

    /** 表单id */
    @Excel(name = "表单id")
    private Long formId;

    /** 附件id */
    @Excel(name = "附件id")
    private Long fileId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFormId(Long formId) 
    {
        this.formId = formId;
    }

    public Long getFormId() 
    {
        return formId;
    }
    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("formId", getFormId())
            .append("fileId", getFileId())
            .toString();
    }
}
