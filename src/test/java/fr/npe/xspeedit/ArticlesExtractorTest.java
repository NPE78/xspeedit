package fr.npe.xspeedit;

import fr.npe.xspeedit.exceptions.InvalidArticlesFormatException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

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

    @Test(expected = InvalidArticlesFormatException.class)
    public void checkInvalidString0() throws InvalidArticlesFormatException {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        articlesExtractor.checkValidDescription("0");
    }

    @Test(expected = InvalidArticlesFormatException.class)
    public void checkInvalidStringA() throws InvalidArticlesFormatException {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        articlesExtractor.checkValidDescription("a");
    }

    @Test(expected = InvalidArticlesFormatException.class)
    public void checkInvalidString1A() throws InvalidArticlesFormatException {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        articlesExtractor.checkValidDescription("1a");
    }

    @Test(expected = InvalidArticlesFormatException.class)
    public void checkInvalidEmptyString() throws InvalidArticlesFormatException {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        articlesExtractor.checkValidDescription("");
    }

    @Test(expected = InvalidArticlesFormatException.class)
    public void checkInvalidNullString() throws InvalidArticlesFormatException {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();
        articlesExtractor.checkValidDescription(null);
    }
}
