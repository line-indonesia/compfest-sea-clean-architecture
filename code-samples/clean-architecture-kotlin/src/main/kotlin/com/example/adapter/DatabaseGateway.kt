package com.example.adapter

import com.example.usecase.ArticleGateway
import com.example.entity.Article
import com.example.entity.ArticleId

class DatabaseGateway : ArticleGateway {
    override fun getArticle(articleId: ArticleId): Article {
        return Article("Compfest - Tech to Elevate")
    }
}
