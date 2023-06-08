package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 患者信息对象 f_patient
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Data
public class FPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 患者id */
    private Long id;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String name;

    /** 患者电话 */
    @Excel(name = "患者电话")
    private String phone;

    /** 患者身份证 */
    @Excel(name = "患者身份证")
    private String idCard;

    /** 是否黑名单0-否1-是 */
    @Excel(name = "是否黑名单0-否1-是")
    private String black;

    /** 是否新患者0-否1-是 */
    @Excel(name = "是否新患者0-否1-是")
    private String newPatient;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setBlack(String black) 
    {
        this.black = black;
    }

    public String getBlack() 
    {
        return black;
    }
    public void setNewPatient(String newPatient) 
    {
        this.newPatient = newPatient;
    }

    public String getNewPatient() 
    {
        return newPatient;
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
            .append("name", getName())
            .append("phone", getPhone())
            .append("idCard", getIdCard())
            .append("black", getBlack())
            .append("newPatient", getNewPatient())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
