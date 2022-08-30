package ru.gb.krasnoperov;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1,2,4,4,2,3,4,1,7};
        Integer[] arr2 = new Integer[]{3,7};


        Hm1 hm1 = new Hm1(arr);

        System.out.println(Arrays.asList(Hm1.arrayNew(hm1.arr)));

        Hm2 hm2_1 = new Hm2(arr);
        Hm2 hm2_2 = new Hm2(arr2);

        System.out.println(Hm2.checkOneAndFour(hm2_1.arr));
        System.out.println(Hm2.checkOneAndFour(hm2_2.arr));

    }

}
