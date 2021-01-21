package com.academy.telesens.lesson09;

import com.academy.telesens.lesson05.oop.Person;

public class ExceptionDemo {
    public static void main(String[] args) {
        double d1 = 1;
        double d2 = 0;

        try {
            // Потенциально опасный код
            double result = div(d1, d2);
            System.out.println(result);
        } catch (DivisionByZeroError e) {
            // Обработка ошибки
            System.out.println("Error: division by zero");
            System.out.println("Details: " + e.getLocalizedMessage());
        }

        try {
            int result = div(1, 0);
            System.out.println("****");
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Common error");
            System.out.println("Details: " + e.getLocalizedMessage());
        }


//        System.out.println(n1/n2);

        Person person = new Person();
        person.setAge(24);

        try {
            person.setAge(-5); // => возраст отрицательный
            person.setAge(140); // => пока столько не живут
        } catch (NegativeAgeError e) {

        } catch (TooBigAgeError e) {

        }

        System.out.println("FINISH");
    }

    public static double div(double d1, double d2) throws DivisionByZeroError {
        if (d2 == 0)
            throw new DivisionByZeroError("Unsupported division by zero");

        return d1/d2;
    }

    public static int div(int n1, int n2) {
        return n1/n2;
    }
}
