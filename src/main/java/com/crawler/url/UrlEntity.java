package com.crawler.url;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "url")
public class UrlEntity extends Url implements java.io.Serializable {

    @Id
    public String getUrl() {
        return super.getUrl();
    }

    @Column
    public String getRank() {
        return super.getRank();
    }

    private String keyword;

    @Column
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    protected UrlEntity() {
    }

    public UrlEntity(String url, String rank, String keyword) {
        super(url, rank);
        this.keyword = keyword;
    }
}
