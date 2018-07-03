package fr.npe.xspeedit.domain.robot;

import fr.npe.xspeedit.domain.model.Pack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Algorithm:
 * from the biggest article, we try to find the biggest one possible for this package and so on
 */
public class SmartRobot implements IRobot {

    private final int maximumSize;

    private final Comparator<Integer> integerReversedComparator;

    public SmartRobot(int maximumSize) {
        this.maximumSize = maximumSize;

        Comparator<Integer> naturalIntegerComparator = Integer::compare;
        integerReversedComparator = naturalIntegerComparator.reversed();
    }

    @Override
    public String getDescription() {
        return "optimisé";
    }

    @Override
    public List<Pack> pack(List<Integer> articles) {
        List<Pack> packed = new ArrayList<>();

        List<Integer> sortedArticles = getSortedArticles(articles);

        while (!sortedArticles.isEmpty()) {
            packed.add(getNextPack(sortedArticles));
        }
        return packed;
    }

    /**
     * Returns a new package as much filled as possible
     *
     * @param sortedArticles the remaining articles which have not been used yet
     * @return the new pack
     */
    private Pack getNextPack(List<Integer> sortedArticles) {
        Pack pack = new Pack(maximumSize);
        Iterator<Integer> iterator = sortedArticles.iterator();
        while (iterator.hasNext()) {
            Integer currentArticle = iterator.next();
            if (pack.canAdd(currentArticle)) {
                pack.add(currentArticle);
                iterator.remove();
            }
        }
        return pack;
    }

    private List<Integer> getSortedArticles(List<Integer> articles) {
        List<Integer> sortedArticles = new ArrayList<>(articles);
        sortedArticles.sort(integerReversedComparator);
        return sortedArticles;
    }
}
