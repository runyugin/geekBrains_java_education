package ru.gb.krasnoperov.homework6;

public class Dog extends Animals{

    protected static int dog_count = 0;

    public Dog(String name) {
        super(name);
        count++;
        dog_count++;
    }

    @Override
    public void swim(int length) {
        if (length<=10) {
            System.out.println(getName() + " проплыл " + length + " м.");
        } else {
            System.out.println(getName() + " утонул, он мог проплыть не более 10 м.");
        }
    }

    @Override
    public void run(int length) {
        if (length<=500) {
            System.out.println(getName() + " пробежал " + length + " м.");
        } else {
            System.out.println(getName() + " сдох, он мог пробежать не более 500 м.");
        }
    }
}
