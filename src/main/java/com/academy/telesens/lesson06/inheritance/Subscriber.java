package com.academy.telesens.lesson06.inheritance;

import com.academy.telesens.lesson05.oop.Person;
import com.academy.telesens.lesson07.enumeration.Gender;

import java.util.Objects;

public class Subscriber extends Person {
    private int id;
    private String phoneNumber;
    private Operator operator;

    public Subscriber() {
    }

    public Subscriber(
            String firstName,
            String lastName,
            Integer age,
            Gender gender,
            String phoneNumber,
            Operator operator
            ) {
        super(firstName, lastName, age, gender); // Конструктор базового класса - ДОЛЖЕН БЫТЬ ВЫЗВАН ПЕРВЫМ
       // setFirstName(firstName); // 1 способ

        this.phoneNumber = phoneNumber;
        this.operator = operator;
    }

    // set/get

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    // методы with (для красоты)
    public Subscriber withFirstName(String firstName) {
        super.firstName = firstName;
        return this;
    }

    public Subscriber withLastName(String lastName) {
        super.lastName = lastName;
        return this;
    }

    public Subscriber withAge(int age) {
        super.age = age;
        return this;
    }

    @Override
    public String getProfile() {
//        return String.format("First name: %s\n Last name: %s\n Age: %s\n Gender: %s\n PhoneNumber: %s\n Operator: %s\n",
//                firstName, lastName, age, gender, phoneNumber, operator.getName());

        return super.getProfile() + String.format(" PhoneNumber: %s\n Operator: \n",
                phoneNumber);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", operator=" + operator +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriber)) return false;
        if (!super.equals(o)) return false;
        Subscriber that = (Subscriber) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
