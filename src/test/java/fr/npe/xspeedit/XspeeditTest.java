package fr.npe.xspeedit;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class XspeeditTest {

    @Test
    public void display123() {
        XspeeditMain xspeeditMain = new XspeeditMain();

        Assertions.assertThat(xspeeditMain.concatArticles(Arrays.asList(1, 2, 3))).isEqualTo("1/2/3");
    }

    @Test
    public void display11() {
        XspeeditMain xspeeditMain = new XspeeditMain();

        Assertions.assertThat(xspeeditMain.concatArticles(Arrays.asList(1, 1))).isEqualTo("1/1");
    }
}
