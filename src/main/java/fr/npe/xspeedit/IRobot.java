package fr.npe.xspeedit;

import fr.npe.xspeedit.domain.Pack;

import java.util.List;

public interface IRobot {

    List<Pack> pack(List<Integer> articles);

}
