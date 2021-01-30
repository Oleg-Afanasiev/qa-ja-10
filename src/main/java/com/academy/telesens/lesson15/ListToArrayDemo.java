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

        List<List<String>> list2D = new ArrayList<>();
        List<String> listItem1 = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> listItem2 = new ArrayList<>(Arrays.asList("four", "five", "six"));
        List<String> listItem3 = new ArrayList<>(Arrays.asList("1", "2", "3"));

        list2D.add(listItem1);
        list2D.add(listItem2);
        list2D.add(listItem3);

        Object[][] result1 = new Object[list2D.size()][3];
        Object[][] result2 = new Object[list2D.size()][3];

        // Перебор вложенным циклом
        for (int i=0; i < list2D.size(); i++) {
            for (int j = 0; j < list2D.get(i).size(); j++) {
                result1[i][j] = list2D.get(i).get(j);
            }
        }

        // Перебор только внешнего списка
        for (int i=0; i < list2D.size(); i++) {
            result2[i] = list2D.get(i).toArray(String[]::new);
        }

        // Использование stream API
        String[][] result3 = list2D.stream()
                .map(arr -> arr.toArray(String[]::new)) // List<String>,List<String>,... => String[], String[],...
                .toArray(String[][]::new); // String[], String[], ... => String[][]

        String[][] result4 = listToString(list2D);

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(result3));
        System.out.println(Arrays.deepToString(result4));

        List<String[]> listStr = new ArrayList<>();
        listStr.add(new String[] {"1", "2", "3"});
        listStr.add(new String[] {"11", "22", "33"});
        listStr.add(new String[] {"111", "222", "333"});

        Object[][] result5 = listStr.toArray(String[][]::new);
        System.out.println(Arrays.deepToString(result5));

        Object[] arr = new String[]{"one", "two"}; // correct
    }

    public static String[][] listToString(List<List<String>> list) {
        return list.stream()
                .map(arr -> arr.toArray(String[]::new)) // List<String>,List<String>,... => String[], String[],...
                .toArray(String[][]::new);
    }
}
