package com.academy.telesens.lesson10.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("hello");
        list.add("string");

//        for (int i = 0; i < 100; i++)
//            list.add("others");

        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.contains("two"));

        list.remove(2);
        list.remove("hello");

        List<Integer> listInt = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 2, 10, 4, 3)
        );

        System.out.println(listInt);
        listInt.remove((Integer) 1);
        System.out.println(listInt);

        List<String> list2 = new ArrayList();
        list2.add("Peter");
        list2.add("Helen");
        list2.add("Ann");
        System.out.println(list2);
        list2.addAll(list);

        System.out.println(list2);
        for(int i=0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        // Сортировка
        list2.sort(String::compareTo);
        System.out.println(list2);

        System.out.println(listInt);
        listInt.sort((n1, n2)-> n1.compareTo(n2)); // 1 способ
        listInt.sort(Integer::compareTo); // 2 способ
        System.out.println(listInt);

        List<String> names = new ArrayList(Arrays.asList("Helen", "Olga"));
        names.sort(String::compareTo);
        System.out.println(names);
    }
}
