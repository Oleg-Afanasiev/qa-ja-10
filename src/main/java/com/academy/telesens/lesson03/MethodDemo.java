package com.academy.telesens.lesson03;

public class MethodDemo {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 4;
        int sum1 = n1 + n2;
        int sum2 = sum(3, 4);
        System.out.println(sum1);
        System.out.println(sum2);

        // Вызвать метод и вывести 3 аргумента
        System.out.println("*****");
        reverseNumbers(1, 7, 3);
        printProfile("Helen", 25);
    }

    // метод суммы
    public static int sum(int arg1, int arg2) {
        int sum = arg1 + arg2;
        return sum; // Возвращаем результат
    }

    // Метод выводит 3 аргумента
    public static void reverseNumbers(int arg1, int arg2, int arg3) {
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
    }

    public static void printProfile(String name, int age) {
        System.out.println(
                String.format("Name %s, age %d", name, age));
    }
}
