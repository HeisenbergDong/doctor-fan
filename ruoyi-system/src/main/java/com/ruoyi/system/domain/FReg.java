package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.IdentityCardNumber;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 挂号对象 f_reg
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public class FReg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 挂号id */
    private Long id;

    /** 挂号号码 */
    @Excel(name = "挂号号码")
    @Length(max = 12,message = "挂号号码超过长度限制，最长12个字符")
    @NotBlank(message = "挂号号码不能为空")
    private String regNo;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    @Length(max = 12,message = "姓名超过长度限制，最长12个字符")
    @NotBlank(message = "用户名不能为空")
    private String name;

    /** 患者电话 */
    @Excel(name = "患者电话")
    @Pattern(regexp = "^1[3456789][0-9]{9}$",message = "手机号不符合格式")
    @NotBlank(message = "手机号不能为空！")
    private String phone;

    /** 患者身份证 */
    @Excel(name = "患者身份证")
    @IdentityCardNumber(message = "身份证信息有误,请核对后提交")
    private String idCard;

    /** 挂号日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "挂号日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date regDate;

    /** 已缴纳的挂号费 */
    @Excel(name = "已缴纳的挂号费")
    @DecimalMax(value="999999.99",message = "挂号费金额过大")
    private BigDecimal regFee;

    /** 已缴纳的检查费 */
    @Excel(name = "已缴纳的检查费")
    @DecimalMax(value="999999.99",message = "检查费金额过大")
    private BigDecimal checkFee;

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
    public void setRegDate(Date regDate) 
    {
        this.regDate = regDate;
    }

    public Date getRegDate() 
    {
        return regDate;
    }
    public void setRegFee(BigDecimal regFee) 
    {
        this.regFee = regFee;
    }

    public BigDecimal getRegFee() 
    {
        return regFee;
    }
    public void setCheckFee(BigDecimal checkFee) 
    {
        this.checkFee = checkFee;
    }

    public BigDecimal getCheckFee() 
    {
        return checkFee;
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
            .append("name", getName())
            .append("phone", getPhone())
            .append("idCard", getIdCard())
            .append("regDate", getRegDate())
            .append("regFee", getRegFee())
            .append("checkFee", getCheckFee())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
