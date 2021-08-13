package com.example.article.usecase

import com.example.stereotypes.usecase.OutputBoundary

@OutputBoundary
interface GetArticleOutput {
    fun showArticle(article: ArticleData)
}
