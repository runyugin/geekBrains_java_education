package ru.gb.krasnoperov.homework2s1n;

public class Main {
    public static void main(String[] args) {

        Move[] arrayMmbers = {
                new Cat("Barsik", 100, 3),
                new Cat("Mursik", 90,4),
                new Human("Ivan",150,2),
                new Robot("T1000", 1000,5)
        };

        Object[] arrayDistance = {
                new TreadMill(30),
                new Wall(1),
                new TreadMill(50),
                new Wall(2),
                new TreadMill(120),
                new Wall(4),
                new TreadMill(500)
        };

        for (int i = 0; i < arrayMmbers.length; i++) {

            System.out.println("Участник " + arrayMmbers[i] + " начал прохождение дистанци");

            for (int j = 0; j < arrayDistance.length; j++) {

                if(arrayDistance[j] instanceof TreadMill) {
                    if(arrayMmbers[i].run(((TreadMill) arrayDistance[j]).getLength())){
                        System.out.println("Пробежал дистанцию: " + ((TreadMill)arrayDistance[j]).getLength() + " м");
                    } else {
                        System.out.println("Сошел с дистанции");
                        break;
                    }
                }

                if(arrayDistance[j] instanceof Wall) {
                    if(arrayMmbers[i].jamp(((Wall) arrayDistance[j]).getHeight())){
                        System.out.println("Прыгнул через стену: " + ((Wall)arrayDistance[j]).getHeight() + " м");
                    } else {
                        System.out.println("Сошел с дистанции");
                        break;
                    }
                }

            }

        }

    }
}
