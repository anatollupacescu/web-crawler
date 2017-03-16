package com.crawler.url.crawler;

import java.util.concurrent.TimeUnit;

public class JSoupWebPageParser implements PageParser {

    //all the jsoup related stuff will go here, for now I will provide a fake parser

    @Override
    public String getTitle(String page) {
        try {
            //simulate network round-trip and parsing time
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (page.endsWith(".edu")) {
            return "news";
        }
        return "title";
    }
}
