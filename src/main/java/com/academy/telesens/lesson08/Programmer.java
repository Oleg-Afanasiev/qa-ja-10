package com.academy.telesens.lesson08;

import com.academy.telesens.lesson05.oop.Person;

public class Programmer extends Person implements Coder {
    @Override
    public void coding() {
        System.out.println("Programming");
    }

    @Override
    public void engSpeaking() {
        System.out.println("Upper level");
    }
}
