package com.xt.entity;

import java.io.Serializable;

/**
 * (ArticleKind)实体类
 */
public class ArticleKind implements Serializable {

    private static final long serialVersionUID = 358621785759619121L;

    /**
    * 文章ID
    */
    private Integer articleId;

    /**
    * 类别ID
    */
    private Integer kindId;

    public ArticleKind(Integer articleId, Integer kindId) {
        this.articleId = articleId;
        this.kindId = kindId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    @Override
    public String toString() {
        return "ArticleKind{" +
                "articleId=" + articleId +
                "kindId=" + kindId +
                 '}';      
    }
}