package fr.npe.xspeedit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DumbRobot implements IRobot {

    private final PackageValidator packageValidator;

    public DumbRobot(int maximumSize) {
        packageValidator = new PackageValidator(maximumSize);
    }

    public static void main(String[] args) {
        DumbRobot robot = new DumbRobot(10);
        robot.pack(Arrays.asList(9, 8));
    }

    @Override
    public List<Integer> pack(List<Integer> articles) {
        List<Integer> packed = new ArrayList<>();
        int cursor = 0;
        int sum = 0;
        int pack = 0;
        final int size = articles.size();
        while (cursor < size) {
            int currentArticle = articles.get(cursor);
            sum += currentArticle;
            if (sum <= packageValidator.getMaximumSize()) {
                pack *= 10;
                pack += currentArticle;
            } else {
                packed.add(pack);
                pack = currentArticle;
                sum = currentArticle;
            }
            cursor++;
        }
        if (pack > 0) {
            packed.add(pack);
        }
        return packed;
    }
}
