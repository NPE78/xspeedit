package fr.npe.xspeedit.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pack {

    private final int maximumSize;

    private final List<Integer> currentArticles;

    public Pack(int maximumSize) {
        this.maximumSize = maximumSize;
        this.currentArticles = new ArrayList<>();
    }

    public static Pack create(int maximumSize, Integer... articles) {
        Pack pack = new Pack(maximumSize);
        Arrays.asList(articles).forEach(pack::add);
        return pack;
    }

    /**
     * Returns the package size according to its articles
     *
     * @return its size
     */
    public Integer getPackageSize() {
        return currentArticles.stream().reduce(Integer::sum).orElse(0);
    }

    /**
     * Checks if the package has a size lower or equal to its maximum size
     *
     * @return true if the package does not exceed its maximum size, false otherwise
     */
    public boolean isValidPackage() {
        return getPackageSize() <= maximumSize;
    }

    public boolean canAdd(int article) {
        return getPackageSize() + article <= maximumSize;
    }

    public void add(int article) {
        currentArticles.add(article);
    }

    @Override
    public String toString() {
        return currentArticles.stream().map(Object::toString).collect(Collectors.joining());
    }
}
