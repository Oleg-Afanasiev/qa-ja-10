package com.academy.telesens.lesson07.enumeration;

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
}
