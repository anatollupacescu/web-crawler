package com.crawler.url;

import com.crawler.url.crawler.Crawler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
public class UrlController {

    @Inject
    private UrlEntityRepository urlEntityRepository;
    @Inject
    private Crawler crawlerService;

    @PostMapping("/crawl")
    @ResponseStatus(value = HttpStatus.OK)
    public Callable<String> crawl(@RequestBody List<Url> urlList) {
        return () -> {
            urlList.stream().parallel().forEach(crawlerService::crawl);
            return "Request accepted";
        };
    }

    @GetMapping(value = "/urls", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<UrlEntity> findAll() {
        return urlEntityRepository.findAll();
    }
}
