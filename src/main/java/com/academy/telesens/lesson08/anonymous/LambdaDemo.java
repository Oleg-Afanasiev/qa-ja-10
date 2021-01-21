package com.academy.telesens.lesson08.anonymous;

public class LambdaDemo {
    public static void main(String[] args) {
        IntInterface oper1 = (i1, i2)-> i1 + i2;
        IntInterface oper2 = (i1, i2)-> i1 * i2;

        System.out.println(oper1.calc(3, 5));
        System.out.println(oper2.calc(3, 5));

        StringInterface strOper1 = s->s.toUpperCase();
        StringInterface strOper2 = String::toLowerCase;

        System.out.println(strOper1.oper("Hello"));
        System.out.println(strOper2.oper("Hello"));

        StringConsumer stringConsumer = s -> System.out.println(s);
        StringConsumer stringConsumer2 = System.out::println;
        stringConsumer.consume("Hello World!!!");
        stringConsumer2.consume("Hello World!!!");

    }
}
