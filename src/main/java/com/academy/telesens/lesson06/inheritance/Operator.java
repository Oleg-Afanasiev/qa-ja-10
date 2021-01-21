package com.academy.telesens.lesson06.inheritance;

import java.util.Objects;

public class Operator {
    private String name;
    private String address;

    // Конструкторы
    public Operator(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Operator (){

    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return Objects.equals(name, operator.name) &&
                Objects.equals(address, operator.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
