package com.academy.telesens.lesson07;

import com.academy.telesens.lesson05.oop.Person;
import com.academy.telesens.lesson06.inheritance.Operator;
import com.academy.telesens.lesson06.inheritance.Subscriber;

import java.util.Arrays;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Long l1 = 23L;
        Integer i1 = 23;
        CustomDateTime time = new CustomDateTime();
        time.setSecond(45);

        l1 = i1.longValue();
        i1 = l1.intValue();

        Object[] arr = {1, "Two", 3, time};
        System.out.println(Arrays.toString(arr));

        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName("Peter");

        Operator operator = new Operator();
        operator.setName("Life");
//        subscriber.setOperator(operator);
//        subscriber.setPhoneNumber("999");
        System.out.println(subscriber.getProfile());

        System.out.println("****");
        Person person = new Person();
        person = subscriber; // person должен быть родителем
        // subscriber = person; так нельзя
        System.out.println(person.getProfile());

        Person person2 = new Boxer();
     //   ((Boxer)person).fight();
        Boxer boxer = (Boxer)person2;
        boxer.fight();
//        Boxer boxer = new Person();

        System.out.println("*****");
        Person boxer2 = new Boxer();
        Person musician = new Musician();
//        Person str = "Hello";

        System.out.println(boxer2.getProfile());
        System.out.println(musician.getProfile());

        System.out.println("****");
        Boxer boxer3 = new Boxer();
        Musician musician3 = new Musician();

        Person[] arrPoly = {boxer3, musician3};
        System.out.println(Arrays.toString(arrPoly));
        for (int i=0; i < arrPoly.length; i++) {
            System.out.println(((Person)arrPoly[i]).getProfile());
        }

        System.out.println("****");
        for (int i=0; i < arrPoly.length; i++) {
            if (arrPoly[i] instanceof Musician) // если тек. элемент музыкант
            ((Musician)arrPoly[i]).play();
        }
    }
}
