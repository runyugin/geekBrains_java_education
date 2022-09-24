package ru.gb.krasnoperov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Hm1Test {

    @Test
    void arrayNew1() {
        Integer[] arrObr = new Integer[]{1,7};
        Hm1 hm1 = new Hm1(new Integer[]{1,2,4,4,2,3,4,1,7});

        Assertions.assertArrayEquals(arrObr,Hm1.arrayNew(hm1.arr));
    }


    @Test
    void arrayNew2() {
        int lengthObr = 2;
        Hm1 hm1 = new Hm1(new Integer[]{1,2,4,4,2,3,4,1,7});

        Assertions.assertEquals(lengthObr,Hm1.arrayNew(hm1.arr).length);
    }


    @Test
    void arrayNew3() {
        int numObr = 4;

        Assertions.assertEquals(numObr,Hm1.num);
    }

}