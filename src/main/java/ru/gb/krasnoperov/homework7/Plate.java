package ru.gb.krasnoperov.homework7;


public class Plate {


    private int food;
    private boolean flag;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Осталось еды в миске: " + food);
    }

    public boolean isFlag() {
        return flag;
    }

    public void decreaseFood(int n) {

        if(food>=n) {
            food -= n;
        } else if (food>0) {
            System.out.println("Еды недостаточно");
            flag = true;
        } else {
            System.out.println("Еда кончилась");
            flag = true;
        }
    }


    public void addFood(int addfood) {
        this.food += addfood;
    }



}
