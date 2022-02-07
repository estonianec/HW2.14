package com.company;

import com.company.services.StringList;
import com.company.services.impl.StringListImpl;

public class Main {

    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        StringList newStringList = new StringListImpl();

        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.remove(1);
        stringList.add(1, "2");
        stringList.add("5");
        stringList.set(5, "6");
        stringList.remove("6");

        if (newStringList.isEmpty()) {
            System.out.println("isEmpty working");
        }

        newStringList.add("1");
        newStringList.add("2");
        newStringList.add("3");
        newStringList.add("4");
        newStringList.add("5");

        if (stringList.contains("5") && !stringList.contains("12")) {
            System.out.println("contains работает");
        }

        System.out.println("index " + stringList.indexOf("1"));
        System.out.println("index " + stringList.lastIndexOf("1"));

        if (stringList.equals(newStringList)) {
            System.out.println("equals работает");
        }

        System.out.println("Первый StringList");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
        System.out.println("Второй StringList");
        for (int i = 0; i < newStringList.size(); i++) {
            System.out.println(newStringList.get(i));
        }

        stringList.clear();
        if (stringList.isEmpty()) {
            System.out.println("clear working");
        }

        String[] test = newStringList.toArray();
        System.out.println("test");
        for (String s : test) {
            System.out.println(s);
        }

    }
}
