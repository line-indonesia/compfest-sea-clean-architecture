package com.example.article.usecase

import com.example.stereotypes.usecase.OutputData

@OutputData
data class ArticleData(val title: String, val publishedAt: String)
