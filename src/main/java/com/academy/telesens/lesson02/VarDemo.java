package com.academy.telesens.lesson02;

public class VarDemo {
    public static void main(String[] args) {
        String str = "Привет мир";
        System.out.println(str);

        int number = 1234;
        System.out.println(number);
        number = Integer.parseInt("123");
        number = Integer.parseInt("123");

        System.out.println(number);

        int maxValue = Integer.MAX_VALUE;
        long maxValue2 = (long)maxValue + 2;
        System.out.println(maxValue);
        System.out.println(maxValue2);

        double d = 1234.345;
        System.out.println(d);

        // char
        char symbol = 'a';
        char symbol2 = 72; // на практике так не нужно
        System.out.println(symbol);
        System.out.println(symbol2);

        long bigValue = 2147483649L;
        System.out.println(bigValue);

        boolean logic = true;
        System.out.println(logic);

        int phoneNumber = 072341; // ноль в начале - восьмиричное представление числа
        System.out.println(phoneNumber);

        // Приведение типов
        int intValue = 1234;
        long longValue = intValue; // приведение типа из int в long
        System.out.println(longValue);

        long longValue2 = 123434534534534L;
        int intValue2 = (int)longValue2; // приведение типа из int в long
        System.out.println(intValue2);

        var str2 = "msg"; // String
        var number2 = 123; // int
        // number2 = str2;

        final int z = 10; // final запрещает изменение значения переменной
        char s = z;
        int Z;

    }
}
