package com.academy.telesens.lesson15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArrayDemo {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("one");
        strList.add("two");
        strList.add("three");

        String[] strArray = strList.toArray(new String[0]);
        String[] strArray2 = strList.toArray(n -> new String[n]);
        String[] strArray3 = strList.toArray(String[]::new);
        System.out.println(Arrays.toString(strArray));
        System.out.println(Arrays.toString(strArray2));
        System.out.println(Arrays.toString(strArray3));

    }
}
