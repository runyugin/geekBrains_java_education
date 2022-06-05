package ru.gb.krasnoperov;

import java.util.HashMap;

public class PhoneBook {

    public static HashMap<Integer, String> hmPhone = new HashMap<>();

    public PhoneBook(int phoneNumber, String name) {
        hmPhone.put(phoneNumber, name);
    }

    public static void add(Integer phone, String name){
        hmPhone.put(phone, name);

    }

    public static void get(String name){

        for (HashMap.Entry<Integer, String> o : hmPhone.entrySet()) {
            if(o.getValue().equals(name)) {
                System.out.println(o.getKey() + ": " + o.getValue());
            }
        }
    }
}
