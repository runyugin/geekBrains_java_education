package ru.gb.krasnoperov;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {

        public static final int CARS_COUNT = 4;
        public static volatile boolean win = false;

    final static int THREADS_COUNT = CARS_COUNT;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS_COUNT+1);
    private static final Semaphore semaphore = new Semaphore(CARS_COUNT/2);
        public static void main(String[] args) {

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

            Race race = new Race(
                    new Road(60),
                    new Tunnel(semaphore),
                    new Road(40)
            );

            Car[] cars = new Car[CARS_COUNT];

            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            }
            for (int i = 0; i < cars.length; i++) {

                int finalI = i;

                new Thread(()->{

                    try {
                        System.out.println(cars[finalI].getName() + " готовится");
                        Thread.sleep(500 + (int) (Math.random() * 800));
                        System.out.println(cars[finalI].getName() + " готов");
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }).start();
            }


            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


            for (int i = 0; i < cars.length; i++) {

                int finalI = i;

                new Thread(()->{


                    for (int j = 0; j < race.getStages().size(); j++) {
                        race.getStages().get(j).go(cars[finalI]);
                    }

                    if(win==false) {
                        win = true;
                        System.out.println(cars[finalI].getName() + " - " + "WIN");
                    }


                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }

                }).start();
            }


            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }


            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");


        }
    }


