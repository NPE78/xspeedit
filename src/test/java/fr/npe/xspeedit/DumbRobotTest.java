package fr.npe.xspeedit;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class DumbRobotTest {

    @Test
    public void testDumb98() {
        DumbRobot dumbRobot = new DumbRobot(10);

        Assertions.assertThat(dumbRobot.pack(Arrays.asList(9, 8)))
                .containsExactly(9, 8);
    }

    @Test
    public void testDumbFromExample() {
        DumbRobot dumbRobot = new DumbRobot(10);

        Assertions.assertThat(dumbRobot.pack(Arrays.asList(1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3)))
                .containsExactly(163, 8, 41, 6, 8, 9, 52, 5, 7, 73);
    }
}
