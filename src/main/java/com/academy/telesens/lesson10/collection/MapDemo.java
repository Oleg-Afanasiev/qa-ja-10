package com.academy.telesens.lesson10.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(10, "ten");
        map.put(5, "five");

        System.out.println(map);

        map.put(1, "other_value");
        System.out.println(map);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.size());

    }
}
