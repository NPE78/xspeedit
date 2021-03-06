package fr.npe.xspeedit.domain.robot;

import fr.npe.xspeedit.domain.model.Pack;

import java.util.List;

/**
 * Interface for each robot
 */
public interface IRobot {

    String getDescription();

    List<Pack> pack(List<Integer> articles);

}
