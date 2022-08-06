package com.ratish.newsapp;

import java.util.ArrayList;

public class News {

    private String status;
    private String totalResults;
    private ArrayList<NewsModelClass> articles;

    public News(String status, String totalResults, ArrayList<NewsModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsModelClass> articles) {
        this.articles = articles;
    }
}
