package com.dingxiang.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import java.util.Arrays;
import java.util.Date;

@Document(indexName = "user", type = "user")
public class User {
    @Id
    private String id;

    @Field(type = FieldType.keyword)
    private String account;

    /**
     * 真实姓名
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String trueName;

    /**
     * 昵称
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String nickName;

    /**
     * 年龄
     */
    @Field(type = FieldType.Integer)
    private Integer age;

    /**
     * 性别
     */
    @Field(type = FieldType.Integer)
    private Integer sex;

    /**
     * 用户的出生年月
     */
    @Field(type = FieldType.Date)
    private Date birthday;

    /**
     * 头像
     */
    @Field(type = FieldType.keyword)
    private String userImage;

    /**
     * 属相
     */
    @Field(type = FieldType.keyword)
    private String yearOfBirth;


    /**
     * 属相
     */
    @Field(type = FieldType.keyword)
    private String yearOfBirthStr;


    /**
     * 星座
     */
    @Field(type = FieldType.keyword)
    private String constellation;


    /**
     * 星座
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String constellationStr;


    /**
     * 用户电话
     */
    @Field(type = FieldType.text)
    private String phone;


    /**
     * 用户在线状态（在线、离线）
     */
    @Field(type = FieldType.Integer)
    private Integer accountState;


    /**
     * 注册类型
     */
    @Field(type = FieldType.Integer)
    private Integer registerType;


    /**
     * 当前所在地
     */
    @Field(type = FieldType.keyword)
    private String nowPlace;


    /**
     * 当前所在地
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String nowPlaceStr;


    /**
     * 职业
     */
    @Field(type = FieldType.keyword)
    private String profession;


    /**
     * 职业
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String professionStr;


    /**
     * 籍贯
     */
    @Field(type = FieldType.keyword)
    private String nativePlace;


    /**
     * 籍贯
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String nativePlaceStr;


    /**
     * 民族
     */
    @Field(type = FieldType.keyword)
    private String nation;


    /**
     * 民族
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String nationStr;


    /**
     * 信仰
     */
    @Field(type = FieldType.keyword)
    private String belife;


    /**
     * 信仰
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String belifeStr;


    /**
     * 身份证
     */
    @Field(type = FieldType.text)
    private String identityCard;

    /**
     * 邮箱
     */
    @Field(type = FieldType.text)
    private String email;

    /**
     * 一级市场
     */
    @Field(type = FieldType.keyword)
    private String marketOne;


    /**
     * 位置
     */
    @GeoPointField
    private Double[] location;


    /**
     * 最后一次更新坐标的时间
     */
    @Field(type = FieldType.Date)
    private Date locationLastDate;


    /**
     * 备注信息
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String remark;

    /**
     * 个人说明
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String description;

    /**
     * OpenId
     */
    @Field(type = FieldType.keyword)
    private String openId;

    /**
     * 代理商类别
     */
    @Field(type = FieldType.Integer)
    private Integer agentType;


    /**
     * 会员等级
     */
    @Field(type = FieldType.Integer)
    private Integer memberLevel;

    /**
     * 账号是否注销
     */
    @Field(type = FieldType.Boolean)
    private boolean isCancel;


    /**
     * 创建时间
     */
    @Field(type = FieldType.Date)
    private Date createDate;

    /**
     * 更新时间
     */
    @Field(type = FieldType.Date)
    private Date updateDate;

    @Field(type = FieldType.keyword)
    private String bindPhone;

    @Field(type = FieldType.keyword)
    private String bindEmail;

    public User() {
    }

    public String getBindPhone() {
        return bindPhone;
    }

    public void setBindPhone(String bindPhone) {
        this.bindPhone = bindPhone;
    }

    public String getBindEmail() {
        return bindEmail;
    }

    public void setBindEmail(String bindEmail) {
        this.bindEmail = bindEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getYearOfBirthStr() {
        return yearOfBirthStr;
    }

    public void setYearOfBirthStr(String yearOfBirthStr) {
        this.yearOfBirthStr = yearOfBirthStr;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getConstellationStr() {
        return constellationStr;
    }

    public void setConstellationStr(String constellationStr) {
        this.constellationStr = constellationStr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAccountState() {
        return accountState;
    }

    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

    public Integer getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }

    public String getNowPlace() {
        return nowPlace;
    }

    public void setNowPlace(String nowPlace) {
        this.nowPlace = nowPlace;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfessionStr() {
        return professionStr;
    }

    public void setProfessionStr(String professionStr) {
        this.professionStr = professionStr;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlaceStr() {
        return nativePlaceStr;
    }

    public void setNativePlaceStr(String nativePlaceStr) {
        this.nativePlaceStr = nativePlaceStr;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationStr() {
        return nationStr;
    }

    public void setNationStr(String nationStr) {
        this.nationStr = nationStr;
    }

    public String getBelife() {
        return belife;
    }

    public void setBelife(String belife) {
        this.belife = belife;
    }

    public String getBelifeStr() {
        return belifeStr;
    }

    public void setBelifeStr(String belifeStr) {
        this.belifeStr = belifeStr;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarketOne() {
        return marketOne;
    }

    public void setMarketOne(String marketOne) {
        this.marketOne = marketOne;
    }

    public Double[] getLocation() {
        return location;
    }

    public void setLocation(Double[] location) {
        this.location = location;
    }

    public Date getLocationLastDate() {
        return locationLastDate;
    }

    public void setLocationLastDate(Date locationLastDate) {
        this.locationLastDate = locationLastDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNowPlaceStr() {
        return nowPlaceStr;
    }

    public void setNowPlaceStr(String nowPlaceStr) {
        this.nowPlaceStr = nowPlaceStr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    public boolean getCancel() {
        return isCancel;
    }

    public void setCancel(boolean cancel) {
        isCancel = cancel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", trueName='" + trueName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", userImage='" + userImage + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", yearOfBirthStr='" + yearOfBirthStr + '\'' +
                ", constellation='" + constellation + '\'' +
                ", constellationStr='" + constellationStr + '\'' +
                ", phone='" + phone + '\'' +
                ", accountState=" + accountState +
                ", registerType=" + registerType +
                ", nowPlace='" + nowPlace + '\'' +
                ", nowPlaceStr='" + nowPlaceStr + '\'' +
                ", profession='" + profession + '\'' +
                ", professionStr='" + professionStr + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", nativePlaceStr='" + nativePlaceStr + '\'' +
                ", nation='" + nation + '\'' +
                ", nationStr='" + nationStr + '\'' +
                ", belife='" + belife + '\'' +
                ", belifeStr='" + belifeStr + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", email='" + email + '\'' +
                ", marketOne='" + marketOne + '\'' +
                ", location=" + Arrays.toString(location) +
                ", locationLastDate=" + locationLastDate +
                ", remark='" + remark + '\'' +
                ", description='" + description + '\'' +
                ", openId='" + openId + '\'' +
                ", agentType=" + agentType +
                ", memberLevel=" + memberLevel +
                ", isCancel=" + isCancel +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", bindPhone='" + bindPhone + '\'' +
                ", bindEmail='" + bindEmail + '\'' +
                '}';
    }
}
