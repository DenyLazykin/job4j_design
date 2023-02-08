package ru.job4j.generics.interfacegen;

/**
 * Обобщенный интерфейс MinMax для определения минимального и максимального значений.
 */
interface MinMax<T extends Comparable<T>> {
    T min();

    T max();
}
