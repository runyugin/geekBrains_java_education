package ru.gb.krasnoperov.tiktaktoe;

import java.util.Random;
import java.util.Scanner;

public class TikTacToe {



    public static char[][] board;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        play();

    }

    public static void play() {

        initMap();

        printMap();

        while (true){

            turnUser();
            printMap();
            if(checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            turnComputer();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");

    }


    public static void initMap() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j]=DOT_EMPTY;
            }
        }
    }

    public static void printMap() {

        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void turnUser() {

        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        board[y][x] = DOT_X;

    }

    public static void turnComputer() {

        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        board[y][x] = DOT_O;


    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (board[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean checkWin(char symb) {

        //по горизонтали

        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(board[i][j]==symb){
                    count++;
                }
            }
            if(count==DOTS_TO_WIN){
                return true;
            }else {
                count = 0;
            }

        }



        //по вертикали

        count = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(board[j][i]==symb){
                    count++;
                }
            }
            if(count==DOTS_TO_WIN){
                return true;
            }else {
                count = 0;
            }

        }

        //по диаганали 1

        count = 0;

        for (int i = 0; i < SIZE; i++) {
                if(board[i][i]==symb){
                    count++;
                }


            if(count==DOTS_TO_WIN){
                return true;
            }

        }

        //по диаганали 2

        count = 0;

        for (int i = 0; i < SIZE; i++) {
            if(board[SIZE - 1 - i][i]==symb){
                count++;
            }


            if(count==DOTS_TO_WIN){
                return true;
            }

        }


        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}
