package fr.npe.xspeedit.domain.robot;

import fr.npe.xspeedit.domain.model.Pack;

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
        Pack pack = new Pack(maximumSize);
        for (int currentArticle: articles) {
            if (pack.canAdd(currentArticle)) {
                pack.add(currentArticle);
            } else {
                packed.add(pack);
                pack = Pack.create(maximumSize, currentArticle);
            }
        }
        if (pack.getPackageSize() > 0) {
            packed.add(pack);
        }
        return packed;
    }
}
