package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray(
                "first",
                "second",
                "three",
                "four",
                "five"
        );
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList(
                "first",
                "second",
                "three",
                "four",
                "five"
        );
        assertThat(list).first()
                .isNotNull()
                .isEqualTo("first")
                .isNotEqualTo("second");
        assertThat(list).element(3)
                .isNotNull()
                .isEqualTo("four");
        assertThat(list).last()
                .isEqualTo("five");

    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet(
                "first",
                "second",
                "three",
                "four",
                "five"
        );
        assertThat(set).isNotNull()
                .anySatisfy(e -> {
                    assertThat(e).isEqualTo("first");
                })
                .anyMatch(e -> e.equals("five"))
                .noneMatch(e -> e.equals("six"));
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap(
                "first",
                "second",
                "three",
                "four",
                "five"
        );
        assertThat(map).hasSize(5)
                .containsKeys("three", "four")
                .doesNotContainKey("ten")
                .containsValues(1, 2, 4)
                .containsEntry("five", 4);
    }
}