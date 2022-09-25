package ru.gb.krasnoperov;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestExecutor {

    public static <T> void start(T myclass) throws InvocationTargetException, IllegalAccessException {

        Class myClass = myclass.getClass();

        Method[] meth = myClass.getMethods();

        ArrayList<Method> beforeTest = new ArrayList<>();

        HashMap <Integer, ArrayList<Method>> test = new HashMap<>();
        ArrayList<Method> afterTest = new ArrayList<>();

        for(Method m : meth){
            if(m.isAnnotationPresent(Test.class)){
                Test an = m.getAnnotation(Test.class);

                if(test.containsKey(an.priority())){
                    test.get(an.priority()).add(m);
                }
                else {
                    ArrayList<Method> values = new ArrayList<Method>();
                    values.add(m);
                    test.put(an.priority(), values);
                }
            }
            if(m.isAnnotationPresent(BeforeSuite.class)){
                beforeTest.add(m);
                if(beforeTest.size() > 1){
                    throw new RuntimeException("BeforeSuite more than 1");
                }
            }
            if(m.isAnnotationPresent(AfterSuite.class)){
                afterTest.add(m);
                if(afterTest.size() > 1){
                    throw new RuntimeException("AfterSuite more than 1");
                }
            }
        }
        if(beforeTest.size() != 0 ){
            beforeTest.get(0).invoke(myclass);
        }
        for (int key : test.keySet()) {
            for(Method m : test.get(key)){
                m.invoke(myclass);
            }
        }
        if(afterTest.size() != 0){
            afterTest.get(0).invoke(myclass);
        }
    }
}
