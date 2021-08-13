package com.example.article.adapter

import com.example.article.framework.ArticleView
import com.example.article.usecase.ArticleGateway
import com.example.article.usecase.ArticleIdData
import com.example.article.usecase.GetArticleInput
import com.example.article.usecase.GetArticleOutput
import com.example.article.usecase.GetArticleUseCase
import com.example.stereotypes.adapter.Controller

@Controller
class ArticleActivity {

    private val getArticleOutput: GetArticleOutput = ArticlePresenter(getArticleView())

    private val articleGateway: ArticleGateway = ArticleDataAccess()

    private val getArticleInput: GetArticleInput = GetArticleUseCase(articleGateway, getArticleOutput)

    @OnClick("textViewArticle")
    fun getArticle(articleView: ArticleView) {
        val id = articleView.getArticle().id
        val articleIdData = ArticleIdData(id)
        getArticleInput.getArticle(articleIdData)
    }

    private fun getArticleView(): ArticleView {
        return ArticleView()
    }
}
