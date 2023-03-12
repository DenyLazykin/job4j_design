package ru.job4j.generics.exercises;

import java.util.*;

public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Test test = new Test();
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        List<Test2> lT3 = New.list();
        lT3.add(new Test2());
        Map<Test, List<? extends Test1>> mapTT1 = New.map();
        mapTT1.put(test, lT3);
        LinkedList<Test1> lLT1 = New.lList();
        lLT1.add(new Test1());
        Set<Test> sT = New.set();
        sT.add(new Test());
        Queue<Test1> qT1 = New.queue();
        qT1.add(new Test1());
        System.out.println(lT3);
        System.out.println(mapTT1);
        System.out.println(sT);
        System.out.println(qT1);
        System.out.println(lLT1);
    }
}

class Test {
    @Override
    public String toString() {
        return "Test";
    }
}

class Test1 {
    @Override
    public String toString() {
        return "Test1";
    }
}

class Test2 extends Test1 {
    @Override
    public String toString() {
        return "Test2";
    }
}