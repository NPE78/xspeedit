package fr.npe.xspeedit;

import fr.npe.xspeedit.exceptions.InvalidArticlesFormat;

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

    public List<Integer> extract(String articles) throws InvalidArticlesFormat {
        checkValidDescription(articles);
        return Arrays.stream(articles.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public void checkValidDescription(String articles) throws InvalidArticlesFormat {
        boolean matches = Optional.ofNullable(articles)
                .map(this::articlesMatchesPattern)
                .orElse(false);
        if (!matches) {
            throw new InvalidArticlesFormat("The description of the articles is invalid. Please check your input");
        }
    }

    private boolean articlesMatchesPattern(String articles) {
        return articleDescriptionPattern.matcher(articles).matches();
    }
}
