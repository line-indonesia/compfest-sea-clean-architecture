package com.example.clean

import com.example.stereotype.Client

@Client
fun main() {
    val getArticleAdapter = object : GetArticleOutputPort {
        override fun getArticle(): String {
            print("Connect to database to get an article")
            return "Compfest - Tech to Elevate"
        }
    }

    val getArticleInputPort = GetArticleUseCase(getArticleAdapter)
    getArticleInputPort.execute()
}
