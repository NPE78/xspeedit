package fr.npe.xspeedit;

import fr.npe.xspeedit.exceptions.InvalidArticlesFormatException;

import java.util.List;
import java.util.stream.Collectors;

public class XspeeditMain {

    public static void main(String[] args) {
        XspeeditMain xspeeditMain = new XspeeditMain();
        try {
            xspeeditMain.tryToPack("163841689525773");
        } catch (InvalidArticlesFormatException invalidArticlesFormatException) {
            System.err.println(invalidArticlesFormatException.getMessage());
        }
    }

    public void tryToPack(String articles) throws InvalidArticlesFormatException {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();

        System.out.printf("Articles      : %s\n", articles);
        List<Integer> extractedArticles = articlesExtractor.extract(articles);

        int maximumSize = 10;
        DumbRobot dumbRobot = new DumbRobot(maximumSize);
        System.out.printf("Robot actuel  : %s\n", develop(dumbRobot.pack(extractedArticles)));

        OptimizedRobot optimizedRobot = new OptimizedRobot(maximumSize);
        System.out.printf("Robot optimisé: %s\n", develop(optimizedRobot.pack(extractedArticles)));
    }

    private String develop(List<Integer> articles) {
        return String.format("%s => %s carton(s) utilisé(s)", concatArticles(articles), articles.size());
    }

    public String concatArticles(List<Integer> articles) {
        return articles.stream().map(Object::toString).collect(Collectors.joining("/"));
    }
}
