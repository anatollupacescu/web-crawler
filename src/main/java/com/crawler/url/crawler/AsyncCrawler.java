package com.crawler.url.crawler;

import com.crawler.url.Url;
import com.crawler.url.UrlEntity;
import com.crawler.url.UrlEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class AsyncCrawler implements Crawler {

    private static final Logger logger = LoggerFactory.getLogger(AsyncCrawler.class);

    @Inject
    private UrlEntityRepository repository;
    @Inject
    private ExecutorService executorService;
    @Inject
    private PageParser parser;
    @Value("${title.keywords}")
    List<String> keywords;

    public void crawl(Url url) {
        final String urlAddress = url.getUrl();
        //running both tasks in the thread pool
        CompletableFuture
                .supplyAsync(() -> parser.getTitle(urlAddress), executorService)
                .thenAccept(title -> storeUrlContainingKeyword(title, url));
    }

    private void storeUrlContainingKeyword(String title, Url url) {
        keywords.stream()
                .filter(title::contains)
                .findAny()
                .ifPresent(keyword -> {
                    UrlEntity entity = new UrlEntity(url.getUrl(), url.getRank(), keyword);
                    UrlEntity savedEntity = repository.save(entity);
                    logger.debug("Entity {} containing keyword '{}' has been stored", savedEntity, keyword);
                });
    }
}
