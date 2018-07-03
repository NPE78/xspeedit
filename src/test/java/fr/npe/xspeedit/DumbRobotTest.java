package fr.npe.xspeedit;

import fr.npe.xspeedit.domain.model.Pack;
import fr.npe.xspeedit.domain.robot.DumbRobot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DumbRobotTest {

    @Test
    public void testDumb98() {
        DumbRobot dumbRobot = new DumbRobot(10);

        Assertions.assertThat(dumbRobot.pack(Arrays.asList(9, 8)).stream()
                .map(Pack::toString).collect(Collectors.toList()))
                .containsExactly("9", "8");
    }

    @Test
    public void testDumbFromExample() {
        DumbRobot dumbRobot = new DumbRobot(10);

        Assertions.assertThat(dumbRobot.pack(Arrays.asList(1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3)).stream()
                .map(Pack::toString).collect(Collectors.toList()))
                .containsExactly("163", "8", "41", "6", "8", "9", "52", "5", "7", "73");
    }
}
