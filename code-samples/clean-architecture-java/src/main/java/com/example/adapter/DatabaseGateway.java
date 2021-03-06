package com.example.adapter;

import com.example.entity.Article;
import com.example.entity.ArticleId;
import com.example.usecase.ArticleGateway;

public class DatabaseGateway implements ArticleGateway {

    @Override
    public Article getArticle(ArticleId articleId) {
        // Connect database
        return new Article("Compfest - Tech to Elevate");
    }
}
