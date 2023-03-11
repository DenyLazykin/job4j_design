package ru.job4j.generics.exercises;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private final ArrayList<T> storage = new ArrayList<>();
    private final Random random = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> stringRandomList = new RandomList<>();
        for (String s : "The quick brown fox jumped over the lazy brown dog".split(" ")) {
            stringRandomList.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(stringRandomList.select() + " ");
        }
        RandomList<Integer> integerRandomList = new RandomList<>();
        for (int i = 0; i < 11; i++) {
            integerRandomList.add(i);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(integerRandomList.select() + " ");
        }
    }
}
