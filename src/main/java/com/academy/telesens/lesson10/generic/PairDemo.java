package com.academy.telesens.lesson10.generic;

import com.academy.telesens.lesson05.oop.Person;

public class PairDemo {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "string");
        int n = pair.getFirst();
        String str = pair.getSecond();

        System.out.println("Pair 1:" + n + "->" + str);

        Pair<String, Integer> pair2 = new Pair<>("String", 10);
//        Object value2 = pair2.getFirst();
//        if (value2 instanceof Integer) {
            int n2 =  pair2.getSecond();
//        }
        Pair<Integer, Integer> pair3 = new Pair<>(5, 10);

        Person person = new Person();
        Pair<Integer, Person> pair4 = new Pair<>(5, person);

        Pair<String, Pair<Integer, Person>> crazyPair = new Pair<>("crazy", pair4);

        print(1, "Hello");
        double result1 =  sum(1, 3);
        double  result2 = sum(1.3, 4);
//        sum(1, "Hello");
        System.out.println(result1);
        System.out.println(result2);

        Pair<Object, Integer> pair5 = new Pair<>("", 12);
//        someMethod(pair);
        someMethod(pair5);
    }

    public static <U, V> void print(U arg1, V arg2) {
        System.out.println("first: " + arg1 + ", second: " + arg2);
    }

    public static <U extends Number, V extends Number> double sum(U arg1, V arg2){
        return arg1.doubleValue() + arg2.doubleValue();
    }

    public static void someMethod(Pair<? super Number, ?> pair){
        Object first = pair.getFirst();
        Object second = pair.getSecond();
        System.out.println(first + ":" + second);
    }
}
