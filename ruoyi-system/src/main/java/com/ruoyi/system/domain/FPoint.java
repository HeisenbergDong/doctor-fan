package com.ruoyi.system.domain;

import java.math.BigDecimal;

import com.ruoyi.common.annotation.IdentityCardNumber;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 推荐人折扣积分对象 f_point
 * 
 * @author ruoyi
 * @date 2023-05-30
 */
public class FPoint extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 折扣id */
    private Long id;

    /** 推荐人id */
    @Excel(name = "推荐人id")
    @NotNull(message = "推荐人Id不能为空")
    private Long pointPatientId;

    /** 推荐人姓名 */
    @Excel(name = "推荐人姓名")
    private String pointPatientName;

    /** 推荐人电话 */
    @Excel(name = "推荐人电话")
    @Pattern(regexp = "^1[3456789][0-9]{9}$",message = "推荐人手机号不符合格式")
    private String pointPatientPhone;

    /** 推荐人身份证 */
    @Excel(name = "推荐人身份证")
    @IdentityCardNumber(message = "推荐人身份证信息有误,请核对后提交")
    private String pointPatientIdCard;

    /** 折扣类型0-折扣1-积分 */
    @Excel(name = "折扣类型0-折扣1-积分")
    @NotBlank(message = "折扣类型不能为空")
    private String pointType;

    /** 眼睛片数 */
    @Excel(name = "眼睛片数")
    @NotNull(message = "眼睛片数不能为空")
    private Integer glassesNum;

    /** 折扣 */
    @Excel(name = "折扣")
    private BigDecimal pointNum;

    /** 积分 */
    @Excel(name = "积分")
    private BigDecimal pointScore;

    /** 被推荐人id */
    @Excel(name = "被推荐人id")
    @NotNull(message = "被推荐人id不能为空")
    private Long newPatientId;

    /** 被推荐人姓名 */
    @Excel(name = "被推荐人姓名")
    private String newPatientName;

    /** 被推荐人电话 */
    @Excel(name = "被推荐人电话")
    @Pattern(regexp = "^1[3456789][0-9]{9}$",message = "被推荐人手机号不符合格式")
    private String newPatientPhone;

    /** 被推荐人身份证 */
    @Excel(name = "被推荐人身份证")
    @IdentityCardNumber(message = "被推荐人身份证信息有误,请核对后提交")
    private String newPatientIdCard;

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
    public void setPointPatientId(Long pointPatientId) 
    {
        this.pointPatientId = pointPatientId;
    }

    public Long getPointPatientId() 
    {
        return pointPatientId;
    }
    public void setPointPatientName(String pointPatientName) 
    {
        this.pointPatientName = pointPatientName;
    }

    public String getPointPatientName() 
    {
        return pointPatientName;
    }
    public void setPointPatientPhone(String pointPatientPhone) 
    {
        this.pointPatientPhone = pointPatientPhone;
    }

    public String getPointPatientPhone() 
    {
        return pointPatientPhone;
    }
    public void setPointPatientIdCard(String pointPatientIdCard) 
    {
        this.pointPatientIdCard = pointPatientIdCard;
    }

    public String getPointPatientIdCard() 
    {
        return pointPatientIdCard;
    }
    public void setPointType(String pointType) 
    {
        this.pointType = pointType;
    }

    public String getPointType() 
    {
        return pointType;
    }
    public void setGlassesNum(Integer glassesNum) 
    {
        this.glassesNum = glassesNum;
    }

    public Integer getGlassesNum() 
    {
        return glassesNum;
    }
    public void setPointNum(BigDecimal pointNum)
    {
        this.pointNum = pointNum;
    }

    public BigDecimal getPointNum()
    {
        return pointNum;
    }
    public void setPointScore(BigDecimal pointScore) 
    {
        this.pointScore = pointScore;
    }

    public BigDecimal getPointScore() 
    {
        return pointScore;
    }
    public void setNewPatientId(Long newPatientId) 
    {
        this.newPatientId = newPatientId;
    }

    public Long getNewPatientId() 
    {
        return newPatientId;
    }
    public void setNewPatientName(String newPatientName) 
    {
        this.newPatientName = newPatientName;
    }

    public String getNewPatientName() 
    {
        return newPatientName;
    }
    public void setNewPatientPhone(String newPatientPhone) 
    {
        this.newPatientPhone = newPatientPhone;
    }

    public String getNewPatientPhone() 
    {
        return newPatientPhone;
    }
    public void setNewPatientIdCard(String newPatientIdCard) 
    {
        this.newPatientIdCard = newPatientIdCard;
    }

    public String getNewPatientIdCard() 
    {
        return newPatientIdCard;
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
            .append("pointPatientId", getPointPatientId())
            .append("pointPatientName", getPointPatientName())
            .append("pointPatientPhone", getPointPatientPhone())
            .append("pointPatientIdCard", getPointPatientIdCard())
            .append("pointType", getPointType())
            .append("glassesNum", getGlassesNum())
            .append("pointNum", getPointNum())
            .append("pointScore", getPointScore())
            .append("newPatientId", getNewPatientId())
            .append("newPatientName", getNewPatientName())
            .append("newPatientPhone", getNewPatientPhone())
            .append("newPatientIdCard", getNewPatientIdCard())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
