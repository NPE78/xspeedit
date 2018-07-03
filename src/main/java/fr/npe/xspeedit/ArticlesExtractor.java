package fr.npe.xspeedit;

import fr.npe.xspeedit.exceptions.InvalidArticlesFormatException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ArticlesExtractor {

    private final Pattern articleDescriptionPattern;

    public ArticlesExtractor() {
        articleDescriptionPattern = Pattern.compile("[1-9]+");
    }

    public List<Integer> extract(String articles) throws InvalidArticlesFormatException {
        checkValidDescription(articles);
        return Arrays.stream(articles.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    /**
     * Checks if the articles input matches the pattern: composed only of numbers from 1 to 9
     *
     * @param articles articles input
     * @throws InvalidArticlesFormatException exception thrown if the pattern does not match
     */
    public void checkValidDescription(String articles) throws InvalidArticlesFormatException {
        Optional.ofNullable(articles)
                .map(this::articlesMatchesPattern).filter(Boolean::booleanValue)
                .orElseThrow(InvalidArticlesFormatException::new);
    }

    private boolean articlesMatchesPattern(String articles) {
        return articleDescriptionPattern.matcher(articles).matches();
    }
}
