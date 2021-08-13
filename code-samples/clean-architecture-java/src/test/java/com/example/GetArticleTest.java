package com.example;

import com.example.entity.Article;
import com.example.entity.ArticleId;
import com.example.usecase.ArticleGateway;
import com.example.usecase.GetArticleUseCase;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetArticleTest {

    @Test
    public void testGetArticle_success() {
        // Given
        // In-memory article gateway as opposed to Database gateway
        Article expected = new Article("Compfest - Tech to Elevate");
        ArticleGateway articleGateway = articleId -> expected;
        GetArticleUseCase getArticleUseCase = new GetArticleUseCase(articleGateway);
        // Valid article id
        ArticleId articleId = new ArticleId(UUID.randomUUID().toString());

        // When
        Article actual = getArticleUseCase.execute(articleId);

        // Then
        assertEquals(actual.getTitle(), expected.getTitle());
    }

    @Test
    public void testGetArticle_fail() {
        // Given
        // In-memory article gateway as opposed to Database gateway
        ArticleGateway articleGateway = articleId -> {
            if (articleId.getId().equals("1")) {
                throw new IllegalArgumentException();
            }
            return new Article("Compfest - Tech to Elevate");
        };
        GetArticleUseCase getArticleUseCase = new GetArticleUseCase(articleGateway);
        // Invalid article id
        ArticleId articleId = new ArticleId("1");

        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            // When
            getArticleUseCase.execute(articleId);
        });
    }
}
