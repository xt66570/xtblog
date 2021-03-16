package com.xt.task;

import com.xt.entity.Article;
import com.xt.redis.ArticleKey;
import com.xt.service.BaseService;
import com.xt.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: ArticleTask
 * @Description: 关于文章的定时器任务
 **/
@Service
public class ArticleTask extends BaseService {

    private Logger logger = LogUtils.getInstance(ArticleTask.class);

    /**
     * 定时任务将数据保存到ES：每天凌晨0：00
     * 用定时任务保证  es 与 数据库 数据的 一致性
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void saveToEs(){
        logger.warn("【定时任务】开始保存文章数据到ES");
        long startTime = System.currentTimeMillis();
        // 先清空再添加
        articleRespository.deleteAll();  //清空  es中 文章的index（类似与文章数据库）
        List<Article> articles = articleMapper.queryByStatus(1);//从数据库中查找所有已经发布的文章 得到集合
        for (Article article : articles) { //遍历文章集
            //排除一些无关属性
            article.setStatus(null);
            article.setKinds(null);
            article.setTags(null);
            article.setImg(null);
            article.setRecentEdit(null);
            articleRespository.save(article);  //把最新的 文章 保存到es的 index 中 用来搜索
        }
        long endTime = System.currentTimeMillis();
        logger.warn("【定时任务】结束保存文章数据到ES，"+"程序运行时间：" + (endTime - startTime) + "ms");
        //在缓存中  保存有多少条 es 文档 （记录）
        redisService.set(ArticleKey.getEsCount,"",articles.size(),60*60*24);
    }



    /**
     * 定时任务保存阅读量：每天凌晨0：00保存前一天晚上的阅读量
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void saveReadCount(){
        logger.warn("【定时任务】开始保存阅读量");  //从缓存中读取数据 保存到数据库中
        long startTime = System.currentTimeMillis();
        //模糊查询所有 readcount  的  子键
        Set<String> keys = redisService.keys(ArticleKey.getByReadCount);
        //遍历子键集合
        for (String key : keys) {
            //得到子键 : 以后 的 String 就是这个文章的id
            String id = key.substring(key.lastIndexOf(":")+1);
            //通过id 从缓存中读取 这篇文章的 阅读量
            Integer count = redisService.get(ArticleKey.getByReadCount, id, Integer.class);
            Article article = new Article();
            article.setId(Integer.valueOf(id));
            article.setReadCount(count);
            //这个更新会根据 新的article对象的 主键 去更新数据库中 该文章记录的  阅读量属性
            articleMapper.update(article);
        }
        long endTime = System.currentTimeMillis();
        logger.warn("【定时任务】结束保存阅读量，"+"程序运行时间：" + (endTime - startTime) + "ms");
    }


}
