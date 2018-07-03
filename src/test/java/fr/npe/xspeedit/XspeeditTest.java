package fr.npe.xspeedit;

import fr.npe.xspeedit.domain.model.Pack;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class XspeeditTest {

    @Test
    public void display123() {
        XspeeditMain xspeeditMain = new XspeeditMain();

        Pack pack1 = Pack.create(10, 1);
        Pack pack2 = Pack.create(10, 2);
        Pack pack3 = Pack.create(10, 3);
        Assertions.assertThat(xspeeditMain.concatPacks(Arrays.asList(pack1, pack2, pack3))).isEqualTo("1/2/3");
    }

    @Test
    public void display11() {
        XspeeditMain xspeeditMain = new XspeeditMain();

        Pack pack1 = Pack.create(10, 1);
        Assertions.assertThat(xspeeditMain.concatPacks(Arrays.asList(pack1, pack1))).isEqualTo("1/1");
    }
}
