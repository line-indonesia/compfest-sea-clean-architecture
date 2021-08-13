package com.example.article.adapter

import com.example.stereotypes.adapter.ViewModel

@ViewModel
data class ArticleViewModel(
    val id: String = "",
    val title: String = "",
    val publishedAt: String = ""
)
