package com.xt.mapper;

import com.xt.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @InterfaceName CommentMapper
 * @Description (Comment)表数据库访问层
 * @Version 1.0
 **/
@Mapper
public interface CommentMapper {

    /**
     * @Description 添加Comment
     * @param comment 实例对象
     * @return 影响行数
     */
    int insert(Comment comment);
    
    /**
     * @Description 删除Comment
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * @Description 删除Comment
     * @param id 回复ID
     * @return 影响行数
     */
    int deleteByReplyId(Integer id);

    /**
     * @Description 删除Comment
     * @param id 文章ID
     * @return 影响行数
     */
    int deleteByArticleId(Integer id);

    /**
     * @Description 查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Comment queryById(Integer id);

    /**
     * @Description 实体作为筛选条件查询数据
     * @param comment 实例对象
     * @return 对象列表
     */
    List<Comment> queryAll(Comment comment);

    /**
     * @Description 修改Comment,根据 comment 的主键修改数据
     * @param comment
     * @return 影响行数
     */
    int update(Comment comment);

    /**
     * @Description 根据文章ID和类型获取文章
     * @Param [aId, type]
     * @return java.util.List<com.moti.entity.Comment>
     **/
    List<Comment> queryByArticleIdAndType(@Param("aId") Integer aId, @Param("type") Integer type);

    /**
     * @Description 获取所有回复的文章
     * @Param [id]
     * @return java.util.List<com.moti.entity.Comment>
     **/
    List<Comment> queryReplyComment(Integer id);

    /**
     * @Description 获取评论的数量
     * @Param []
     * @return java.lang.Integer
     **/
    Integer getCount();

    /**
     * @Description 获取未读评论的数量
     * @Param []
     * @return java.lang.Integer
     **/
    Integer getUnReadCount();
 }