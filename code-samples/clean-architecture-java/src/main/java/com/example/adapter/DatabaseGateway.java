package com.example.adapter;

import com.example.usecase.ArticleGateway;
import com.example.entity.Article;
import com.example.entity.ArticleId;

public class DatabaseGateway implements ArticleGateway {

    @Override
    public Article getArticle(ArticleId articleId) {
        // Connect database
        return new Article("Compfest - Tech to Elevate");
    }
}
