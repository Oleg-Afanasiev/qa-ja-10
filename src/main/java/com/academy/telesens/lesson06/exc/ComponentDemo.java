package com.academy.telesens.lesson06.exc;

public class ComponentDemo {
    public static void main(String[] args) {
//        Component component = new Component();
//        component.draw();

        Button button = new Button("Login");
        button.draw();

       // Component component = new Button("Login");

        boolean isChecked = false;
        boolean state = !isChecked;
        System.out.println(state);
    }
}
