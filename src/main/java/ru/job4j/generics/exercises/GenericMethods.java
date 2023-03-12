package ru.job4j.generics.exercises;

public class GenericMethods {
    public <T, U> void f(T x, U y, Double d) {
        System.out.println(x.getClass().getName() + " " + y.getClass().getName() + " " + d.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f(1, "hello", 3.15D);
    }
}
