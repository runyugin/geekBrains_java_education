package ru.gb.krasnoperov.homework6;

public abstract class Animals {

    private String name;
    public static int count = 0;

    public Animals(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void swim(int length) {

    }

    public abstract void run(int length);
}
