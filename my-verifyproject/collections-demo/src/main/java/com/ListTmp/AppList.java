package com.ListTmp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AppList {


    public static void main(String[] args) {
        List<String> arrayList = new ArrayList();
        List<String> linkedList = new LinkedList<>();


        /*List<String> arrayList = new ArrayList();
        arrayList.add("aaaa");
//        arrayList.add(100);

        for (int i = 0; i < arrayList.size(); i++) {
            String item = (String) arrayList.get(i);
            System.out.println("泛型测试item = " + item);
        }

        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();


        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println("泛型测试类型相同");
            System.out.println(classStringArrayList.getName());
            System.out.println(classIntegerArrayList.getName());
        }*/

        new AppList().printMsg(1, 2, 4, 5);
    }

    public <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }
}
