package com.example.adapter

import com.example.entity.Article
import com.example.entity.ArticleId
import com.example.usecase.ArticleGateway
import com.example.usecase.ArticlePresenter
import com.example.usecase.GetArticleUseCase

class ArticleActivity {

    private val presenter: ArticlePresenter = object : ArticlePresenter {
        override fun showArticle(article: Article) {
            // No conversion from use case data structure
            TextView().setText(article.title)
        }
    }

    private val gateway: ArticleGateway = DatabaseGateway()

    private val getArticleUseCase = GetArticleUseCase(gateway, presenter)

    @OnClick("textViewArticle")
    fun getArticle(textView: TextView) {
        // Conversion to use case data structure
        val articleId = textView.getText() as ArticleId
        getArticleUseCase.execute(articleId)
    }
}
