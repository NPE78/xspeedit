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

    public void checkValidDescription(String articles) throws InvalidArticlesFormatException {
        boolean matches = Optional.ofNullable(articles)
                .map(this::articlesMatchesPattern)
                .orElse(false);
        if (!matches) {
            throw new InvalidArticlesFormatException("The description of the articles is invalid. Please check your input");
        }
    }

    private boolean articlesMatchesPattern(String articles) {
        return articleDescriptionPattern.matcher(articles).matches();
    }
}
