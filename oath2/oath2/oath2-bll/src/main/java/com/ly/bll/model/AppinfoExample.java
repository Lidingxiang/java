package com.ly.bll.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public AppinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
        if (this.startRow < 0) { this.startRow = 0;}
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
        if (this.startRow < 0) { this.startRow = 0;}
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAppIdIsNull() {
            addCriterion("AppId is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("AppId is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("AppId =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("AppId <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("AppId >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("AppId >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("AppId <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("AppId <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("AppId like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("AppId not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("AppId in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("AppId not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("AppId between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("AppId not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("AppName is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("AppName is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("AppName =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("AppName <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("AppName >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("AppName >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("AppName <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("AppName <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("AppName like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("AppName not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("AppName in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("AppName not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("AppName between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("AppName not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("AppType is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("AppType is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Integer value) {
            addCriterion("AppType =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Integer value) {
            addCriterion("AppType <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Integer value) {
            addCriterion("AppType >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AppType >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Integer value) {
            addCriterion("AppType <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Integer value) {
            addCriterion("AppType <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(List<Integer> values) {
            addCriterion("AppType in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(List<Integer> values) {
            addCriterion("AppType not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Integer value1, Integer value2) {
            addCriterion("AppType between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("AppType not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNull() {
            addCriterion("AppKey is null");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNotNull() {
            addCriterion("AppKey is not null");
            return (Criteria) this;
        }

        public Criteria andAppKeyEqualTo(String value) {
            addCriterion("AppKey =", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualTo(String value) {
            addCriterion("AppKey <>", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThan(String value) {
            addCriterion("AppKey >", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("AppKey >=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThan(String value) {
            addCriterion("AppKey <", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualTo(String value) {
            addCriterion("AppKey <=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLike(String value) {
            addCriterion("AppKey like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotLike(String value) {
            addCriterion("AppKey not like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyIn(List<String> values) {
            addCriterion("AppKey in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotIn(List<String> values) {
            addCriterion("AppKey not in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyBetween(String value1, String value2) {
            addCriterion("AppKey between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotBetween(String value1, String value2) {
            addCriterion("AppKey not between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNull() {
            addCriterion("AppSecret is null");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNotNull() {
            addCriterion("AppSecret is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecretEqualTo(String value) {
            addCriterion("AppSecret =", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotEqualTo(String value) {
            addCriterion("AppSecret <>", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThan(String value) {
            addCriterion("AppSecret >", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("AppSecret >=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThan(String value) {
            addCriterion("AppSecret <", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThanOrEqualTo(String value) {
            addCriterion("AppSecret <=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLike(String value) {
            addCriterion("AppSecret like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotLike(String value) {
            addCriterion("AppSecret not like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretIn(List<String> values) {
            addCriterion("AppSecret in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotIn(List<String> values) {
            addCriterion("AppSecret not in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretBetween(String value1, String value2) {
            addCriterion("AppSecret between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotBetween(String value1, String value2) {
            addCriterion("AppSecret not between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeIsNull() {
            addCriterion("AppCreateDateTime is null");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeIsNotNull() {
            addCriterion("AppCreateDateTime is not null");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeEqualTo(Date value) {
            addCriterion("AppCreateDateTime =", value, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeNotEqualTo(Date value) {
            addCriterion("AppCreateDateTime <>", value, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeGreaterThan(Date value) {
            addCriterion("AppCreateDateTime >", value, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AppCreateDateTime >=", value, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeLessThan(Date value) {
            addCriterion("AppCreateDateTime <", value, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("AppCreateDateTime <=", value, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeIn(List<Date> values) {
            addCriterion("AppCreateDateTime in", values, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeNotIn(List<Date> values) {
            addCriterion("AppCreateDateTime not in", values, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeBetween(Date value1, Date value2) {
            addCriterion("AppCreateDateTime between", value1, value2, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppCreateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("AppCreateDateTime not between", value1, value2, "appCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andAppUrlIsNull() {
            addCriterion("AppUrl is null");
            return (Criteria) this;
        }

        public Criteria andAppUrlIsNotNull() {
            addCriterion("AppUrl is not null");
            return (Criteria) this;
        }

        public Criteria andAppUrlEqualTo(String value) {
            addCriterion("AppUrl =", value, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlNotEqualTo(String value) {
            addCriterion("AppUrl <>", value, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlGreaterThan(String value) {
            addCriterion("AppUrl >", value, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlGreaterThanOrEqualTo(String value) {
            addCriterion("AppUrl >=", value, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlLessThan(String value) {
            addCriterion("AppUrl <", value, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlLessThanOrEqualTo(String value) {
            addCriterion("AppUrl <=", value, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlLike(String value) {
            addCriterion("AppUrl like", value, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlNotLike(String value) {
            addCriterion("AppUrl not like", value, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlIn(List<String> values) {
            addCriterion("AppUrl in", values, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlNotIn(List<String> values) {
            addCriterion("AppUrl not in", values, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlBetween(String value1, String value2) {
            addCriterion("AppUrl between", value1, value2, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppUrlNotBetween(String value1, String value2) {
            addCriterion("AppUrl not between", value1, value2, "appUrl");
            return (Criteria) this;
        }

        public Criteria andAppIntroIsNull() {
            addCriterion("AppIntro is null");
            return (Criteria) this;
        }

        public Criteria andAppIntroIsNotNull() {
            addCriterion("AppIntro is not null");
            return (Criteria) this;
        }

        public Criteria andAppIntroEqualTo(String value) {
            addCriterion("AppIntro =", value, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroNotEqualTo(String value) {
            addCriterion("AppIntro <>", value, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroGreaterThan(String value) {
            addCriterion("AppIntro >", value, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroGreaterThanOrEqualTo(String value) {
            addCriterion("AppIntro >=", value, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroLessThan(String value) {
            addCriterion("AppIntro <", value, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroLessThanOrEqualTo(String value) {
            addCriterion("AppIntro <=", value, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroLike(String value) {
            addCriterion("AppIntro like", value, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroNotLike(String value) {
            addCriterion("AppIntro not like", value, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroIn(List<String> values) {
            addCriterion("AppIntro in", values, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroNotIn(List<String> values) {
            addCriterion("AppIntro not in", values, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroBetween(String value1, String value2) {
            addCriterion("AppIntro between", value1, value2, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppIntroNotBetween(String value1, String value2) {
            addCriterion("AppIntro not between", value1, value2, "appIntro");
            return (Criteria) this;
        }

        public Criteria andAppTagsIsNull() {
            addCriterion("AppTags is null");
            return (Criteria) this;
        }

        public Criteria andAppTagsIsNotNull() {
            addCriterion("AppTags is not null");
            return (Criteria) this;
        }

        public Criteria andAppTagsEqualTo(String value) {
            addCriterion("AppTags =", value, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsNotEqualTo(String value) {
            addCriterion("AppTags <>", value, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsGreaterThan(String value) {
            addCriterion("AppTags >", value, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsGreaterThanOrEqualTo(String value) {
            addCriterion("AppTags >=", value, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsLessThan(String value) {
            addCriterion("AppTags <", value, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsLessThanOrEqualTo(String value) {
            addCriterion("AppTags <=", value, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsLike(String value) {
            addCriterion("AppTags like", value, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsNotLike(String value) {
            addCriterion("AppTags not like", value, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsIn(List<String> values) {
            addCriterion("AppTags in", values, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsNotIn(List<String> values) {
            addCriterion("AppTags not in", values, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsBetween(String value1, String value2) {
            addCriterion("AppTags between", value1, value2, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppTagsNotBetween(String value1, String value2) {
            addCriterion("AppTags not between", value1, value2, "appTags");
            return (Criteria) this;
        }

        public Criteria andAppIcon16IsNull() {
            addCriterion("AppIcon16 is null");
            return (Criteria) this;
        }

        public Criteria andAppIcon16IsNotNull() {
            addCriterion("AppIcon16 is not null");
            return (Criteria) this;
        }

        public Criteria andAppIcon16EqualTo(String value) {
            addCriterion("AppIcon16 =", value, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16NotEqualTo(String value) {
            addCriterion("AppIcon16 <>", value, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16GreaterThan(String value) {
            addCriterion("AppIcon16 >", value, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16GreaterThanOrEqualTo(String value) {
            addCriterion("AppIcon16 >=", value, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16LessThan(String value) {
            addCriterion("AppIcon16 <", value, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16LessThanOrEqualTo(String value) {
            addCriterion("AppIcon16 <=", value, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16Like(String value) {
            addCriterion("AppIcon16 like", value, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16NotLike(String value) {
            addCriterion("AppIcon16 not like", value, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16In(List<String> values) {
            addCriterion("AppIcon16 in", values, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16NotIn(List<String> values) {
            addCriterion("AppIcon16 not in", values, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16Between(String value1, String value2) {
            addCriterion("AppIcon16 between", value1, value2, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon16NotBetween(String value1, String value2) {
            addCriterion("AppIcon16 not between", value1, value2, "appIcon16");
            return (Criteria) this;
        }

        public Criteria andAppIcon80IsNull() {
            addCriterion("AppIcon80 is null");
            return (Criteria) this;
        }

        public Criteria andAppIcon80IsNotNull() {
            addCriterion("AppIcon80 is not null");
            return (Criteria) this;
        }

        public Criteria andAppIcon80EqualTo(String value) {
            addCriterion("AppIcon80 =", value, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80NotEqualTo(String value) {
            addCriterion("AppIcon80 <>", value, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80GreaterThan(String value) {
            addCriterion("AppIcon80 >", value, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80GreaterThanOrEqualTo(String value) {
            addCriterion("AppIcon80 >=", value, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80LessThan(String value) {
            addCriterion("AppIcon80 <", value, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80LessThanOrEqualTo(String value) {
            addCriterion("AppIcon80 <=", value, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80Like(String value) {
            addCriterion("AppIcon80 like", value, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80NotLike(String value) {
            addCriterion("AppIcon80 not like", value, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80In(List<String> values) {
            addCriterion("AppIcon80 in", values, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80NotIn(List<String> values) {
            addCriterion("AppIcon80 not in", values, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80Between(String value1, String value2) {
            addCriterion("AppIcon80 between", value1, value2, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon80NotBetween(String value1, String value2) {
            addCriterion("AppIcon80 not between", value1, value2, "appIcon80");
            return (Criteria) this;
        }

        public Criteria andAppIcon120IsNull() {
            addCriterion("AppIcon120 is null");
            return (Criteria) this;
        }

        public Criteria andAppIcon120IsNotNull() {
            addCriterion("AppIcon120 is not null");
            return (Criteria) this;
        }

        public Criteria andAppIcon120EqualTo(String value) {
            addCriterion("AppIcon120 =", value, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120NotEqualTo(String value) {
            addCriterion("AppIcon120 <>", value, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120GreaterThan(String value) {
            addCriterion("AppIcon120 >", value, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120GreaterThanOrEqualTo(String value) {
            addCriterion("AppIcon120 >=", value, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120LessThan(String value) {
            addCriterion("AppIcon120 <", value, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120LessThanOrEqualTo(String value) {
            addCriterion("AppIcon120 <=", value, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120Like(String value) {
            addCriterion("AppIcon120 like", value, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120NotLike(String value) {
            addCriterion("AppIcon120 not like", value, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120In(List<String> values) {
            addCriterion("AppIcon120 in", values, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120NotIn(List<String> values) {
            addCriterion("AppIcon120 not in", values, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120Between(String value1, String value2) {
            addCriterion("AppIcon120 between", value1, value2, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppIcon120NotBetween(String value1, String value2) {
            addCriterion("AppIcon120 not between", value1, value2, "appIcon120");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1IsNull() {
            addCriterion("AppDesImage1 is null");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1IsNotNull() {
            addCriterion("AppDesImage1 is not null");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1EqualTo(String value) {
            addCriterion("AppDesImage1 =", value, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1NotEqualTo(String value) {
            addCriterion("AppDesImage1 <>", value, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1GreaterThan(String value) {
            addCriterion("AppDesImage1 >", value, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1GreaterThanOrEqualTo(String value) {
            addCriterion("AppDesImage1 >=", value, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1LessThan(String value) {
            addCriterion("AppDesImage1 <", value, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1LessThanOrEqualTo(String value) {
            addCriterion("AppDesImage1 <=", value, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1Like(String value) {
            addCriterion("AppDesImage1 like", value, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1NotLike(String value) {
            addCriterion("AppDesImage1 not like", value, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1In(List<String> values) {
            addCriterion("AppDesImage1 in", values, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1NotIn(List<String> values) {
            addCriterion("AppDesImage1 not in", values, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1Between(String value1, String value2) {
            addCriterion("AppDesImage1 between", value1, value2, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage1NotBetween(String value1, String value2) {
            addCriterion("AppDesImage1 not between", value1, value2, "appDesImage1");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2IsNull() {
            addCriterion("AppDesImage2 is null");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2IsNotNull() {
            addCriterion("AppDesImage2 is not null");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2EqualTo(String value) {
            addCriterion("AppDesImage2 =", value, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2NotEqualTo(String value) {
            addCriterion("AppDesImage2 <>", value, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2GreaterThan(String value) {
            addCriterion("AppDesImage2 >", value, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2GreaterThanOrEqualTo(String value) {
            addCriterion("AppDesImage2 >=", value, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2LessThan(String value) {
            addCriterion("AppDesImage2 <", value, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2LessThanOrEqualTo(String value) {
            addCriterion("AppDesImage2 <=", value, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2Like(String value) {
            addCriterion("AppDesImage2 like", value, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2NotLike(String value) {
            addCriterion("AppDesImage2 not like", value, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2In(List<String> values) {
            addCriterion("AppDesImage2 in", values, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2NotIn(List<String> values) {
            addCriterion("AppDesImage2 not in", values, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2Between(String value1, String value2) {
            addCriterion("AppDesImage2 between", value1, value2, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage2NotBetween(String value1, String value2) {
            addCriterion("AppDesImage2 not between", value1, value2, "appDesImage2");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3IsNull() {
            addCriterion("AppDesImage3 is null");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3IsNotNull() {
            addCriterion("AppDesImage3 is not null");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3EqualTo(String value) {
            addCriterion("AppDesImage3 =", value, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3NotEqualTo(String value) {
            addCriterion("AppDesImage3 <>", value, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3GreaterThan(String value) {
            addCriterion("AppDesImage3 >", value, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3GreaterThanOrEqualTo(String value) {
            addCriterion("AppDesImage3 >=", value, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3LessThan(String value) {
            addCriterion("AppDesImage3 <", value, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3LessThanOrEqualTo(String value) {
            addCriterion("AppDesImage3 <=", value, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3Like(String value) {
            addCriterion("AppDesImage3 like", value, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3NotLike(String value) {
            addCriterion("AppDesImage3 not like", value, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3In(List<String> values) {
            addCriterion("AppDesImage3 in", values, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3NotIn(List<String> values) {
            addCriterion("AppDesImage3 not in", values, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3Between(String value1, String value2) {
            addCriterion("AppDesImage3 between", value1, value2, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andAppDesImage3NotBetween(String value1, String value2) {
            addCriterion("AppDesImage3 not between", value1, value2, "appDesImage3");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlIsNull() {
            addCriterion("CallBackUrl is null");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlIsNotNull() {
            addCriterion("CallBackUrl is not null");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlEqualTo(String value) {
            addCriterion("CallBackUrl =", value, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlNotEqualTo(String value) {
            addCriterion("CallBackUrl <>", value, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlGreaterThan(String value) {
            addCriterion("CallBackUrl >", value, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("CallBackUrl >=", value, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlLessThan(String value) {
            addCriterion("CallBackUrl <", value, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlLessThanOrEqualTo(String value) {
            addCriterion("CallBackUrl <=", value, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlLike(String value) {
            addCriterion("CallBackUrl like", value, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlNotLike(String value) {
            addCriterion("CallBackUrl not like", value, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlIn(List<String> values) {
            addCriterion("CallBackUrl in", values, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlNotIn(List<String> values) {
            addCriterion("CallBackUrl not in", values, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlBetween(String value1, String value2) {
            addCriterion("CallBackUrl between", value1, value2, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCallBackUrlNotBetween(String value1, String value2) {
            addCriterion("CallBackUrl not between", value1, value2, "callBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlIsNull() {
            addCriterion("CancelCallBackUrl is null");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlIsNotNull() {
            addCriterion("CancelCallBackUrl is not null");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlEqualTo(String value) {
            addCriterion("CancelCallBackUrl =", value, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlNotEqualTo(String value) {
            addCriterion("CancelCallBackUrl <>", value, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlGreaterThan(String value) {
            addCriterion("CancelCallBackUrl >", value, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("CancelCallBackUrl >=", value, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlLessThan(String value) {
            addCriterion("CancelCallBackUrl <", value, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlLessThanOrEqualTo(String value) {
            addCriterion("CancelCallBackUrl <=", value, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlLike(String value) {
            addCriterion("CancelCallBackUrl like", value, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlNotLike(String value) {
            addCriterion("CancelCallBackUrl not like", value, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlIn(List<String> values) {
            addCriterion("CancelCallBackUrl in", values, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlNotIn(List<String> values) {
            addCriterion("CancelCallBackUrl not in", values, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlBetween(String value1, String value2) {
            addCriterion("CancelCallBackUrl between", value1, value2, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andCancelCallBackUrlNotBetween(String value1, String value2) {
            addCriterion("CancelCallBackUrl not between", value1, value2, "cancelCallBackUrl");
            return (Criteria) this;
        }

        public Criteria andAppStateIsNull() {
            addCriterion("AppState is null");
            return (Criteria) this;
        }

        public Criteria andAppStateIsNotNull() {
            addCriterion("AppState is not null");
            return (Criteria) this;
        }

        public Criteria andAppStateEqualTo(Integer value) {
            addCriterion("AppState =", value, "appState");
            return (Criteria) this;
        }

        public Criteria andAppStateNotEqualTo(Integer value) {
            addCriterion("AppState <>", value, "appState");
            return (Criteria) this;
        }

        public Criteria andAppStateGreaterThan(Integer value) {
            addCriterion("AppState >", value, "appState");
            return (Criteria) this;
        }

        public Criteria andAppStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("AppState >=", value, "appState");
            return (Criteria) this;
        }

        public Criteria andAppStateLessThan(Integer value) {
            addCriterion("AppState <", value, "appState");
            return (Criteria) this;
        }

        public Criteria andAppStateLessThanOrEqualTo(Integer value) {
            addCriterion("AppState <=", value, "appState");
            return (Criteria) this;
        }

        public Criteria andAppStateIn(List<Integer> values) {
            addCriterion("AppState in", values, "appState");
            return (Criteria) this;
        }

        public Criteria andAppStateNotIn(List<Integer> values) {
            addCriterion("AppState not in", values, "appState");
            return (Criteria) this;
        }

        public Criteria andAppStateBetween(Integer value1, Integer value2) {
            addCriterion("AppState between", value1, value2, "appState");
            return (Criteria) this;
        }

        public Criteria andAppStateNotBetween(Integer value1, Integer value2) {
            addCriterion("AppState not between", value1, value2, "appState");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}