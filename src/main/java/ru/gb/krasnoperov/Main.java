package ru.gb.krasnoperov;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 1:\n\n");

        String text = "Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.";

        String text2 = text.replaceAll("\\p{Punct}", "");

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(text2.split(" ")));

        HashMap<String, Integer> hm = new HashMap<>();

        for (String word:arrayList) {

            if (!hm.containsKey(word))
            {
                hm.put(word, 1);
            } else {
                hm.put(word, hm.get(word) + 1);
            }
        }

        for (String word : hm.keySet())
        {
            System.out.println(word + " " + hm.get(word));
        }


        System.out.println("\n\nЗадание 2:\n\n");

        new PhoneBook(999982882,"Ivanov");
        new PhoneBook(9945672,"Petrov");
        new PhoneBook(987644352,"Sidorov");
        new PhoneBook(3432882,"Smirnov");
        new PhoneBook(969393882,"Ivanov");
        new PhoneBook(346542882,"Smirnov");

        PhoneBook.add(886545677, "Ivanov");

        PhoneBook.get("Ivanov");

    }
}
