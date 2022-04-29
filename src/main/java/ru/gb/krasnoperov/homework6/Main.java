package ru.gb.krasnoperov.homework6;

public class Main {

    public static void main(String[] args) {

        Dog dogBobik = new Dog("Бобик");
        Cat catMursik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");

        System.out.println("Было создано животных = " + Animals.count);
        System.out.println("Было создано котов = " + Cat.cat_count);
        System.out.println("Было создано собак = " + Dog.dog_count);

        dogBobik.run(1500);
        catMursik.run(500);

        dogBobik.swim(100);
        catMursik.swim(10);


    }
}
