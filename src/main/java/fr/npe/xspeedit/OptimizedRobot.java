package fr.npe.xspeedit;

import fr.npe.xspeedit.domain.Pack;

import java.util.Collections;
import java.util.List;

public class OptimizedRobot implements IRobot  {

    private final int maximumSize;

    public OptimizedRobot(int maximumSize) {
        this.maximumSize = maximumSize;
    }

    @Override
    public List<Pack> pack(List<Integer> articles) {
        return Collections.emptyList();
    }
}
