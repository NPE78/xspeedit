package fr.npe.xspeedit;

import fr.npe.xspeedit.domain.robot.SmartRobot;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class SmartRobotTest {

    @Test
    public void testOptimized98() {
        SmartRobot smartRobot = new SmartRobot(10);

        Assertions.assertThat(smartRobot.pack(Arrays.asList(9, 8)).size())
                .isLessThanOrEqualTo(2);
    }

    @Test
    public void testOptimizedFromExample() {
        SmartRobot smartRobot = new SmartRobot(10);

        Assertions.assertThat(smartRobot.pack(Arrays.asList(1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3)).size())
                .isLessThanOrEqualTo(8);
    }

    @Test
    public void testOptimized75322222() {
        SmartRobot smartRobot = new SmartRobot(10);

        Assertions.assertThat(smartRobot.pack(Arrays.asList(7, 5, 3, 2, 2, 2, 2, 2)).size())
                .isLessThanOrEqualTo(3); // 73 22222 & 5    or  73 522 & 222
    }

    @Test
    public void testOptimized74621() {
        SmartRobot smartRobot = new SmartRobot(10);

        Assertions.assertThat(smartRobot.pack(Arrays.asList(7, 4, 6, 2, 1)).size())
                .isLessThanOrEqualTo(2); // 721 & 64
    }
}
