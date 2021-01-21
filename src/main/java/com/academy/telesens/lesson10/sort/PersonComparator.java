package com.academy.telesens.lesson10.sort;

import com.academy.telesens.lesson05.oop.Person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getAge() < p2.getAge())
            return -1;

        if (p1.getAge() > p2.getAge())
            return 1;

        return 0;
    }
}
