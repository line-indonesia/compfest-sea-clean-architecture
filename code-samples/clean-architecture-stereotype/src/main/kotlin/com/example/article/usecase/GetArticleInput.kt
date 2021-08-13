package com.example.article.usecase

import com.example.stereotypes.usecase.InputBoundary

@InputBoundary
interface GetArticleInput {

    fun getArticle(articleId: ArticleIdData)
}
