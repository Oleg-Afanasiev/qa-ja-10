package com.academy.telesens.lesson05.oop;

public class Demo {
    public static void main(String[] args) {
        Button btn = new Button();
        Button btn2 = null;
        Button btn3 = new Button();
        Integer number = 123;
        String str = "sdfsdf";
        System.out.println(btn);
        System.out.println(btn2);

        System.out.println(btn.getSize());
        btn.setSize(134);
        btn.setText("Submit");
        System.out.println("btn.size: " + btn.getSize());
        System.out.println("*****");
        btn.printInfo();
        btn.setText("Login");
        btn3.setText("New button");
        btn.printInfo();

        System.out.println("****** btn4 ****");
        Button btn4 = new Button();
        btn4.init(125, "Logout");
        btn4.printInfo();

        // btn4.size = -12;
        btn4.setSize(-12);
        btn4.printInfo();
    }
}
