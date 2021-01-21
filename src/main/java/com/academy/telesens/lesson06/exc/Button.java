package com.academy.telesens.lesson06.exc;

public class Button extends Component {

    public Button(String text) {
        super(text);
    }

    @Override
    public void draw() {
        System.out.println("Button: draw");
    }

    public void click() {
        System.out.println("Button: click");
    }
}
