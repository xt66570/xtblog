package com.xt.mapper;

import com.xt.entity.Article;
import com.xt.entity.ArticleDateArchive;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

 /**
 * @InterfaceName ArticleMapper
 * @Description (Article)表数据库访问层
 **/
@Mapper
public interface ArticleMapper {

    /**
     * @Description 添加Article
     * @param article 实例对象
     * @return 影响行数
     */
    int insert(Article article);
    
    /**
     * @Description 删除Article
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * @Description 查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);

    /**
     * @Description 根据状态获取文章
     * @Param [status]
     * @return java.util.List<com.moti.entity.Article>
     **/
    List<Article> queryByStatus(Integer status);

    /**
     * @Description 修改Article,根据 article 的主键修改数据
     * @param article
     * @return 影响行数
     */
    int update(Article article);

    /**
      * @Description 根据条件获取文章数量
      * @Param [article]
      * @return java.lang.Integer
      **/
    Integer totalCount(Integer status);

    /**
     * @Description 获取阅读量最高的文章
     * @Param []
     * @return java.util.List<com.moti.entity.Article>
     **/
    List<Article> orderByReadCount();

     /**
      * @Description 获得文章日期归档
      * @Param []
      * @return java.util.List<com.moti.entity.ArticleDateArchive>
      **/
     List<ArticleDateArchive> getArchive();

     /**
      * @Description 根据发表时间降序获取文章
      * @Param []
      * @return java.util.List<com.moti.entity.Article>
      **/
     List<Article> orderByPublishTime();

     /**
      * @Description 根据Id获得文章标题
      * @Param [aId]
      * @return java.lang.String
      **/
     String getTitle(Integer aId);

     /**
      * @Description 根据标签ID获取已发布的文章
      * @Param [id]
      * @return java.util.List<com.moti.entity.Article>
      **/
     List<Article> findByTagId(Integer id);

     /**
      * @Description 根据文集ID获取已发布的文章
      * @Param [id]
      * @return java.util.List<com.moti.entity.Article>
      **/
     List<Article> findByKindId(Integer id);

     /**
      * @Description 根据日期归档获取文章
      * @Param [date]
      * @return java.util.List<com.moti.entity.Article>
      **/
     List<Article> findByDate(Date date);

     /**
      * @Description 删除全部回收站文章
      * @Param []
      * @return java.lang.Integer
      **/
     Integer deleteTrash();
}