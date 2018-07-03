package fr.npe.xspeedit;

import fr.npe.xspeedit.domain.Pack;

import java.util.ArrayList;
import java.util.List;

public class DumbRobot implements IRobot {

    private final int maximumSize;

    public DumbRobot(int maximumSize) {
        this.maximumSize = maximumSize;
    }

    @Override
    public List<Pack> pack(List<Integer> articles) {
        List<Pack> packed = new ArrayList<>();
        int cursor = 0;
        Pack pack = new Pack(maximumSize);
        final int size = articles.size();
        while (cursor < size) {
            int currentArticle = articles.get(cursor);
            if (pack.canAdd(currentArticle)) {
                pack.add(currentArticle);
            } else {
                packed.add(pack);
                pack = Pack.create(maximumSize, currentArticle);
            }
            cursor++;
        }
        if (pack.getPackageSize() > 0) {
            packed.add(pack);
        }
        return packed;
    }
}
