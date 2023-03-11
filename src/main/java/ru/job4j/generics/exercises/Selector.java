package ru.job4j.generics.exercises;

import java.util.ArrayList;
import java.util.List;

interface Selector {
    boolean end();

    Object current();

    void next();
}

class GenericSequence<E> {
    private final List<E> list;
    private final int next = 0;

    public GenericSequence(List<E> list) {
        this.list = list;
    }

    public void add(E e) {
        list.add(e);
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == list.size();
        }

        public Object current() {
            return list.get(i);
        }

        public void next() {
            if (i < list.size()) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        GenericSequence<String> stringGenericSequence = new GenericSequence<>(stringList);
        for (int i = 0; i < 10; i++) {
            stringGenericSequence.add(Integer.toString(i));
            Selector selector = stringGenericSequence.selector();
            while (!selector.end()) {
                System.out.println(selector.current() + " ");
                selector.next();
            }
        }
    }
}
