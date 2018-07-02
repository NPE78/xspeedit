package fr.npe.xspeedit;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class XspeeditRulesTest {

    @Test
    public void checkSize() {
        int maxSize = 10;
        PackageValidator rules = new PackageValidator(maxSize);

        for (int i = 0; i <= maxSize + 2; i++) {
            Assertions.assertThat(rules.getPackageSize(Collections.singletonList(i))).isEqualTo(i);
        }
    }

    @Test
    public void testValidPackageForUnitArticles() {
        int maxSize = 10;
        PackageValidator rules = new PackageValidator(maxSize);

        SoftAssertions softly = new SoftAssertions();
        for (int i = 1; i <= maxSize; i++) {
            softly.assertThat(rules.isValidPackage(Collections.singletonList(i))).isTrue();
        }
        softly.assertAll();
    }

    @Test
    public void testValidPackages() {
        PackageValidator rules = new PackageValidator(10);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(rules.isValidPackage(Arrays.asList(1, 9))).isTrue();
        softly.assertThat(rules.isValidPackage(Arrays.asList(3, 6, 1))).isTrue();
        softly.assertThat(rules.isValidPackage(Arrays.asList(1, 1, 1, 1))).isTrue();
        softly.assertThat(rules.isValidPackage(Arrays.asList(2, 6, 2))).isTrue();
        softly.assertThat(rules.isValidPackage(Arrays.asList(3, 3, 3))).isTrue();

        softly.assertAll();
    }

    @Test
    public void testInvalidPackages() {
        PackageValidator rules = new PackageValidator(10);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(rules.isValidPackage(Arrays.asList(2, 9))).isFalse();
        softly.assertThat(rules.isValidPackage(Collections.singletonList(11))).isFalse();
        softly.assertThat(rules.isValidPackage(Arrays.asList(3, 4, 5))).isFalse();
        softly.assertThat(rules.isValidPackage(Arrays.asList(2, 6, 3))).isFalse();
        softly.assertThat(rules.isValidPackage(Arrays.asList(3, 3, 5))).isFalse();

        softly.assertAll();
    }
}
