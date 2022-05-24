package ru.gb.krasnoperov.homework2s1n;

public class Cat implements Move {

    private String name;
    private int limitRun;
    private int limitJamp;

    public Cat(String name, int limitRun, int limitJamp) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitJamp = limitJamp;
    }

    @Override
    public boolean jamp(int h) {
        return limitJamp>=h;
    }

    @Override
    public boolean run(int l) {
        return limitRun >= l;
    }

    @Override
    public String toString() {
        return "Cat: " + name;
    }
}
