package com.academy.telesens.lesson01;

import java.util.Scanner;

public class Demo {
    public static void method() {
        System.out.println("***Static method***");
    }

    public void method2() {
        System.out.println("***No static method***");
    }

    public static void main(String[] args) {
        // Вывод на консоль с переносом строки
        System.out.println("Привет Мир!");
        System.out.println("Привет Мир2!");
        System.out.println("Привет Мир3!");

        // Вывод на консоль. Курсор остается на текущей строке
        System.out.print("one");
        System.out.print("two");
        System.out.print("three\n");

        // Форматирование строк 1 способ (устаревший)
        System.out.printf("My name is %s; My address %s%n", "Helen", "Kharkov");

        // Форматирование строк 2 способ (более правильный)
        System.out.println(String.format("My name is %s; My address %s; age: %d",
                "Helen", "Kharkov", 28));

        // Ввод с коносли
        System.out.print("Введите ваше имя: ");
        Scanner scanner = new Scanner(System.in); // настраиваем сканер
        String name = scanner.nextLine(); // считываем имя с консоли
        System.out.print("Введите ваш возраст: ");
        Integer age = scanner.nextInt(); // Вводим целое число
        scanner.nextLine();
        System.out.print("Введите вашу фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println(String.format("Привет %s %d %s!", name, age, lastName)); // выводим приветствие

//        Demo.method();
//        Demo demo = new Demo();
//        demo.method2();
    }
}
