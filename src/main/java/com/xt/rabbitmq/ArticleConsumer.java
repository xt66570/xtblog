package com.xt.rabbitmq;

import com.xt.elasticsearch.ArticleRespository;
import com.xt.entity.Article;
import com.xt.redis.ArticleKey;
import com.xt.redis.RedisService;
import com.xt.service.ArticleService;
import com.xt.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ArticleConsumer
 * @Description: 文章消费者
 **/
@Component
public class ArticleConsumer{

    private Logger logger = LogUtils.getInstance(ArticleConsumer.class);

    @Autowired
    ArticleRespository respository;

    @Autowired
    ArticleService articleService;

    @Autowired
    RedisService redisService;

    /**
     * @Description 保存/更新文档到ES
     * @Param [message]
     * @return void
     **/
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "es",type = "topic"),
                    key = {"article.save"}
            )
    })
    public void saveArticle(String message){
        logger.warn("【RabbitMq】保存文章的消息，ID："+message);
        Article article = articleService.queryById(Integer.parseInt(message));
        article.setImg(null);
        article.setRecentEdit(null);
        article.setTags(null);
        article.setKinds(null);
        article.setStatus(null);
        respository.save(article);
        logger.warn("【RabbitMq】消费成功");
    }

    /**
     * @Description 从ES中删除文档
     * @Param [message]
     * @return void
     **/
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "es",type = "topic"),
                    key = {"article.delete"}
            )
    })
    public void deleteArticle(String message){
        logger.warn("【RabbitMq】删除文章的消息，ID："+message);
        respository.deleteById(Integer.parseInt(message));
        logger.warn("【RabbitMq】消费成功");
        redisService.decr(ArticleKey.getEsCount,"");
    }
}
