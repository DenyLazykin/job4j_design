package ru.job4j.generics.exercises;

public class GenericMethods {
    public <T, U, R> void f(T x, U y, R z) {
        System.out.println(x.getClass().getName() + " " + y.getClass().getName() + " " + z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f(1, "hello", 3.15D);
    }
}
