package ru.gb.krasnoperov.homework2s2n;

public class Main {

    public static void main(String[] args) {

        String[][] arrayStringDub = {
                {"3","3","3","3"},
                {"3","3","8","3"},
                {"3","3","3","3"},
                {"3","3","3","3"}
        };

        try {
            arrayMetod(arrayStringDub);
        } catch (MyArraySizeException e) {
            System.out.println("Заданный массив не соответствует размеру array[4][4]");
        } catch (MyArrayDataException e) {
            System.out.println("Не удалось посчитать сумму массива");
        }

    }


    public static void arrayMetod(String[][] arrayStringDub) throws MyArrayDataException, MyArraySizeException{

        int sum = 0;

        if (arrayStringDub.length!=4||arrayStringDub[0].length!=4||arrayStringDub[1].length!=4||arrayStringDub[2].length!=4||arrayStringDub[3].length!=4) {
                throw new MyArraySizeException();
        }

        for (int i = 0; i < arrayStringDub.length; i++) {
            for (int j = 0; j < arrayStringDub[i].length; j++) {

                int num;

                try {
                    num = Integer.parseInt(arrayStringDub[i][j]);
                } catch (NumberFormatException e){
                    System.out.println("В ячейке arrayStringDub[" + i + "][" + j + "] лежат неверные данные: " + arrayStringDub[i][j]);
                    throw new MyArrayDataException();

                }

                sum+=num;

            }
        }

        System.out.println(sum);

    }
}
