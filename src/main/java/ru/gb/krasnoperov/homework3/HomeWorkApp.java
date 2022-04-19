package ru.gb.krasnoperov.homework3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeWorkApp {

    public static void main(String[] args) {

//1. Задать целочисленный массив, состоящий из элементов 0 и 1.
// Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;


        System.out.println("Задача 1:");

        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
        }

        System.out.println(Arrays.toString(arr1));

//2. Задать пустой целочисленный массив длиной 100.
// С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;


        System.out.println("Задача 2:");

        int[] arr2 = new int[100];


        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }

        System.out.println(Arrays.toString(arr2));

// 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
// и числа меньшие 6 умножить на 2;


        System.out.println("Задача 3:");

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};


        for (int i = 0; i < arr3.length; i++) {

            if (arr3[i] < 6) {
                arr3[i] = (arr3[i] * 2);
            }

        }
        System.out.println(Arrays.toString(arr3));


//   4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//   и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
//   Определить элементы одной из диагоналей можно по следующему принципу:
//   индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];


        System.out.println("Задача 4:");


        System.out.println("Вариант вывода без массива:");

        int rowl = 11;
        int cols = rowl;

        int[][] arrys = new int[rowl][cols];

        for (int i = 0; i < rowl; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j || i == cols - 1 - j) {
                    System.out.printf("%4d", i);
                    arrys[i][j] = i;
                } else {
                    System.out.printf("%4d", 0);
                }
            }
            System.out.println();
        }


        System.out.println("Вариант вывода из массиве:");

        for (int i = 0; i < rowl; i++) {
            System.out.println();
            for (int j = 0; j < cols; j++) {
                System.out.print(arrys[i][j]);
            }
        }

        System.out.println();


//5. Написать метод, принимающий на вход два аргумента: len и initialValue,
// и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;


        System.out.println("Задача 5:");

        System.out.println(Arrays.toString(returnArray(15, 5)));


//6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

        System.out.println("Задача 6:");

        int[] arrMinMax = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        int min = arrMinMax[0];
        int max = arrMinMax[0];

        for (int i = 0; i < arrMinMax.length; i++) {

            if (arrMinMax[i] < min) {
                min = arrMinMax[i];
            }

            if (arrMinMax[i] > max) {
                max = arrMinMax[i];
            }
        }

        System.out.println("Минимальное значение в массиве = " + min);
        System.out.println("Максимальное значение в массиве = " + max);


//7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
// если в массиве есть место, в котором сумма левой и правой части массива равны.
// **Примеры:
// checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
// checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
// граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.


        System.out.println("Задача 7:");

        int[] arrayBalance = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(arrayBalance));



// 8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
// при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами.
// Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
// При каком n в какую сторону сдвиг можете выбирать сами.

        System.out.println("Задача 8:");


        int[] arraynumb = {3, 5, 6, 1};
        int n = -2;


        System.out.println(Arrays.toString(arrayRewrite(arraynumb, n)));

    }


// Метод к задаче 5

    public static int[] returnArray(int len, int initialValue) {

        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

        return array;
    }


// Метод к задаче 7

    public static boolean checkBalance(int[] arrayBalance) {

        int leftsum = 0;

        boolean chek = false;

        for (int i = 0; i < arrayBalance.length; i++) {
            leftsum += arrayBalance[i];

            int rightsum = 0;
            for (int j = 0; j < arrayBalance.length; j++) {
                if (i < j) {
                    rightsum = rightsum + arrayBalance[j];
                }
            }

            if (leftsum == rightsum) {
                chek = true;
            }

        }

        return chek;
    }


// Метод к задаче 8

    public static int[] arrayRewrite(int[] array, int n){


        int[] arraynumb = array;
        int myNum = Math.abs(n);

        for (int j = 0; j < myNum; j++) {

            if(n<0) {

                int savePosition = arraynumb[0];

                for (int i = 0; i < arraynumb.length - 1; i++) {
                    arraynumb[i] = arraynumb[i + 1];
                }
                arraynumb[arraynumb.length - 1] = savePosition;

            }else{


                int savePosition = arraynumb[arraynumb.length - 1];

                for (int i = arraynumb.length - 1; i > 0; i--) {
                    arraynumb[i] = arraynumb[i-1];
                }
                arraynumb[0] = savePosition;


            }

        }


        return arraynumb;
    }

}
