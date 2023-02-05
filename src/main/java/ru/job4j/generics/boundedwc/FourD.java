package ru.job4j.generics.boundedwc;

public class FourD extends ThreeD {
    int t;

    public FourD(int a, int b, int c, int d) {
        super(a, b, c);
        this.t = d;
    }
}
