package com.example.usecase

import com.example.entity.ArticleId

class GetArticleUseCase(
    private val articleGateway: ArticleGateway,
    private val articlePresenter: ArticlePresenter
) {

    fun execute(articleId: ArticleId) {
        val article = articleGateway.getArticle(articleId)
        articlePresenter.showArticle(article)
    }
}
