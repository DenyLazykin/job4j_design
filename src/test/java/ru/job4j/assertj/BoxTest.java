package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        assertThat(box.whatThis()).isNotNull()
                .isNotBlank()
                .startsWith("C")
                .endsWith("e")
                .containsIgnoringCase("Cu")
                .isEqualTo("Cube");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        assertThat(box.whatThis()).isNotBlank()
                .startsWithIgnoringCase("t")
                .startsWith("T")
                .doesNotContain("Cube")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(-1, -1);
        assertThat(box.whatThis()).isNotNull()
                .isEqualTo("Unknown object");
    }

    @Test
    void checkSphereVertices() {
        Box box = new Box(0, 10);
        assertThat(box.getNumberOfVertices()).isGreaterThan(-1)
                .isLessThan(1)
                .isEqualTo(0);
    }

    @Test
    void checkTetrahedronVertices() {
        Box box = new Box(4, 10);
        assertThat(box.getNumberOfVertices()).isNotZero()
                .isEven()
                .isPositive()
                .isEqualTo(4);
    }

    @Test
    void checkCubeVertices() {
        Box box = new Box(8, 10);
        assertThat(box.getNumberOfVertices()).isNotZero()
                .isPositive()
                .isGreaterThan(7)
                .isEqualTo(8);
    }

    @Test
    void checkUnknownVertices() {
        Box box = new Box(-4, -10);
        assertThat(box.getNumberOfVertices()).isNotZero()
                .isNegative()
                .isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void isNotExist() {
        Box box = new Box(3, 4);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void isExist() {
        Box box = new Box(8, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkSphereArea() {
        Box box = new Box(0, 10);
        assertThat(box.getArea()).isCloseTo(1256.63d, withPrecision(1.0d))
                .isGreaterThan(1256d)
                .isLessThan(1257d)
                .isEqualTo(1256.63d, withPrecision(0.992d));
    }

    @Test
    void checkTetrahedronArea() {
        Box box = new Box(4, 10);
        assertThat(box.getArea()).isCloseTo(174, withPrecision(1.0d))
                .isLessThan(174)
                .isEqualTo(174, withPrecision(1.0d));
    }

    @Test
    void checkCubeArea() {
        Box box = new Box(8, 10);
        assertThat(box.getArea()).isGreaterThan(599)
                .isEqualTo(600);
    }
}