package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 问诊单关联对象 f_visit_form
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public class FVisitForm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 问诊表单关联id */
    private Long id;

    /** 问诊id */
    @Excel(name = "问诊id")
    private Long visitId;

    /** 表单id */
    @Excel(name = "表单id")
    private Long formId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVisitId(Long visitId) 
    {
        this.visitId = visitId;
    }

    public Long getVisitId() 
    {
        return visitId;
    }
    public void setFormId(Long formId) 
    {
        this.formId = formId;
    }

    public Long getFormId() 
    {
        return formId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("visitId", getVisitId())
            .append("formId", getFormId())
            .toString();
    }
}
