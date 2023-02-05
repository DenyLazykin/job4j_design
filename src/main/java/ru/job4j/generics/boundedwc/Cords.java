package ru.job4j.generics.boundedwc;

/**
 * Класс хранит массив координатных объектов.
 *
 * @param <T>
 */
public class Cords<T extends TwoD> {
    T[] cords;

    Cords(T[] o) {
        cords = o;
    }
}
