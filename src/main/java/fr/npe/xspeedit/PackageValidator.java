package fr.npe.xspeedit;

import java.util.List;

public class PackageValidator {

    private final int maximumSize;

    public PackageValidator(int maximumSize) {
        this.maximumSize = maximumSize;
    }

    /**
     * Returns the package size according to its articles
     * @param articles the list of the articles
     * @return its size
     */
    public Integer getPackageSize(List<Integer> articles) {
        return articles.stream().reduce(Integer::sum).orElse(0);
    }

    /**
     * Checks if the package has a size lower or equal to its maximum size
     * @param articles size of each of the articles
     * @return true if the package does not exceed its maximum size, false otherwise
     */
    public boolean isValidPackage(List<Integer> articles) {
        return getPackageSize(articles) <= maximumSize;
    }
}
