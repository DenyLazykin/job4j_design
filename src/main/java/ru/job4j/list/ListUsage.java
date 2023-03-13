package ru.job4j.list;

import java.util.*;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        rsl.add(0, "four");
        for (String s : rsl) {
            System.out.println("Current element: " + s);
        }
        System.out.println();
        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");
        rsl.addAll(2, list);
        for (String s : rsl) {
            System.out.println("Current element: " + s);
        }
        System.out.println();
        List<String> result = List.of("one", "two", "three");
        for (String s : result) {
            System.out.println("Current element: " + s);
        }
        System.out.println();
        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("Current element: " + rsl.get(i));
        }
        System.out.println();
        Iterator<String> iterator = rsl.iterator();
        while (iterator.hasNext()) {
            System.out.println("Current element: " + iterator.next());
        }
        System.out.println();
        ListIterator<String> listIterator = rsl.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Current element: " + listIterator.next());
        }
        System.out.println();
        ListIterator<String> listIteratorIndex = rsl.listIterator(2);
        while (listIteratorIndex.hasNext()) {
            System.out.println("Current element: " + listIteratorIndex.next());
        }
        System.out.println();
        rsl.set(1, "two and second");
        for (String s : rsl) {
            System.out.println("Current element: " + s);
        }
        rsl.removeIf(s -> s.length() <= 3);
        for (String s : rsl) {
            System.out.println("Current element: " + s);
        }
        System.out.println();
        rsl.replaceAll(String::toUpperCase);
        for (String s : rsl) {
            System.out.println("Current element: " + s);
        }
        System.out.println();
        rsl.remove(0);
        rsl.remove("TWO AND SECOND");
        for (String s : rsl) {
            System.out.println("Current element: " + s);
        }
        System.out.println();
        rsl.retainAll(list);
        for (String s : list) {
            System.out.println("Current element: " + s);
        }
        System.out.println();
        boolean b = list.contains("one");
        System.out.println("Список содержит элемент: " + b);
        int i = list.indexOf("one");
        System.out.println("Индекс элемента в списке: " + i);
        rsl.add("four");
        int i1 = rsl.lastIndexOf("four");
        System.out.println("Индекс элемента в списке: " + i1);
        List<Integer> integerList = List.of(1, 2, 3);
        int size = integerList.size();
        System.out.println("Размер списка равен: " + size);
        List<String> list1 = rsl.subList(0, 1);
        for (String s : list1) {
            System.out.println("Текущий элемент: " + s);
        }
        list.sort(Comparator.naturalOrder());
        for (String s : list) {
            System.out.println("Current element: " + s);
        }
    }
}
