package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * 诊室和单类型关联关系对象 f_room_form
 * 
 * @author ruoyi
 * @date 2023-06-05
 */
public class FRoomForm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 诊室和表单类型关联表id */
    private Long id;

    /** 诊室 */
    @Excel(name = "诊室")
    @NotBlank(message = "诊室不能为空")
    private String room;

    /** 表单类型 */
    @Excel(name = "表单类型")
    @NotBlank(message = "表单类型为空")
    private String formType;

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
    public void setRoom(String room) 
    {
        this.room = room;
    }

    public String getRoom() 
    {
        return room;
    }
    public void setFormType(String formType) 
    {
        this.formType = formType;
    }

    public String getFormType() 
    {
        return formType;
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
            .append("room", getRoom())
            .append("formType", getFormType())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
