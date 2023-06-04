package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.IdentityCardNumber;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 提醒对象 f_remind
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public class FRemind extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 提醒id */
    private Long id;

    /** 提醒时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "提醒时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Future(message = "提醒时间不能小于当前时间")
    private Date remindDate;

    /** 提醒说明 */
    @Excel(name = "提醒说明")
    private String remindContent;

    /** 患者id */
    @Excel(name = "患者id")
    @NotNull(message = "患者id不能为空")
    private Long patientId;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    @NotBlank(message = "患者姓名不能为空")
    private String patientName;

    /** 患者电话 */
    @Excel(name = "患者电话")
    @Pattern(regexp = "^1[3456789][0-9]{9}$",message = "手机号不符合格式")
    @NotBlank(message = "患者电话不能为空")
    private String patientPhone;

    /** 患者身份证 */
    @Excel(name = "患者身份证")
    @IdentityCardNumber(message = "身份证信息有误,请核对后提交")
    private String patientIdCard;

    /** 提醒医生ID */
    @Excel(name = "提醒医生ID")
    @NotNull(message = "医生Id不能为空")
    private Long docId;

    /** 提醒医生姓名 */
    @Excel(name = "提醒医生姓名")
    @NotBlank(message = "医生姓名不能为空")
    private String docName;

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
    public void setRemindDate(Date remindDate) 
    {
        this.remindDate = remindDate;
    }

    public Date getRemindDate() 
    {
        return remindDate;
    }
    public void setRemindContent(String remindContent) 
    {
        this.remindContent = remindContent;
    }

    public String getRemindContent() 
    {
        return remindContent;
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
            .append("remindDate", getRemindDate())
            .append("remindContent", getRemindContent())
            .append("patientId", getPatientId())
            .append("patientName", getPatientName())
            .append("patientPhone", getPatientPhone())
            .append("patientIdCard", getPatientIdCard())
            .append("docId", getDocId())
            .append("docName", getDocName())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
