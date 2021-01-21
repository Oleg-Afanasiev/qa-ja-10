package com.academy.telesens.lesson08.anonymous;

import com.academy.telesens.lesson06.exc.Button;
import com.academy.telesens.lesson08.Coder;
import com.academy.telesens.lesson08.Fighter;
import com.academy.telesens.lesson08.VisualComponent;

public class AnonymousDemo {
    public static void main(String[] args) {
        VisualComponent component = new Button("Login");
        VisualComponent component2 = new InputField();
        component.draw();
        component2.draw();

        // анонимный класс
        VisualComponent customComponent = new VisualComponent() {
            @Override
            public void draw() {
                System.out.println("Draw: custom component");
            }
        };

        customComponent.draw();

        Coder customCoder = new Coder() {
            @Override
            public void engSpeaking() {
                System.out.println("Intermediate level");
            }

            @Override
            public void coding() {
                System.out.println("functional programming");
            }
        };

        customCoder.coding();

        // 1 способ реализации интерфейса с одним методом - через анонимный класс
        Fighter fighter = new Fighter() {
            @Override
            public void fight() {
                System.out.println("Sumo");
            }
        };
        fighter.fight();

        // 2 способ реализации интерфейса с одним методом - через лямбда выражение
        fighter = ()-> {
            System.out.println("Hello");
            System.out.println("Kick boxing");
        };
        fighter.fight();
    }
}
