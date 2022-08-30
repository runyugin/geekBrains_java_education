package ru.gb.krasnoperov;

import java.util.Arrays;

public class Hm2 {

    Integer[] arr;

    public Hm2(Integer[] arr) {
        this.arr = arr;
    }

    public static boolean checkOneAndFour(Integer[] arr) {

        return Arrays.asList(arr).contains(1) || Arrays.asList(arr).contains(4);

    }
}
