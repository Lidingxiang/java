package com.ly.bll.model;


import cicada.core.valid.InsertCheck;
/*
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
*/

import java.io.Serializable;
import java.util.Date;

//@ApiModel(value ="AppInfo", description ="AppInfo" )
public class Appinfo implements Serializable {
    /**
     * 
     */
    /*@ApiModelProperty(value ="", required = true)
    @NotBlank(message="字段appId不能为空",groups ={InsertCheck.class})*/
    private String appId;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = true)
//    @NotBlank(message="字段appName不能为空",groups ={InsertCheck.class})
    private String appName;

    /**
     * 0：App应用
            1：网站应用
            2：其它
     */
//    @ApiModelProperty(value ="0：App应用1：网站应用2：其它", required = true)
    private Integer appType;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = true)
//    @NotBlank(message="字段appKey不能为空",groups ={InsertCheck.class})
    private String appKey;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = true)
//    @NotBlank(message="字段appSecret不能为空",groups ={InsertCheck.class})
    private String appSecret;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = true)
    private Date appCreateDateTime;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = true)
//    @NotBlank(message="字段appUrl不能为空",groups ={InsertCheck.class})
    private String appUrl;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = true)
//    @NotBlank(message="字段appIntro不能为空",groups ={InsertCheck.class})
    private String appIntro;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = true)
//    @NotBlank(message="字段appTags不能为空",groups ={InsertCheck.class})
    private String appTags;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = false)
    private String appIcon16;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = false)
    private String appIcon80;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = false)
    private String appIcon120;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = false)
    private String appDesImage1;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = false)
    private String appDesImage2;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = false)
    private String appDesImage3;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = false)
    private String callBackUrl;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = false)
    private String cancelCallBackUrl;

    /**
     * 0：待完善
            1：待审核
            2：已驳回
            3：已通过
     */
//    @ApiModelProperty(value ="0：待完善1：待审核2：已驳回3：已通过", required = true)
    private Integer appState;

    /**
     * 
     */
//    @ApiModelProperty(value ="", required = true)
//    @NotBlank(message="字段appDescription不能为空",groups ={InsertCheck.class})
    private String appDescription;

    private static final long serialVersionUID = 1L;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public Date getAppCreateDateTime() {
        return appCreateDateTime;
    }

    public void setAppCreateDateTime(Date appCreateDateTime) {
        this.appCreateDateTime = appCreateDateTime;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl == null ? null : appUrl.trim();
    }

    public String getAppIntro() {
        return appIntro;
    }

    public void setAppIntro(String appIntro) {
        this.appIntro = appIntro == null ? null : appIntro.trim();
    }

    public String getAppTags() {
        return appTags;
    }

    public void setAppTags(String appTags) {
        this.appTags = appTags == null ? null : appTags.trim();
    }

    public String getAppIcon16() {
        return appIcon16;
    }

    public void setAppIcon16(String appIcon16) {
        this.appIcon16 = appIcon16 == null ? null : appIcon16.trim();
    }

    public String getAppIcon80() {
        return appIcon80;
    }

    public void setAppIcon80(String appIcon80) {
        this.appIcon80 = appIcon80 == null ? null : appIcon80.trim();
    }

    public String getAppIcon120() {
        return appIcon120;
    }

    public void setAppIcon120(String appIcon120) {
        this.appIcon120 = appIcon120 == null ? null : appIcon120.trim();
    }

    public String getAppDesImage1() {
        return appDesImage1;
    }

    public void setAppDesImage1(String appDesImage1) {
        this.appDesImage1 = appDesImage1 == null ? null : appDesImage1.trim();
    }

    public String getAppDesImage2() {
        return appDesImage2;
    }

    public void setAppDesImage2(String appDesImage2) {
        this.appDesImage2 = appDesImage2 == null ? null : appDesImage2.trim();
    }

    public String getAppDesImage3() {
        return appDesImage3;
    }

    public void setAppDesImage3(String appDesImage3) {
        this.appDesImage3 = appDesImage3 == null ? null : appDesImage3.trim();
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl == null ? null : callBackUrl.trim();
    }

    public String getCancelCallBackUrl() {
        return cancelCallBackUrl;
    }

    public void setCancelCallBackUrl(String cancelCallBackUrl) {
        this.cancelCallBackUrl = cancelCallBackUrl == null ? null : cancelCallBackUrl.trim();
    }

    public Integer getAppState() {
        return appState;
    }

    public void setAppState(Integer appState) {
        this.appState = appState;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription == null ? null : appDescription.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appId=").append(appId);
        sb.append(", appName=").append(appName);
        sb.append(", appType=").append(appType);
        sb.append(", appKey=").append(appKey);
        sb.append(", appSecret=").append(appSecret);
        sb.append(", appCreateDateTime=").append(appCreateDateTime);
        sb.append(", appUrl=").append(appUrl);
        sb.append(", appIntro=").append(appIntro);
        sb.append(", appTags=").append(appTags);
        sb.append(", appIcon16=").append(appIcon16);
        sb.append(", appIcon80=").append(appIcon80);
        sb.append(", appIcon120=").append(appIcon120);
        sb.append(", appDesImage1=").append(appDesImage1);
        sb.append(", appDesImage2=").append(appDesImage2);
        sb.append(", appDesImage3=").append(appDesImage3);
        sb.append(", callBackUrl=").append(callBackUrl);
        sb.append(", cancelCallBackUrl=").append(cancelCallBackUrl);
        sb.append(", appState=").append(appState);
        sb.append(", appDescription=").append(appDescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}