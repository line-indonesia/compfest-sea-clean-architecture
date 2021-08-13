package com.example.article.framework

import com.example.stereotypes.framework.Dto

@Dto
data class ArticleDto(val title: String, val createdAt: Long)
