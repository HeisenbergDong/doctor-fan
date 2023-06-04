package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.Future;

/**
 * 提醒对象 f_warning
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Data
public class FWarning extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 阈值id */
    private Long id;

    /** 阈值类型0-预约阈值1-提醒阈值 */
    @Excel(name = "阈值类型0-预约阈值1-提醒阈值")
    private String warningType;

    private String warningTypeName;

    /** 阈值大小 */
    @Excel(name = "阈值大小")
    private Long num;

    /** 阈值适用日期，空适用于全部未设置日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "阈值适用日期，空适用于全部未设置日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date warningDate;

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
    public void setWarningType(String warningType) 
    {
        this.warningType = warningType;
    }

    public String getWarningType() 
    {
        return warningType;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setWarningDate(Date warningDate) 
    {
        this.warningDate = warningDate;
    }

    public Date getWarningDate() 
    {
        return warningDate;
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
            .append("warningType", getWarningType())
            .append("num", getNum())
            .append("warningDate", getWarningDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
