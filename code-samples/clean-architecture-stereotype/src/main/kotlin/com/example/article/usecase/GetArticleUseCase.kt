package com.example.article.usecase

import com.example.article.entity.ArticleIdEntity
import com.example.stereotypes.usecase.UseCase

@UseCase
class GetArticleUseCase(
    private val articleGateway: ArticleGateway,
    private val getArticleOutput: GetArticleOutput
) : GetArticleInput {

    override fun getArticle(articleId: ArticleIdData) {
        val entity = ArticleIdEntity(articleId.id)
        val articleEntity = articleGateway.getArticle(entity)
        val articleData = ArticleData(articleEntity.title, articleEntity.publishedAt)
        getArticleOutput.showArticle(articleData)
    }
}
