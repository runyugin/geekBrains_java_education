package ru.gb.krasnoperov.mineSweeper;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    public static final int WIDTH = 5;
    public static final int HIGHT = 5;
    public static final int MINES = 4;
    public static final int MINE = 1000;
    public static final int EMPTY = 0;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    private static final int CELL_OPEN = 1;
    private static final int CELL_CLOSDED = 0;
    private static final int CELL_FLAG = -1;

    public static void main(String[] args) {
        boolean userWin = play();
        if(userWin) {
            System.out.println("Win");
        } else {
            System.out.println("Looser");
        }
    }

    public static boolean play() {
        boolean win = true;
        boolean isPasMove;
        int[][] board = generateBoard();
        int[][] moves = new int[HIGHT][WIDTH];


        do {

            isPasMove = move(board, moves);
            win = isWin(moves);
        } while (isPasMove && !win);

        return isPasMove;
    }

    private static boolean isWin(int[][] moves) {

        int openCell = 0;

        for (int i = 0; i < HIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {

                if(moves[i][j] == CELL_OPEN){
                    openCell++;
                }

            }
        }

        return openCell + MINES == HIGHT*WIDTH;
    }

    private static boolean move(int[][] board, int[][] moves) {
        Scanner scanner = new Scanner(System.in);
        printBoard(board,moves);
        int row,line;

        while (true){
            System.out.println("Ваш ход ( столбец, строка например А1): ");
            String move = scanner.nextLine();
            row = move.charAt(0) - 'A';
            line = move.charAt(1) - '0';
            if(row<WIDTH&&row>=0&&line<HIGHT&&line>=0){
            break;
            }
            System.out.println("Введите др. координаты!");
        }

        if (board[line][row]!=MINE){
            moves[line][row]=CELL_OPEN;
            return true;
        }
        return false;
    }

    public static int[][] generateBoard() {

        int[][] board = new int[HIGHT][WIDTH];

        Random random = new Random();
        int mines = MINES;



        while (mines>0){

            int x = random.nextInt(HIGHT);
            int y = random.nextInt(WIDTH);

            if(board[x][y]!=MINE){
                board[x][y]=MINE;
                mines--;
            }

        }

        for (int i = 0; i < HIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {

                if(board[i][j]==MINE){
                    continue;
                }

                int mineCount = 0;

                for (int k = i-1; k <=i+1 ; k++) {
                    for (int l = j-1; l <=j+1 ; l++) {

                        if(k<0 || k>= HIGHT || l<0 || l >= WIDTH) {
                            continue;
                        }


                      if(board[k][l]==MINE){
                          mineCount++;
                      }

                    }
                }

                board[i][j]=mineCount;

            }
        }

        return board;
    }

    public static void printBoard(int[][] board, int[][] moves) {
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + WIDTH; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < HIGHT; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < WIDTH; j++) {

                if(moves[i][j]==CELL_CLOSDED){
                    System.out.print("[]");
                    continue;
                }

                if(moves[i][j]== CELL_FLAG){
                    System.out.print(" P");
                    continue;
                }
                String code = getAnsiColor(board[i][j]);
                System.out.print(code);
                if(board[i][j] == EMPTY) {
                    System.out.print(" .");
                }else if(board[i][j] == MINE) {
                    System.out.print(" *");
                }else{
                    System.out.printf("%2d", board[i][j]);
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }
    }

    public static String getAnsiColor(int i){

        switch (i) {
            case EMPTY:
                return ANSI_WHITE;
            case MINE:
                return ANSI_PURPLE;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
                return ANSI_RED;
            case 4:
                return ANSI_CYAN;
            default:
                return ANSI_YELLOW;
        }


    }


}
