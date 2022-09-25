package ru.gb.krasnoperov;

import java.lang.reflect.InvocationTargetException;

import static ru.gb.krasnoperov.TestExecutor.start;

public class Main {


    public static void main(String[] args) {
        try {
            start(new TestClass());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
