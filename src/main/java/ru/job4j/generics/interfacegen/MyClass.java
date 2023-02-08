package ru.job4j.generics.interfacegen;

public class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] value;

    public MyClass(T[] value) {
        this.value = value;
    }

    @Override
    public T min() {
        T v = value[0];
        for (int i = 1; i < value.length; i++) {
            if (value[i].compareTo(v) < 0) {
                v = value[i];
            }
        }
        return v;
    }

    @Override
    public T max() {
        T v = value[0];
        for (int i = 1; i < value.length; i++) {
            if (value[i].compareTo(v) > 0) {
                v = value[i];
            }
        }
        return v;
    }
}
