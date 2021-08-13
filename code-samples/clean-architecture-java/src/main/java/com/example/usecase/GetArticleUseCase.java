package com.example.usecase;

import com.example.entity.Article;
import com.example.entity.ArticleId;

public class GetArticleUseCase {

    private final ArticleGateway articleGateway;

    public GetArticleUseCase(ArticleGateway articleGateway) {
        this.articleGateway = articleGateway;
    }

    public Article execute(ArticleId articleId) {
        return articleGateway.getArticle(articleId);
    }
}
