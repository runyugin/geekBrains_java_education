package ru.gb.krasnoperov;

import java.util.Arrays;

public class Hm1 {

    Integer[] arr;
    final static int num = 4;

    public Hm1(Integer[] arr) {
        this.arr = arr;
    }


    public static Integer[] arrayNew(Integer[] arr) {

        if (arr == null) {
            throw new RuntimeException();
        }

        if (arr.length == 0) {
            throw new RuntimeException();
        }

        if (!Arrays.asList(arr).contains(4)) {
            throw new RuntimeException();
        }


        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            if(arr[arr.length-i-1]==num){
                index = i;
                break;
            }
        }

        Integer[] result = new Integer[index];

        for (int i = 0; i < index; i++) {
            result[i] = arr[arr.length-index+i];
        }

        return result;
    }

}
