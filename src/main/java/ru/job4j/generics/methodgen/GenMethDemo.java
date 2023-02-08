package ru.job4j.generics.methodgen;

/**
 * Демонстрация работы обощенного метода IsIn().
 */
public class GenMethDemo {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        if (isIn(2, nums)) {
            System.out.println("Число 2 содержится в массиве nums");
        }
        if (!isIn(7, nums)) {
            System.out.println("Число 7 отсутствует в массиве nums");
        }
        System.out.println();
        String[] strings = {"один", "два", "три", "четыре", "пять"};
        if (isIn("два", strings)) {
            System.out.println("два содержится в массиве strings");
        }
        if (!isIn("семь", strings)) {
            System.out.println("семь отсутствует в массиве strings");
        }
    }

    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (V v : y) {
            if (x.equals(v)) {
                return true;
            }
        }
        return false;
    }
}
