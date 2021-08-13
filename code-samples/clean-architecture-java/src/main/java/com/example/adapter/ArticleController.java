package com.example.adapter;

import com.example.entity.Article;
import com.example.entity.ArticleId;
import com.example.usecase.ArticleGateway;
import com.example.usecase.GetArticleUseCase;

public class ArticleController {

    private final GetArticleUseCase getArticleUseCase;

    public ArticleController() {
        ArticleGateway gateway = new DatabaseGateway();
        this.getArticleUseCase = new GetArticleUseCase(gateway);
    }

    @GetMapping("/article")
    public HtmlTemplate getArticle(@RequestParam("id") String idValue) {
        // Conversion to use case data structure
        ArticleId id = new ArticleId(idValue);
        Article article = getArticleUseCase.execute(id);
        // No conversion from use case data structure
        return new HtmlTemplate(article);
    }
}

