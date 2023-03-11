package ru.job4j.generics;

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class GenericUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        for (String s : list) {
            System.out.println("Текущий элемент: " + s);
        }
        System.out.println();
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printRsl(l);
        System.out.println();
        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printInfo(per);
        System.out.println();
        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new GenericUsage().printInfo(pro);
        System.out.println();
        List<? super Integer> list1 = new ArrayList<>();
        new GenericUsage().addAll(list1);
        System.out.println();
        GenericsClass<String, String> gen = new GenericsClass<>("First key", "first value");
        System.out.println("Вывод в консоль: " + gen);
        GenericsClass<Integer, String> second = new GenericsClass<>(12345, "Second value");
        System.out.println("Вывод в консоль: " + second);
        System.out.println();
        ArrayList<Float> listOfNumbers = new FloatList();
        Class actual = listOfNumbers.getClass();
        ParameterizedType type = (ParameterizedType) actual.getGenericSuperclass();
        System.out.println(type);
        Class parameter = (Class) type.getActualTypeArguments()[0];
        System.out.println(parameter);
    }

    /**
     * Универсальный метод, который будет выводить в консоль наш список.
     *
     * @param col Список, который будет выведен в консоль.
     */
    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    /**
     * Выводит в консоль все элементы коллекции, которая может содержать объекты Person или объекты класса Programmer.
     *
     * @param col Список, который будет выведен в консоль.
     */
    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    /**
     * Помещает объекты Integer в список и выводит этот список в консоль.
     *
     * @param list Список.
     */
    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println("Текущий элемент: " + o);
        }
    }
}
