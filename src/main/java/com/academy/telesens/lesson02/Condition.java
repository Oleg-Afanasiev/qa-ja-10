package com.academy.telesens.lesson02;

public class Condition {
    public static void main(String[] args) {
        int age = 80;

        if (age < 16) {
            System.out.println("Child");
        } else if (age < 70) {
            System.out.println("Adult");
        } else {
            System.out.println("Old");
        }
    }
}
