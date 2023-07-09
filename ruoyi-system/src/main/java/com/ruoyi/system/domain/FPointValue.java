package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 推荐人折扣积分对象 f_point_value
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public class FPointValue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 折扣id */
    private Long id;

    /** 推荐人id */
    @Excel(name = "推荐人id")
    private Long pointPatientId;

    /** 推荐人姓名 */
    @Excel(name = "推荐人姓名")
    private String pointPatientName;

    /** 推荐人电话 */
    @Excel(name = "推荐人电话")
    private String pointPatientPhone;

    /** 推荐人身份证 */
    @Excel(name = "推荐人身份证")
    private String pointPatientIdCard;

    /** 眼睛片数 */
    @Excel(name = "眼睛片数")
    private Integer glassesNum;

    /** 折扣 */
    @Excel(name = "折扣")
    private BigDecimal pointNum;

    /** 积分 */
    @Excel(name = "积分")
    private BigDecimal pointScore;

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
            .append("glassesNum", getGlassesNum())
            .append("pointNum", getPointNum())
            .append("pointScore", getPointScore())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
