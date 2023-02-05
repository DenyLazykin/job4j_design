package ru.job4j.generics.boundedwc;

public class BoundedWildCard {
    public static void main(String[] args) {
        TwoD[] twoD = {
                new TwoD(0, 0),
                new TwoD(7, 9),
                new TwoD(18, 4),
                new TwoD(-1, -23),

        };
        Cords<TwoD> twoDCords = new Cords<>(twoD);
        System.out.println("Содержимое twoD.");
        showXY(twoDCords);
        System.out.println();
        FourD[] fd = {
                new FourD(1, 2, 3, 4),
                new FourD(6, 8, 14, 8),
                new FourD(22, 9, 4, 9),
                new FourD(3, -2, -23, 17)
        };
        Cords<FourD> fourDCords = new Cords<>(fd);
        System.out.println("Содержимое fourDCords.");
        showXY(fourDCords);
        showXYZ(fourDCords);
        showAll(fourDCords);
    }

    static void showXY(Cords<?> c) {
        System.out.println("координаты X Y:");
        for (int i = 0; i < c.cords.length; i++) {
            System.out.println(c.cords[i].x + " " + c.cords[i].y);
        }
        System.out.println();
    }

    static void showXYZ(Cords<? extends ThreeD> c) {
        System.out.println("координаты X Y Z:");
        for (int i = 0; i < c.cords.length; i++) {
            System.out.println(c.cords[i].x
                    + " " + c.cords[i].y
                    + " " + c.cords[i].z);
        }
        System.out.println();
    }

    static void showAll(Cords<? extends FourD> c) {
        System.out.println("координаты X Y Z T:");
        for (int i = 0; i < c.cords.length; i++) {
            System.out.println(c.cords[i].x
                    + " " + c.cords[i].y
                    + " " + c.cords[i].z
                    + " " + c.cords[i].t);
        }
        System.out.println();
    }
}
