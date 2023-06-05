package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 单对象 f_form
 * 
 * @author ruoyi
 * @date 2023-06-04
 */
@Data
public class FForm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 表单id */
    private Long id;

    /** 挂号号码 */
    @Excel(name = "挂号号码")
    @NotBlank(message = "挂号号码不能为空")
    private String regNo;

    /** 表单类型 */
    @Excel(name = "表单类型")
    @NotBlank(message = "表单类型不能为空")
    private String type;

    /** 患者id */
    @Excel(name = "患者id")
    @NotNull(message = "表单类型不能为空")
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

    /** 诊室 */
    @Excel(name = "诊室")
    @NotBlank(message = "诊室不能为空")
    private String room;

    /** 医生id */
    @Excel(name = "医生id")
    @NotNull(message = "医生id不能为空")
    private Long docId;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String docName;

    /** 表单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "表单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date formTime;

    /** 表单内容 */
    @Excel(name = "表单内容")
    private String formContent;

    /** 附件地址，多个用，分割 */
    @Excel(name = "附件地址，多个用，分割")
    private String fileUrl;

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
    public void setRegNo(String regNo) 
    {
        this.regNo = regNo;
    }

    public String getRegNo() 
    {
        return regNo;
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
    public void setRoom(String room) 
    {
        this.room = room;
    }

    public String getRoom() 
    {
        return room;
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
            .append("regNo", getRegNo())
            .append("type", getType())
            .append("patientId", getPatientId())
            .append("patientName", getPatientName())
            .append("patientPhone", getPatientPhone())
            .append("patientIdCard", getPatientIdCard())
            .append("room", getRoom())
            .append("docId", getDocId())
            .append("docName", getDocName())
            .append("formTime", getFormTime())
            .append("formContent", getFormContent())
            .append("fileUrl",getFileUrl())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
