package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 f_room_doc
 * 
 * @author ruoyi
 * @date 2023-05-30
 */
public class FRoomDoc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 诊室医生关系id */
    private Long id;

    /** 诊室编码 */
    @Excel(name = "诊室编码")
    private String room;

    /** 医生id */
    @Excel(name = "医生id")
    private Long docId;

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
    public void setDocId(Long docId) 
    {
        this.docId = docId;
    }

    public Long getDocId() 
    {
        return docId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("room", getRoom())
            .append("docId", getDocId())
            .toString();
    }
}
