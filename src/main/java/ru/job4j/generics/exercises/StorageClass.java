package ru.job4j.generics.exercises;

class Robot {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Robot(name=%s)",
                this.name);
    }
}

public class StorageClass<T> {
    private T first;
    private T second;
    private T third;

    public StorageClass(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T getThird() {
        return third;
    }

    public void setThird(T third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return String.format("StorageClass(first=%s , second=%s , third=%s)",
                this.first,
                this.second,
                this.third);
    }

    public static void main(String[] args) {
        Robot one = new Robot("bot1");
        Robot two = new Robot("bot2");
        Robot three = new Robot("bot3");
        StorageClass<Robot> storageClass = new StorageClass<>(one, three, two);
        System.out.println("storageClass: " + storageClass);
    }
}
