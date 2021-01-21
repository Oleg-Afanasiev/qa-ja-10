package com.academy.telesens.lesson07;

import com.academy.telesens.lesson05.oop.Person;
import com.academy.telesens.lesson08.Fighter;

public class Boxer extends Person implements Fighter {
    public void fight() {
        System.out.println("boxing");
    }

    @Override
    public String getProfile() {
        return "I am a boxer";
    }

    @Override
    public String toString() {
        return super.toString() + "Boxer{}";
    }
}
