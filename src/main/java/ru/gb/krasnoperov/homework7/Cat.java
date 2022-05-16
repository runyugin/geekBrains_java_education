package ru.gb.krasnoperov.homework7;

public class Cat {

    private String name;
    private int appetite;
    private boolean hungry;

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }


    public void eat(Plate p) {

        p.decreaseFood(appetite);

        if(!p.isFlag()){
            this.setHungry(true);
        } else {
            this.setHungry(false);
        }

        System.out.println("Котик " + name + " поел: " + hungry);
    }

}
