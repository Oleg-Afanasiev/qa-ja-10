package com.academy.telesens.lesson08;

import com.academy.telesens.lesson05.oop.Person;

public class Choreographer extends Person implements Dancer {
    @Override
    public void dance() {
        System.out.println("Dancing");
    }
}
