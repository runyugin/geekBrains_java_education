package ru.gb.krasnoperov.homework6;

public class Cat extends Animals{

    protected static int cat_count = 0;

    public Cat(String name) {
        super(name);
        count++;
        cat_count++;
    }

    @Override
    public void swim(int length) {
        System.out.println(getName() + " утонул, он не умел плавать");
    }

    @Override
    public void run(int length) {
        if (length<=200) {
            System.out.println(getName() + " пробежал " + length + " м.");
        } else {
            System.out.println(getName() + " сдох, он мог пробежать не более 200 м.");
        }
    }
}
