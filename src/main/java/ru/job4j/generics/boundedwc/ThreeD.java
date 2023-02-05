package ru.job4j.generics.boundedwc;

public class ThreeD extends TwoD {
    int z;

    public ThreeD(int a, int b, int c) {
        super(a, b);
        this.z = c;
    }
}
