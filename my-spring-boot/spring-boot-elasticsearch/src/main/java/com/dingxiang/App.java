package com.dingxiang;

import com.dingxiang.model.Article;
import com.dingxiang.model.Author;
import com.dingxiang.model.Tutorial;
import com.dingxiang.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Slf4j
@SpringBootApplication
public class App implements CommandLineRunner {

    Logger log = org.apache.log4j.Logger.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private ArticleService articleService;

    @Override
    public void run(String... strings) throws Exception {
        printElasticSearchInfo();
        //插入10条信息
        for (long i = 0; i < 10; i++) {
            Author author = new Author(null, "xmp", null);
            System.out.println(author);
            Tutorial tutorial = new Tutorial(i, "test" + String.valueOf(i));
            Article article = new Article(i, "title", "abs", "content", new Date(), i, author, tutorial);
            articleService.save(article);
        }

        Page<Article> articles = articleService.findByTitle("title", new PageRequest(0, 5));
        List<Article> articleList = articleService.findByTitle("title");

        String queryString = "test1";

        //搜索关键字
        Iterable<Article> searchResult = articleService.search(queryString);
        Iterator<Article> iterator = searchResult.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private void printElasticSearchInfo() {
        log.info("--ElasticSearch-->");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();
        asMap.forEach((k, v) -> {
            log.info("=========>" + k + "=" + v);
        });
    }


}
