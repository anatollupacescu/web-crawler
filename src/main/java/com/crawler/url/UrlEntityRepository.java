package com.crawler.url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlEntityRepository extends JpaRepository<UrlEntity, String> {

//	UrlEntity findOneByUrl(String url);
}