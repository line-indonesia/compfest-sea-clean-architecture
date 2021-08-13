package com.example.usecase

import com.example.entity.Article
import com.example.entity.ArticleId

interface ArticleGateway {
    fun getArticle(articleId: ArticleId): Article
}
