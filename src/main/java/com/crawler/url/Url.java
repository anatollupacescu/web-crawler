package com.crawler.url;

import java.util.Objects;

public class Url {

    private String url;
    private String rank;

    public Url() {
    }

    public Url(String url, String rank) {
        this.url = url;
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url1 = (Url) o;
        return Objects.equals(url, url1.url) &&
                Objects.equals(rank, url1.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, rank);
    }

    @Override
    public String toString() {
        return "Url{" + "url='" + url + '\'' + ", rank='" + rank + '\'' + '}';
    }
}
