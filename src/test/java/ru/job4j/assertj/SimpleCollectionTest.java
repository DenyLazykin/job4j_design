package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class SimpleCollectionTest {
    /**
     * Основные операции проверки содержания коллекции:
     * (27) размер.
     * (28) содержит элементы.
     * (29) содержит это в любом порядке, дубликаты не важны.
     * (30) содержит только это и только в указанном порядке.
     * (31) содержит только это в любом порядке.
     * (32) содержит хотя бы один из.
     * (33) не содержит ни одного из.
     * (34) начинается с последовательности.
     * (35) заканчивается на последовательность.
     * (36) содержит последовательность.
     */
    @Test
    void generalAssert() {
        SimpleCollection<Integer> simpleCollection = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(simpleCollection).isNotEmpty()
                .hasSize(5)
                .contains(1, 5, 4)
                .containsOnly(1, 5, 4, 3)
                .containsExactly(1, 1, 3, 4, 5)
                .containsExactlyInAnyOrder(5, 1, 3, 4, 1)
                .containsAnyOf(200, 100, 3)
                .doesNotContain(0, 6)
                .startsWith(1, 1)
                .endsWith(4, 5)
                .containsSequence(1, 3, 4);
    }

    /**
     * Как можно проверить выполнение элементами коллекции нужных условий:
     * (48) все элементы выполняют условие.
     * (52) хотя бы один элемент выполняет условие.
     */
    @Test
    void satisfyAssert() {
        SimpleCollection<Integer> simpleCollection = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(simpleCollection).isNotNull()
                .allSatisfy(e -> {
                    assertThat(e).isLessThan(10);
                    assertThat(e).isGreaterThan(0);
                })
                .anySatisfy(e -> {
                    assertThat(e).isLessThan(5);
                    assertThat(e).isEqualTo(3);
                })
                .allMatch(e -> e < 10)
                .anyMatch(e -> e == 5)
                .noneMatch(e -> e < 1);
    }

    /**
     * Можно выбрать один элемент из коллекции и дальше проверять только его:
     * (70 первый элемент.
     * (72) элемент по индексу.
     * (75) последний элемент.
     */
    @Test
    void checkNavigationList() {
        SimpleCollection<Integer> simpleCollection = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(simpleCollection).first()
                .isEqualTo(1);
        assertThat(simpleCollection).element(2)
                .isNotNull()
                .isEqualTo(3);
        assertThat(simpleCollection).last()
                .isNotNull()
                .isEqualTo(5);
    }

    /**
     * Можно выбрать из коллекции группу элементов по некоторому условию и дальше работать с отобранной группой:
     * (88) фильтруем источник по предикату и работаем с результатом фильтрации.
     * (91) фильтруем с помощью assertThat() и работаем с результатом фильтрации.
     */
    @Test
    void checkFilteredList() {
        SimpleCollection<Integer> simpleCollection = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(simpleCollection).filteredOn(e -> e > 1)
                .first()
                .isEqualTo(3);
        assertThat(simpleCollection).filteredOnAssertions(e -> assertThat(e).isLessThan(3))
                .hasSize(2)
                .first()
                .isEqualTo(1);
    }

    /**
     * Библиотека AssertJ может работать с коллекциями, реализующими интерфейс java.util.Map:
     * (109) содержит ключи.
     * (110) содержит значения.
     * (111) не содержит ключ.
     * (112) не содержит значение.
     * (113) содержит пару ключ-значение.
     */
    @Test
    void assertMap() {
        Map<Integer, String> map = Map.of(1, "1", 2, "2", 3, "3");
        assertThat(map).hasSize(3)
                .containsKeys(1, 3, 2)
                .containsValues("3", "1", "2")
                .doesNotContainKey(0)
                .doesNotContainValue("0")
                .containsEntry(2, "2");

    }
}