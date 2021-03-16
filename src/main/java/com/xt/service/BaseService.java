package com.xt.service;

import com.xt.elasticsearch.ArticleRespository;
import com.xt.mapper.*;
import com.xt.redis.RedisService;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @ClassName: BaseService
 * @Description: 业务层的基类，所有业务层接口的实现类都需要继承此类
 **/
public class BaseService {

    @Resource
    protected CommentMapper commentMapper;

    @Resource
    protected MenuMapper menuMapper;

    @Resource
    protected LinkMapper linkMapper;

    @Resource
    protected AdminMapper adminMapper;

    @Resource
    protected ArticleMapper articleMapper;

    @Resource
    protected KindMapper kindMapper;

    @Resource
    protected TagMapper tagMapper;

    @Resource
    protected ArticleKindMapper articleKindMapper;

    @Resource
    protected ArticleTagMapper articleTagMapper;

    @Resource
    protected FrontMapper frontMapper;

    @Resource
    protected StatisticsMapper statisticsMapper;

    @Autowired
    protected RedisService redisService;

    @Autowired
    protected RestHighLevelClient client;

    @Autowired
    protected ArticleRespository articleRespository;
}
