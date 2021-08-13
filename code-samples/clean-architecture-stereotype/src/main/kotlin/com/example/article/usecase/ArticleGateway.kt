package com.example.article.usecase

import com.example.article.entity.ArticleEntity
import com.example.article.entity.ArticleIdEntity
import com.example.stereotypes.usecase.DataAccessInterface

@DataAccessInterface
interface ArticleGateway {

    fun getArticle(articleId: ArticleIdEntity): ArticleEntity
}
