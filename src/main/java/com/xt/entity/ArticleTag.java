package com.xt.entity;

import java.io.Serializable;

/**
 * (ArticleTag)实体类
 */
public class ArticleTag implements Serializable {

    private static final long serialVersionUID = 434354772002267796L;

    /**
    * 文章ID
    */
    private Integer articleId;
    /**
    * 标签ID
    */
    private Integer tagId;

    public ArticleTag(Integer articleId, Integer tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "ArticleTag{" +
                "articleId=" + articleId +
                "tagId=" + tagId +
                 '}';      
    }
}