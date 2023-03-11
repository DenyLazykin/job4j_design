package ru.job4j.generics.exercises;

class Amphibian {
}

class Vehicle {
}

public class TupleMain {
    static TwoTuple<String, Integer> twoTuple() {
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> threeTuple() {
        return new ThreeTuple<>(
                new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> fourTuple() {
        return new FourTuple<>(
                new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> fiveTuple() {
        return new FiveTuple<>(
                new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    static SixTuple<Vehicle, Amphibian, String, Integer, Double, Float> sixTuple() {
        return new SixTuple<>(
                new Vehicle(), new Amphibian(), "hi", 47, 3.14D, 2.1F);
    }

    public static void main(String[] args) {
        SixTuple<Vehicle, Amphibian, String, Integer, Double, Float> st = sixTuple();
        System.out.println(st);
        System.out.println(twoTuple());
        System.out.println(threeTuple());
        System.out.println(fourTuple());
        System.out.println(fiveTuple());
        System.out.println(sixTuple());
    }
}
