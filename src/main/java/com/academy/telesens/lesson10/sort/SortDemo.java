package com.academy.telesens.lesson10.sort;

import com.academy.telesens.lesson05.oop.Person;
import com.academy.telesens.lesson07.enumeration.Gender;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortDemo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("one");
        list1.add("two");
        list1.add("zero");

        List<String> list2 = new ArrayList<>();
        list2.add("one");
        list2.add("zero");
        list2.add("two");

        list1.sort(String::compareTo);
        list2.sort(String::compareTo);

        System.out.println(list1.equals(list2));

        // Как работает сортировка
        List<Person> people = new ArrayList<>();
        people.add(new Person("Vasya", "Ivanov", 25, Gender.MALE));
        people.add(new Person("Sidor", "Sidorov", 29, Gender.MALE));
        people.add(new Person("Helen", "Petrovna", 27, Gender.FEMALE));

        // int compare(Person p1, Person p2)
        // -1 p1, p2
        // 0 порядок не важен p1, p2 или p2, p1
        // 1 p2, p1

//        people.sort(new PersonComparator());
        System.out.println(people);

        people.sort((p1, p2)-> Integer.compare(p1.getAge(), p2.getAge()));
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println(people);
    }
}
