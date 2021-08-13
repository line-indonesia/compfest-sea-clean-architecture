package com.example.usecase;

import com.example.entity.Article;
import com.example.entity.ArticleId;

public interface ArticleGateway {

    Article getArticle(ArticleId articleId);
}
