package com.example.article.framework

import com.example.article.adapter.ArticleViewModel
import com.example.stereotypes.framework.View

@View
class ArticleView {
    fun setArticle(article: ArticleViewModel) {

    }

    fun getArticle(): ArticleViewModel {
        return ArticleViewModel()
    }
}
