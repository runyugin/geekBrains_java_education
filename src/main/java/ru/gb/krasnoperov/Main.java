package ru.gb.krasnoperov;

public class Main {

    public static void main(String[] args) {

        Letter letter = new Letter();


        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                letter.printA();
            }

        }).start();

        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                letter.printB();
            }

        }).start();

        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                letter.printC();
            }

        }).start();



    }

    public static class Letter {

        String a = "A";
        String b = "B";
        String c = "C";

        volatile static int count = 0;

        public synchronized void printA() {

            while (count!=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            count=1;
            System.out.print(a);
            notifyAll();
        }
        public synchronized void printB() {
            while (count!=1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            count=2;
            System.out.print(b);
            notifyAll();
        }
        public synchronized void printC() {
            while (count!=2){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            count=0;
            System.out.print(c);
            notifyAll();
        }


    }

}
