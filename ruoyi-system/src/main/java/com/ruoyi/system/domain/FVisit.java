package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 就诊对象 f_visit
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public class FVisit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 诊断id */
    private Long id;

    /** 诊断医生id */
    @Excel(name = "诊断医生id")
    private Long docId;

    /** 诊断医生姓名 */
    @Excel(name = "诊断医生姓名")
    private String docName;

    /** 诊室 */
    @Excel(name = "诊室")
    private String room;

    /** 患者id */
    @Excel(name = "患者id")
    private Long patientId;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patientName;

    /** 患者电话 */
    @Excel(name = "患者电话")
    private String patientPhone;

    /** 患者身份证号 */
    @Excel(name = "患者身份证号")
    private String patientIdCard;

    /** 是否新患者 */
    @Excel(name = "是否新患者")
    private String newPatient;

    /** 挂号号码 */
    @Excel(name = "挂号号码")
    private String regNo;

    /** 就诊时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "就诊时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date visitTime;

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
    public void setRoom(String room) 
    {
        this.room = room;
    }

    public String getRoom() 
    {
        return room;
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
    public void setNewPatient(String newPatient) 
    {
        this.newPatient = newPatient;
    }

    public String getNewPatient() 
    {
        return newPatient;
    }
    public void setRegNo(String regNo) 
    {
        this.regNo = regNo;
    }

    public String getRegNo() 
    {
        return regNo;
    }
    public void setVisitTime(Date visitTime) 
    {
        this.visitTime = visitTime;
    }

    public Date getVisitTime() 
    {
        return visitTime;
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
            .append("docId", getDocId())
            .append("docName", getDocName())
            .append("room", getRoom())
            .append("patientId", getPatientId())
            .append("patientName", getPatientName())
            .append("patientPhone", getPatientPhone())
            .append("patientIdCard", getPatientIdCard())
            .append("newPatient", getNewPatient())
            .append("regNo", getRegNo())
            .append("visitTime", getVisitTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
