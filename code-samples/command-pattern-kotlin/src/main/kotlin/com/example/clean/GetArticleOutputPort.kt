package com.example.clean

import com.example.stereotype.Receiver

@Receiver
interface GetArticleOutputPort {
    fun getArticle(): String
}
