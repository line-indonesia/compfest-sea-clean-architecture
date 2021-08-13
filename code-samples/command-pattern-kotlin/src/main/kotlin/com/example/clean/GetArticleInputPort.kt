package com.example.clean

import com.example.stereotype.Command

@Command
interface GetArticleInputPort {

    fun execute()
}
