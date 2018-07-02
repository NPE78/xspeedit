package fr.npe.xspeedit;

import java.util.Collections;
import java.util.List;

public class OptimizedRobot implements IRobot  {

    private final PackageValidator packageValidator;

    public OptimizedRobot(int maximumSize) {
        packageValidator = new PackageValidator(maximumSize);
    }

    @Override
    public List<Integer> pack(List<Integer> articles) {
        return Collections.emptyList();
    }
}
