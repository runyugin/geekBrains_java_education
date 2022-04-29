package ru.gb.krasnoperov.homework6;

public class Main {

    public static void main(String[] args) {

        Dog dogBobik = new Dog("Бобик");
        Cat catMursik = new Cat("Мурзик");

        System.out.println("Было создано животных = " + Animals.count);

        dogBobik.run(1500);
        catMursik.run(500);

        dogBobik.swim(100);
        catMursik.swim(10);


    }
}
