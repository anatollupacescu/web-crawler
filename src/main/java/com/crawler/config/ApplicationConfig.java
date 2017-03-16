package com.crawler.config;

import com.crawler.Application;
import com.crawler.url.crawler.AsyncCrawler;
import com.crawler.url.crawler.Crawler;
import com.crawler.url.crawler.JSoupWebPageParser;
import com.crawler.url.crawler.PageParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@PropertySource("classpath:persistence.properties")
@PropertySource("classpath:application.properties")
@ComponentScan(basePackageClasses = Application.class)
class ApplicationConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ExecutorService executorService(@Value("${thread.count}") Integer numberOfThreads) {
        return Executors.newFixedThreadPool(numberOfThreads);
    }

    @Bean
    public PageParser jSoupWebPageParser() {
        return new JSoupWebPageParser();
    }

    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }

    @Bean
    public Crawler asyncCrawler() {
        return new AsyncCrawler();
    }
}