package ru.gb.krasnoperov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Hm2Test {

    @Test
    void checkOneAndFour1() {

        Hm2 hm2 = new Hm2(new Integer[]{1,2,4,4,2,3,4,1,7});

        Assertions.assertEquals(true,Hm2.checkOneAndFour(hm2.arr));
    }


    @Test
    void checkOneAndFour2() {

        Hm2 hm2 = new Hm2(new Integer[]{-1,2,-4,-4,2,3,-4,-1,7});

        Assertions.assertEquals(false,Hm2.checkOneAndFour(hm2.arr));
    }
    @Test
    void checkOneAndFour3() {

        Hm2 hm2 = new Hm2(new Integer[]{2,5,1,7});

        Assertions.assertEquals(true,Hm2.checkOneAndFour(hm2.arr));
    }


    @Test
    void checkOneAndFour4() {

        Hm2 hm2 = new Hm2(new Integer[]{-1,2,4});

        Assertions.assertEquals(true,Hm2.checkOneAndFour(hm2.arr));
    }
}