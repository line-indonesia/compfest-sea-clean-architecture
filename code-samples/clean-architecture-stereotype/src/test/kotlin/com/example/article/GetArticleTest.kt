package com.example.article

import com.example.article.entity.ArticleEntity
import com.example.article.entity.ArticleIdEntity
import com.example.article.usecase.ArticleData
import com.example.article.usecase.ArticleGateway
import com.example.article.usecase.ArticleIdData
import com.example.article.usecase.GetArticleOutput
import com.example.article.usecase.GetArticleUseCase
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID

class GetArticleTest {

    @Test
    fun testGetArticle_success() {
        // Given
        var isShowArticleCalled = false
        val presenter = object : GetArticleOutput {
            override fun showArticle(article: ArticleData) {
                isShowArticleCalled = true
            }
        }
        val gateway = object : ArticleGateway {
            override fun getArticle(articleId: ArticleIdEntity): ArticleEntity {
                return ArticleEntity("Compfest - Tech to Elevate", "6 Agt 2021")
            }
        }
        val validArticleId = UUID.randomUUID().toString()
        val getArticle = GetArticleUseCase(gateway, presenter)

        // When
        getArticle.getArticle(ArticleIdData(validArticleId))

        // Then
        assertTrue(isShowArticleCalled)
    }

    @Test
    fun testGetArticle_fail() {
        // Given
        val gateway = object : ArticleGateway {
            override fun getArticle(articleId: ArticleIdEntity): ArticleEntity {
                if (articleId.id == "1") {
                    throw IllegalArgumentException()
                }
                return ArticleEntity("Compfest - Tech to Elevate", "6 Agt 2021")
            }
        }
        val invalidArticleId = "1"
        val getArticle = GetArticleUseCase(gateway, object : GetArticleOutput {
            override fun showArticle(article: ArticleData) {
            }
        })

        // Then
        assertThrows<IllegalArgumentException> {
            // When
            getArticle.getArticle(ArticleIdData(invalidArticleId))
        }
    }
}
