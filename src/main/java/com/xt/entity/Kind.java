package com.xt.entity;

import java.io.Serializable;

/**
 * (Kind)实体类
 */
public class Kind implements Serializable {

    private static final long serialVersionUID = 837072739577740886L;

    /**
    * 类别的主键ID
    */
    private Integer id;

    /**
    * 名称
    */
    private String name;

    /**
    * 文章数
    */
    private Integer articleCount;

    /**
    * 类别的介绍
    */
    private String introduce;

    /**
    * 类别头图地址
    */
    private String img;

    public Kind() {
    }

    public Kind(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Kind{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", articleCount=" + articleCount +
                ", introduce='" + introduce + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}