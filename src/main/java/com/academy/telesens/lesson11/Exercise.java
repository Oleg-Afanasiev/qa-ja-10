package com.academy.telesens.lesson11;

import com.academy.telesens.lesson05.oop.Person;
import com.academy.telesens.lesson07.enumeration.Gender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        Person p1 = new Person("Ivan", "Ivanov", 20, Gender.MALE);
        Person p2 = new Person("Peter", "Sidorov", 45, Gender.MALE);
        Person p6 = new Person("Miha", "Sidorov", 36, Gender.MALE);
        Person p3 = new Person("Kolya", "Goryanov", 18, Gender.MALE);
        Person p4 = new Person("Helen", "Petrovna", 35, Gender.FEMALE);
        Person p5 = new Person("Liza", "Milovich", 28, Gender.MALE);

        List<Person> group = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));
        group.sort(Comparator.comparing(Person::getFirstName));
        group.sort((o1, o2)-> o1.getFirstName().compareTo(o2.getFirstName()));

        group.sort((o1, o2) -> {
            if (o1.getLastName().equals(o2.getLastName())) {
                // Фамилии одинаковые => сравниваем имена
                return o1.getFirstName().compareTo(o2.getFirstName());
            } else {
                // Фамилии разные
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        for (int i = 0; i < group.size(); i++)
            System.out.println(group.get(i));
    }
}
