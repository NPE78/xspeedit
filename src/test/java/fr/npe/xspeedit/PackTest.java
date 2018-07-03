package fr.npe.xspeedit;

import fr.npe.xspeedit.domain.model.Pack;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class PackTest {

    @Test
    public void checkSize() {
        int maxSize = 10;

        for (int i = 0; i <= maxSize + 2; i++) {
            Pack pack = Pack.create(maxSize, i);
            Assertions.assertThat(pack.getPackageSize()).isEqualTo(i);
        }
    }

    @Test
    public void checkValidPackageForEachArticle() {
        int maxSize = 10;

        SoftAssertions softly = new SoftAssertions();
        for (int i = 1; i <= maxSize; i++) {
            Pack pack = new Pack(maxSize);
            pack.add(i);
            softly.assertThat(pack.isValidPackage()).isTrue();
        }
        softly.assertAll();
    }

    @Test
    public void checkValidPackages() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(Pack.create(10, 1, 9).isValidPackage()).isTrue();
        softly.assertThat(Pack.create(10, 3, 6, 1).isValidPackage()).isTrue();
        softly.assertThat(Pack.create(10, 1, 1, 1, 1).isValidPackage()).isTrue();
        softly.assertThat(Pack.create(10, 2, 6, 2).isValidPackage()).isTrue();
        softly.assertThat(Pack.create(10, 3, 3, 3).isValidPackage()).isTrue();

        softly.assertAll();
    }

    @Test
    public void checkInvalidPackages() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(Pack.create(10, 2, 9).isValidPackage()).isFalse();
        softly.assertThat(Pack.create(10, 11).isValidPackage()).isFalse();
        softly.assertThat(Pack.create(10, 3, 4, 5).isValidPackage()).isFalse();
        softly.assertThat(Pack.create(10, 2, 6, 3).isValidPackage()).isFalse();
        softly.assertThat(Pack.create(10, 3, 3, 5).isValidPackage()).isFalse();

        softly.assertAll();
    }

    @Test
    public void checkAddToPackage() {
        SoftAssertions softly = new SoftAssertions();

        Pack pack = Pack.create(10, 5);
        softly.assertThat(pack.canAdd(5)).isTrue();
        softly.assertThat(pack.canAdd(1)).isTrue();

        softly.assertThat(pack.canAdd(6)).isFalse();
        softly.assertThat(pack.canAdd(10)).isFalse();

        softly.assertAll();
    }

    @Test
    public void checkToString() {
        Assertions.assertThat(Pack.create(10, 1, 2, 3).toString()).isEqualTo("123");
    }
}
