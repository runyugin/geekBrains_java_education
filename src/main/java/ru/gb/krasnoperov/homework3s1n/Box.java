package ru.gb.krasnoperov.homework3s1n;


import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Box<T extends Fruit> {

    private List<T> box;
    private float weightBox;

    public Box() {
        this.box = new ArrayList<>();
    }

    public void setBox(List<T> box) {
        this.box = box;
    }

    public List<T> getBox() {
        return box;
    }

    public void addFruitBox(T fruit) {
        this.box.add(fruit);
        weightBox+= fruit.getWeight();
    }

    public float getWeightBox() {
        return weightBox;
    }

    public boolean compare(Box box){
        return this.getWeightBox()==box.getWeightBox();
    }

    public Box<T> addBox(Box<T> boxAdd) {

        boxAdd.getBox().addAll(this.box);
        this.box.clear();

        return boxAdd;
    }
}
