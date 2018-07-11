package com.lingyi.base.userfigure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;


@Document(collection = "FigureData")
public class FigureData implements Serializable {

    private static final long serialVersionUID = -3258839839160856613L;

    @Id
    //用户编码
    private String userBaseId;

    //用户属性标签
    @Field("AttributeTags")
    private String[] attributeTags;

    @Field("CreateDateTime")
    private Date createDateTime;

    @Field("UpdateDateTime")
    private Date updateDateTime;


    public FigureData() {
    }

    public FigureData(String userBaseId, String[] attributeTags, Date createDateTime, Date updateDateTime) {
        this.userBaseId = userBaseId;
        this.attributeTags = attributeTags;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public String getUserBaseId() {
        return userBaseId;
    }

    public void setUserBaseId(String userBaseId) {
        this.userBaseId = userBaseId;
    }

    public String[] getAttributeTags() {
        return attributeTags;
    }

    public void setAttributeTags(String[] attributeTags) {
        this.attributeTags = attributeTags;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
