package com.example.article.adapter

import com.example.article.framework.ArticleView
import com.example.article.usecase.ArticleData
import com.example.article.usecase.GetArticleOutput
import com.example.stereotypes.adapter.Presenter

@Presenter
class ArticlePresenter(
    private val articleView: ArticleView
) : GetArticleOutput {

    override fun showArticle(article: ArticleData) {
        val articleViewModel = ArticleViewModel(article.title, article.publishedAt)
        articleView.setArticle(articleViewModel)
    }
}
