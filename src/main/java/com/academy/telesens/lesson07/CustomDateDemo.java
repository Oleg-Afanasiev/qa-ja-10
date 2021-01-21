package com.academy.telesens.lesson07;

public class CustomDateDemo {
    public static void main(String[] args) {
        CustomDateTime time = new CustomDateTime();
        time.setSecond(-1);

        if (time.getSecond() == time.DEFAULT_SECOND) {
            System.out.println("Неверное время");
            return;
        }

        System.out.println("Новое время");
        System.out.println(time);
    }
}
