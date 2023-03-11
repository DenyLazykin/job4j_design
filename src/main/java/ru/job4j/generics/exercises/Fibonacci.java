package ru.job4j.generics.exercises;

import java.util.Iterator;

public class Fibonacci implements Generator<Integer>, Iterable<Integer> {
    private int count = 0;
    private int m;

    public Fibonacci() {
    }

    public Fibonacci(int m) {
        this.m = m;
    }

    public Integer next() {
        return fib(count++);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return m > 0;
            }

            @Override
            public Integer next() {
                m--;
                return Fibonacci.this.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.println(gen.next() + " ");
        }
        System.out.println();
        for (Integer integer : new Fibonacci(20)) {
            System.out.println(integer + " ");
        }
    }
}
