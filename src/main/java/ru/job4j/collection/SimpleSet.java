package ru.job4j.collection;

import java.util.Arrays;
import java.util.Objects;

/**
 * Тренируемся пользоваться дебагером.
 */
public class SimpleSet {
    private String[] container = new String[2];
    private int size;

    /**
     * Для добавления элементов.
     *
     * @param value Значение, которое нужно добавить.
     * @return Добавленное значение в коллекцию.
     */
    public boolean add(String value) {
        if (size == container.length) {
            grow();
        }
        boolean result = !contains(value);
        if (result) {
            container[size++] = value;
        }
        return result;
    }

    /**
     * Проверяет, содержит ли класс такой элемент.
     *
     * @param value Значение, которое нужно проверить.
     * @return false, если указанное в параметрах значение не найдено.
     */
    private boolean contains(String value) {
        boolean result = false;
        for (String element : container) {
            if (Objects.equals(value, element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Увеличивает размер контейнера.
     */
    private void grow() {
        int length = container.length * 2;
        container = new String[length];
    }
}
