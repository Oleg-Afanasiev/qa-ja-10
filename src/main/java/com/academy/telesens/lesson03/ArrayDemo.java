package com.academy.telesens.lesson03;

import java.util.Arrays;
import java.util.Random;

public class ArrayDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[5];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // записываем в массив случайные значения от 0 до 99
        }

//        numbers[0] = random.nextInt(100);
        System.out.println("Origin array");
        System.out.println(Arrays.toString(numbers));
        for(int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
            System.out.print(" ");
        }
        System.out.println();

        // Вывести массив на консоль в обратном порядке
        System.out.println("Reversed");


        // 2
        double[] doubleNumbers = new double[30];
        doubleNumbers[0] = random.nextDouble(); // от [0.0 до 1.0)
        // * от 0.0 до 10.0
        for(int i = 0; i < doubleNumbers.length; i++) {
            doubleNumbers[i] = 10* random.nextDouble();
        }
        System.out.println(Arrays.toString(doubleNumbers));

        // ** от 10.00 до 100.00
        for(int i = 0; i < doubleNumbers.length; i++) {
            doubleNumbers[i] = 10 + 90* random.nextDouble();
        }
        System.out.println(Arrays.toString(doubleNumbers));
    }
}
