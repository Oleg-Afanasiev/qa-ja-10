package com.academy.telesens.lesson05.other;

import com.academy.telesens.lesson05.oop.Button;

public class ButtonDemo {
    public static void main(String[] args) {
        Button btn = new Button(); // Вызывается конструктор по умолчанию
        btn.setText("sdfsd");
        System.out.println(btn.getText());

        Button btn2 = new Button(15, "NewButton");
        btn2.printInfo();

        System.out.println(Button.DEFAULT_TEXT);
        Button.sayHello();
    }
}
