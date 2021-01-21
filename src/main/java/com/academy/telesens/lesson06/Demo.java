package com.academy.telesens.lesson06;

import com.academy.telesens.lesson06.inheritance.Operator;
import com.academy.telesens.lesson06.inheritance.Subscriber;

import static com.academy.telesens.lesson07.enumeration.Gender.MALE;

public class Demo {
    public static void main(String[] args) {
        System.out.println(
                String.format("%02d.%02d.%d", 22, 3, 2020)
        );

        Operator operator = new Operator("Vodafone", "Kiev");
        Subscriber subscriber = new Subscriber("Иван", "Иванов", 25, MALE, "0661234567", operator);
//        subscriber.setFirstName("Петя");
        String profile = subscriber.getProfile();
        System.out.println(profile);
//        System.out.println(subscriber.getPhoneNumber());
//        System.out.println(subscriber.getOperator().getName());

        Subscriber subscriber2 = new Subscriber();
        subscriber2.setFirstName("Елена");
        subscriber2.setLastName("Петрова");

        // Инициализация через with
        Subscriber subscriber3 = new Subscriber()
                .withFirstName("Peter")
                .withLastName("Sidorov")
                .withAge(32);

        System.out.println("****");
        System.out.println(subscriber);
        System.out.println(subscriber.toString());

        System.out.println("******");
        Operator operatorLife = new Operator("Life", "Kiev");
        Operator operatorLife2 = new Operator("Life", "Kiev");
        Operator operatorLife3 = operatorLife2;
        System.out.println(operator == operatorLife); // сравнения ссылок на объекты
        System.out.println(operator.equals(operatorLife)); // сравнения ссылок на объекты
        System.out.println(operatorLife2.equals(operatorLife)); // для сравнения объектов - метод equals
        System.out.println(operatorLife2.equals(operatorLife3));
    }
}
