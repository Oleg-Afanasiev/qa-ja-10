package com.academy.telesens.lesson04;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {
        System.out.println("a" + " " + "b");
        System.out.println('a' + " " + 'b');

        System.out.println("*****Пример 1****");
        String hello = "Hello World!!!";
        System.out.println(hello.length());
        System.out.println(hello.charAt(2)); // третий символ
        String world = hello.substring(6); // подстрока начиная с символа 7
        System.out.println(world);
        String onlyWorld = hello.substring(6, 11);
        System.out.println(onlyWorld); // подстрока начиная с 7 по 11 символ

        System.out.println("*****Пример 2****");
        String item = "id24_12349_vtr_234";
        int firstIndex = item.indexOf("_");
        int lastIndex = item.indexOf("_", 5);
        System.out.println(firstIndex);
        System.out.println(lastIndex);
        String numberPart = item.substring(firstIndex + 1, lastIndex);
        System.out.println(numberPart);
        int index = "123dfbas".indexOf("_");
        System.out.println(index);

        System.out.println("****Сравнение строк****");
        String str1 = new String("hello");
        String str2 = "he" + "llo";
        String str3 = "hello world";

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str1 == str2); // так сравнивать строки нельзя
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));

        System.out.println("****Замена подстроки****");
        String msg = "   Hello, Helen!!!   ";
        String changedMsg = msg.replaceAll("!!!", "!");
        System.out.println(msg);
        System.out.println(changedMsg);

        System.out.println(msg.toLowerCase());
        System.out.println(msg.toUpperCase());
        System.out.println("'" + msg + "'");
        System.out.println("'" + msg.trim() + "'"); // убирает пробелы в начале и конце

        String demoString = "One,Two,Three";
        String[] parts = demoString.split(",");
        String tmp = Arrays.toString(parts);
        System.out.println(Arrays.toString(parts));
        String joined = tmp
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(" ", "");
        System.out.println(joined);

    }
}

