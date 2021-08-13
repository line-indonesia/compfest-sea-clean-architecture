package com.example

import com.example.entity.Article
import com.example.entity.ArticleId
import com.example.usecase.ArticleGateway
import com.example.usecase.ArticlePresenter
import com.example.usecase.GetArticleUseCase
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID

class GetArticleTest {

    @Test
    fun testGetArticle_success() {
        // Given
        var isShowArticleCalled = false
        val presenter = object : ArticlePresenter {
            override fun showArticle(article: Article) {
                isShowArticleCalled = true
            }
        }
        val gateway = object : ArticleGateway {
            override fun getArticle(articleId: ArticleId): Article {
                return Article("Compfest - Tech to Elevate")
            }
        }
        val validArticleId = UUID.randomUUID().toString()
        val getArticle = GetArticleUseCase(gateway, presenter)

        // When
        getArticle.execute(validArticleId)

        // Then
        assertTrue(isShowArticleCalled)
    }

    @Test
    fun testGetArticle_fail() {
        // Given
        val gateway = object : ArticleGateway {
            override fun getArticle(articleId: ArticleId): Article {
                if (articleId == "1") {
                    throw IllegalArgumentException()
                }
                return Article("Compfest - Tech to Elevate")
            }
        }
        val invalidArticleId = "1"
        val getArticle = GetArticleUseCase(gateway, object : ArticlePresenter {
            override fun showArticle(article: Article) {}
        })

        // Then
        assertThrows<IllegalArgumentException> {
            // When
            getArticle.execute(invalidArticleId)
        }
    }
}
