package fr.npe.xspeedit;

import fr.npe.xspeedit.exceptions.InvalidArticlesFormatException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticlesExtractorTest {

    @Test
    public void checkExtractedString123() throws InvalidArticlesFormatException {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        Assertions.assertThat(articlesExtractor.extract("123")).containsExactly(1, 2, 3);
    }

    @Test
    public void checkExtractedString111222888999() throws InvalidArticlesFormatException {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        Assertions.assertThat(articlesExtractor.extract("111222888999")).containsExactly(1, 1, 1, 2, 2, 2, 8, 8, 8, 9, 9, 9);
    }

    @Test
    public void checkInvalidString0() {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        Assertions.assertThatThrownBy(() -> articlesExtractor.checkValidDescription("0")).isInstanceOf(InvalidArticlesFormatException.class);
    }

    @Test
    public void checkInvalidStringA() {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        Assertions.assertThatThrownBy(() -> articlesExtractor.checkValidDescription("a")).isInstanceOf(InvalidArticlesFormatException.class);
    }

    @Test
    public void checkInvalidString1A() {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        Assertions.assertThatThrownBy(() -> articlesExtractor.checkValidDescription("1a")).isInstanceOf(InvalidArticlesFormatException.class);
    }

    @Test
    public void checkInvalidEmptyString() {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        Assertions.assertThatThrownBy(() -> articlesExtractor.checkValidDescription("")).isInstanceOf(InvalidArticlesFormatException.class);
    }

    @Test
    public void checkInvalidNullString() {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        Assertions.assertThatThrownBy(() -> articlesExtractor.checkValidDescription(null)).isInstanceOf(InvalidArticlesFormatException.class);
    }
}
