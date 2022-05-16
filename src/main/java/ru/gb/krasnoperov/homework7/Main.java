package ru.gb.krasnoperov.homework7;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        Cat[] arrayCat = {
                new Cat("Barsuk", 5),
                new Cat("Mursik", 7),
                new Cat("Kuza", 4),
                new Cat("Foma", 6),
                new Cat("Run", 6),
                new Cat("Bon", 5),
        };

        Plate plate = new Plate(30);

        for (int i = 0; i < arrayCat.length; i++) {

            plate.info();
            arrayCat[i].eat(plate);

        }

        plate.addFood(20);
        plate.info();

    }
}
