package com.example.clean

import com.example.stereotype.ConcreteCommand

@ConcreteCommand
class GetArticleUseCase(
    private val getArticleOutputPort: GetArticleOutputPort
) : GetArticleInputPort {

    override fun execute() {
        getArticleOutputPort.getArticle()
    }
}
