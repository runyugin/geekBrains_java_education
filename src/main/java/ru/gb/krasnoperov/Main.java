package ru.gb.krasnoperov;


public class Main extends Thread {

    public static void main(String[] args) throws InterruptedException {


        addArray();

        addArray2Thread();
    }




    public static void addArray(){

        int size = 10_000_000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long b = System.currentTimeMillis();

        System.out.println("На изменения значений в ячейках в массиве ушло: " + (b-a) + " мс.");
    }


    public static void addArray2Thread() throws InterruptedException {

        int size = 10_000_000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }


        long a = System.currentTimeMillis();

        float[] leftHalf = new float[arr.length/2];
        float[] rightHalf = new float[arr.length- leftHalf.length];

        System.arraycopy(arr, 0, leftHalf, 0, leftHalf.length);
        System.arraycopy(arr, leftHalf.length, rightHalf, 0, rightHalf.length);


        Thread thread_1 = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float)(leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread_2 = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float)(rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();

        float[] mergedArray = new float[leftHalf.length+rightHalf.length];
        System.arraycopy(leftHalf, 0, mergedArray, 0, leftHalf.length);
        System.arraycopy(rightHalf, 0, mergedArray, leftHalf.length, rightHalf.length);

        long b = System.currentTimeMillis();

        System.out.println("Двунпоточное: На изменения значений в ячейках в массиве ушло: " + (b-a) + " мс.");


    }


}
