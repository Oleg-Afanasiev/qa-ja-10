package com.academy.telesens.lesson07.enumeration;

import org.openqa.selenium.InvalidArgumentException;

public enum Gender {
    MALE("мужч"), // 0
    FEMALE("женщ"); // 1

    private String ru;

    Gender(String ru) {
        this.ru = ru;
    }

    public String getRu() {
        return ru;
    }

    public void saySomething() {
        if (this == MALE)
            System.out.println("Я мужик");
        else
            System.out.println("Я за мужика");
    }

    public static Gender parse(String g) {
        if (g.equals("m"))
            return MALE;

        if (g.equals("f"))
            return FEMALE;

        throw new InvalidArgumentException("Unknown gender value " + g);
    }

    public String toValue() {
        if (this == MALE)
            return "m";

        if (this == FEMALE)
            return "f";

        return null;
    }
}
