package com.xt.elasticsearch;

import com.xt.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName: ArticleRespository
 **/
public interface ArticleRespository extends ElasticsearchRepository<Article,Integer> {
}
