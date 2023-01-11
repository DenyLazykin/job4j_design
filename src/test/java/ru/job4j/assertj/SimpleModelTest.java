package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimpleModelTest {
    /**
     * Проверяем генерацию исключения, когда метод класса не принимает аргументы.
     */
    @Test
    void checkGetName() {
        SimpleModel simpleModel = new SimpleModel();
        assertThatThrownBy(simpleModel::getName)
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверяем генерацию исключения, когда метод класса принимает аргументы.
     */
    @Test
    void checkName() {
        SimpleModel simpleModel = new SimpleModel();
        assertThatThrownBy(() -> simpleModel.setName("name", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Проверяем генерацию исключения на наличие сообщения, сопровождающее исключение.
     * (39) Проверяем класс исключения.
     * (40) Проверяем факт наличия сообщения.
     */
    @Test
    void checkMessage() {
        SimpleModel simpleModel = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> simpleModel.setName(word, number))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    /**
     * Проверяем содержание текстового информационного сообщения, сопровождающее исключение.
     * (57) Проверяем класс исключения.
     * (58) С помощью регулярного выражения проверяем факт наличия сообщения.
     * (59) Проверяем, что в сообщении есть соответствующие параметры.
     * (60) Проверяем наличие конкретного слова в сообщении.
     */
    @Test
    void checkWordMessage() {
        SimpleModel simpleModel = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> simpleModel.setName(word, number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word, number)
                .hasMessageContaining("name");
    }
}