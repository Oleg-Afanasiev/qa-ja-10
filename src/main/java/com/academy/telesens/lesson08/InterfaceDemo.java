package com.academy.telesens.lesson08;

import com.academy.telesens.lesson05.oop.Person;
import com.academy.telesens.lesson06.exc.Button;
import com.academy.telesens.lesson06.exc.Component;
import com.academy.telesens.lesson06.exc.Label;
import com.academy.telesens.lesson07.Boxer;

import java.util.Arrays;

public class InterfaceDemo {
    public static void main(String[] args) {
        Button button = new Button("Login");
        Component button2 = new Button("Login");
        VisualComponent button3 = new Button("Login");
        VisualComponent label = new Label("First Name");
        // VisualComponent boxer = new Boxer(); // ошибка - boxer не реализовал интерфейс VisualComponent

        button3.draw();
        label.draw();

        // Упражнение
        Fighter fighter = new Boxer();
        Coder programmer = new Programmer();
        Coder tester = new Tester();
        Dancer dancer = new Choreographer();

        fighter.fight();
        programmer.coding();
        dancer.dance();

        System.out.println("Танцы");
        Object[] crowd = {fighter, programmer, dancer};
        for (int i=0; i<crowd.length; i++) {
            if(crowd[i] instanceof Dancer) {
                ((Dancer)crowd[i]).dance();
            }
        }

        System.out.println("Работа");
        Coder[] it = {programmer, tester};
        for (int i = 0; i < it.length; i++) {
            it[i].coding();
        }

        programmer.engSpeaking();

        //

        Person[] people = {new Boxer(), new Choreographer(), new Programmer()};
//        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
    }
}
