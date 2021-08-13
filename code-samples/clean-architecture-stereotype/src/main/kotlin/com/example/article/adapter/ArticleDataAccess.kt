package com.example.article.adapter

import com.example.article.entity.ArticleEntity
import com.example.article.entity.ArticleIdEntity
import com.example.article.framework.ArticleDto
import com.example.article.usecase.ArticleGateway
import com.example.stereotypes.adapter.DataAccess
import java.text.DateFormat
import java.util.Date
import java.util.Locale

@DataAccess
class ArticleDataAccess : ArticleGateway {

    override fun getArticle(articleId: ArticleIdEntity): ArticleEntity {
        val articleDto = queryArticleById(articleId.id)
        val publishedAt = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
            .format(Date(articleDto.createdAt))
        return ArticleEntity(articleDto.title, publishedAt)
    }

    private fun queryArticleById(articleId: String): ArticleDto {
        // Pretend we do SQL query
        return ArticleDto("", System.currentTimeMillis())
    }
}
