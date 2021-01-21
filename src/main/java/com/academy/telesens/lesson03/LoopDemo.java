package com.academy.telesens.lesson03;

public class LoopDemo {
    public static void main(String[] args) {
        // 1 задание: вывести от 1 до 100 нечетные числа
        for(int i = 1; i < 100; i+=2) {
            System.out.println(i);
        }
        System.out.println("***********");
        // 2 задание
        int n = 10;
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum); // expected 55
    }
}
