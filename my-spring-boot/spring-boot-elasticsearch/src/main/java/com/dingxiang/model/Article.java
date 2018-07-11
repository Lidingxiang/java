package com.dingxiang.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/*
public @interface Document {

    String indexName();//索引库的名称，个人建议以项目的名称命名

    String type() default "";//类型，个人建议以实体的名称命名

    short shards() default 5;//默认分区数

    short replicas() default 1;//每个分区默认的备份数

    String refreshInterval() default "1s";//刷新间隔

    String indexStoreType() default "fs";//索引文件存储类型
}
* */


/*
public @interface Field {

    FieldType type() default FieldType.Auto;#自动检测属性的类型

    FieldIndex index() default FieldIndex.analyzed;#默认情况下分词

    DateFormat format() default DateFormat.none;

    String pattern() default "";

    boolean store() default false;#默认情况下不存储原文

    String searchAnalyzer() default "";#指定字段搜索时使用的分词器

    String indexAnalyzer() default "";#指定字段建立索引时指定的分词器

    String[] ignoreFields() default {};#如果某个字段需要被忽略

    boolean includeInParent() default false;
}
* */


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "xmp", type = "news")
public class Article implements Serializable {

    @Id
    private Long id;
    /**
     * 标题
     */
    @Field(type = FieldType.String, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String title;
    /**
     * 摘要
     */
    private String abstracts;
    /**
     * 内容
     */
    private String content;
    /**
     * 发表时间
     */
    private Date postTime;
    /**
     * 点击率
     */
    private Long clickCount;
    /**
     * 作者
     */
    private Author author;
    /**
     * 所属教程
     */
    private Tutorial tutorial;

    public Article() {
    }

    public Article(Long id, String title, String abstracts, String content, Date postTime, Long clickCount, Author author, Tutorial tutorial) {
        this.id = id;
        this.title = title;
        this.abstracts = abstracts;
        this.content = content;
        this.postTime = postTime;
        this.clickCount = clickCount;
        this.author = author;
        this.tutorial = tutorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }
}