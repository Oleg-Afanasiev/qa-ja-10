package com.academy.telesens.lesson05.oop;

public class Button {
    public static final String DEFAULT_TEXT = "Some button";
    // поля
    private int size;   // 0
    private String text; // null

    // конструктор
    public Button() {
    }

    public Button(int size, String text) {
        System.out.println("Конструктор класса button с аргументами");
        this.size = size;
        this.text = text;
    }

    //    public Button(int size, String text) {
//        this.size = size;
//        this.text = text;
//    }

    public void init() {
        size = 20;
        text = "NoName";
    }

    public void init(int size, String text) {
        this.size = size;
        this.text = text;
    }



    public void setSize(int size) {
        if (size < 0) {
            System.out.println("Wrong size: " + size);
            return;
        }

        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // методы
    public void printInfo() {
        System.out.println(String.format("size: %d, text: %s", size, text));
    }

    public static void sayHello() {
        System.out.println("Hello from button");
    }
}
