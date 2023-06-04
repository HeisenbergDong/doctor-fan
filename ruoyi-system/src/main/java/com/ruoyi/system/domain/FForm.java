package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单对象 f_form
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public class FForm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表单id */
    private Long id;

    /** 表单类型 */
    @Excel(name = "表单类型")
    private String type;

    /** 患者id */
    @Excel(name = "患者id")
    private Long patientId;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patientName;

    /** 患者电话 */
    @Excel(name = "患者电话")
    private String patientPhone;

    /** 患者证件号 */
    @Excel(name = "患者证件号")
    private String patientIdCard;

    /** 医生id */
    @Excel(name = "医生id")
    private Long docId;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String docName;

    /** 表单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "表单日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date formTime;

    /** 表单内容 */
    @Excel(name = "表单内容")
    private String formContent;

    /** 删除标志（0代表存在 */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setPatientName(String patientName) 
    {
        this.patientName = patientName;
    }

    public String getPatientName() 
    {
        return patientName;
    }
    public void setPatientPhone(String patientPhone) 
    {
        this.patientPhone = patientPhone;
    }

    public String getPatientPhone() 
    {
        return patientPhone;
    }
    public void setPatientIdCard(String patientIdCard) 
    {
        this.patientIdCard = patientIdCard;
    }

    public String getPatientIdCard() 
    {
        return patientIdCard;
    }
    public void setDocId(Long docId) 
    {
        this.docId = docId;
    }

    public Long getDocId() 
    {
        return docId;
    }
    public void setDocName(String docName) 
    {
        this.docName = docName;
    }

    public String getDocName() 
    {
        return docName;
    }
    public void setFormTime(Date formTime) 
    {
        this.formTime = formTime;
    }

    public Date getFormTime() 
    {
        return formTime;
    }
    public void setFormContent(String formContent) 
    {
        this.formContent = formContent;
    }

    public String getFormContent() 
    {
        return formContent;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("patientId", getPatientId())
            .append("patientName", getPatientName())
            .append("patientPhone", getPatientPhone())
            .append("patientIdCard", getPatientIdCard())
            .append("docId", getDocId())
            .append("docName", getDocName())
            .append("formTime", getFormTime())
            .append("formContent", getFormContent())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
