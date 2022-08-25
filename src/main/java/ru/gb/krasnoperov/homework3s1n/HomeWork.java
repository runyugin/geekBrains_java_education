package ru.gb.krasnoperov.homework3s1n;


import java.util.*;

public class HomeWork {

    public static void main(String[] args) {


        System.out.println("Задание 1:\n");

        List<Integer> arrayI = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        swap(arrayI, 2,6);


        List<String> arrayS = Arrays.asList(new String[]{"a", "b", "c", "d", "e", "f", "g"});
        swap(arrayS, 2,6);


        System.out.println("\nЗадание 2:\n");

        Integer[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> arrayListInt = arrToArraylist(arrInt);

        System.out.println(arrayListInt.get(2));


        String[] arrString = {"a", "b", "c", "d", "e", "f", "g"};
        List<String> arrayListString= arrToArraylist(arrString);

        System.out.println(arrayListString.get(2));




        System.out.println("\nЗадание 3:\n");

        Box<Apple> boxApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();

        boxApple.addFruitBox(new Apple());
        boxApple.addFruitBox(new Apple());
        boxApple.addFruitBox(new Apple());
        boxApple.addFruitBox(new Apple());
        boxApple.addFruitBox(new Apple());
        boxApple.addFruitBox(new Apple());


        boxOrange.addFruitBox(new Orange());
        boxOrange.addFruitBox(new Orange());
        boxOrange.addFruitBox(new Orange());
        boxOrange.addFruitBox(new Orange());


        Box<Apple> boxAppleSecond = new Box<>();

        boxAppleSecond.addFruitBox(new Apple());
        boxAppleSecond.addFruitBox(new Apple());
        boxAppleSecond.addFruitBox(new Apple());
        boxAppleSecond.addFruitBox(new GoldenApple());



        boxApple.addBox(boxAppleSecond);

        System.out.println(boxAppleSecond.getBox().size());
        System.out.println(boxApple.getBox().size());


    }


//         * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого
//         * ссылочного типа);
//         * static swap(array1, int firstIndex, int secondIndex) {
//         *     // меняем местами элементы, которые находятся на местах firstIndex и secondIndex
//         * }




    public static <T> void swap(List<T> array, int firstIndex, int secondIndex) {

        T elementFirst = array.get(firstIndex);
        T elementSecond = array.get(secondIndex);

        System.out.println(array);

        array.set(firstIndex,elementSecond);
        array.set(secondIndex,elementFirst);

        System.out.println(array);
    }





//         * 2. Написать метод, который преобразует массив в ArrayList;
//         *



    private static <T> List<T> arrToArraylist(T arr[]) {

        List<T> array = Arrays.asList(arr);

        return array;
    }






//         * 3. Задача:
//         * a. Даны классы abstract Fruit, Apple extends Fruit, Orange extends Fruit;
//         * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
//         * фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//         * c. Для хранения фруктов внутри коробки можно использовать ArrayList;
//         * d. Сделать в классе Box метод getWeight(), который высчитывает вес коробки по содержимому:
//         *          вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//         * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
//         * коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
//         * равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
//         * апельсинами;
//         * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//         * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//         * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
//         * объекты, которые были в первой;
//         * f*. Для усложнения, создать класс GoldenApple extends Apple
//         * g. Не забываем про метод добавления фрукта в коробку.
//         * g*. Метод из g должен принимать varargs: ...




}
