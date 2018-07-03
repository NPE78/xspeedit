package fr.npe.xspeedit;

import fr.npe.xspeedit.domain.model.Pack;
import fr.npe.xspeedit.domain.robot.DumbRobot;
import fr.npe.xspeedit.domain.robot.IRobot;
import fr.npe.xspeedit.domain.robot.SmartRobot;
import fr.npe.xspeedit.exceptions.InvalidArticlesFormatException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class XspeeditMain {

    private static final String DEFAULT_ARTICLES = "163841689525773";

    private final List<IRobot> robots;

    /**
     * Constructor which takes a list of supported robots to try to pack any list of articles
     *
     * @param robots one or many robots
     */
    public XspeeditMain(IRobot... robots) {
        this.robots = Arrays.asList(robots);
    }

    public static void main(String[] args) {

        XspeeditMain xspeeditMain = new XspeeditMain(
                new DumbRobot(10),
                new SmartRobot(10)
        );
        try {
            xspeeditMain.tryToPack(args);
        } catch (InvalidArticlesFormatException invalidArticlesFormatException) {
            System.err.println(invalidArticlesFormatException.getMessage());
        }
    }

    public void tryToPack(String[] input) throws InvalidArticlesFormatException {
        ArticlesExtractor articlesExtractor = new ArticlesExtractor();

        String articles = getArticlesFromInput(input).orElse(DEFAULT_ARTICLES);

        pack(articlesExtractor.extract(articles));
    }

    public Optional<String> getArticlesFromInput(String[] args) {
        return Optional.ofNullable(args)
                .filter(a -> a.length > 0)
                .map(a -> String.join("", a));
    }

    public void pack(List<Integer> articles) {
        System.out.printf("Articles       : %s\n", articles.stream().map(Object::toString).collect(Collectors.joining()));

        for (IRobot robot: robots) {
            System.out.printf("Robot %-8s : %s\n", robot.getDescription(), develop(robot.pack(articles)));
        }
    }

    private String develop(List<Pack> packs) {
        return String.format("%s => %s carton(s) utilisé(s)", concatPacks(packs), packs.size());
    }

    public String concatPacks(List<Pack> packs) {
        return packs.stream().map(Pack::toString).collect(Collectors.joining("/"));
    }
}
