package ru.job4j.generics.interfacegen;

public class GenInterfaceDemo {
    public static void main(String[] args) {
        Integer[] integers = {3, 6, 2, 8, 6};
        Character[] character = {'b', 'a', 'p', 'w'};
        MyClass<Integer> integerMyClass = new MyClass<>(integers);
        MyClass<Character> characterMyClass = new MyClass<>(character);
        System.out.println("Максимальное значение в массиве integers: " + integerMyClass.max());
        System.out.println("Минимальное значение в массиве integers: " + integerMyClass.min());
        System.out.println("Максимальное значение в массиве character: " + characterMyClass.max());
        System.out.println("Минимальное значение в массиве character: " + characterMyClass.min());
    }
}
