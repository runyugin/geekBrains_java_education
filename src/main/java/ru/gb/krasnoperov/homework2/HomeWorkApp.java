package ru.gb.krasnoperov.homework2;


public class HomeWorkApp {

    public static void main(String[] args) {

        System.out.println(chek(5,19));
        System.out.println(chek(4,9));
        chekMinus(5);
        chekMinus(-5);
        System.out.println(chekMinusBoolean(-2));
        System.out.println(chekMinusBoolean(0));
        printText("Text", 5);
        System.out.println(chelYars(2002));

    }

    public static boolean chek(int a, int b){

        boolean result = false;

        if ((a+b)>=10 && (a+b)<=20) {
            result = true;
        }

        return result;
    }


    public static void chekMinus (int a){

        boolean result = false;

        if (a>=0){
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }

    }

    public static boolean chekMinusBoolean (int a){

        boolean result = false;

        if (a<0){
            result = true;
        }

        return result;

    }


    public static void printText(String text, int num){
        for (int i = 0; i < num; i++) {
            System.out.println(text);
        }
    }

    public static boolean chelYars (int yars) {
        boolean result = false;

        if(yars%4 == 0 && yars%100!=0) {
            result=true;
        } else if (yars%4 == 0 && yars%400==0) {
            result=true;
        }

        return result;
    }



}
