package com.academy.telesens.lesson06.exc;

public class Label extends Component {

    public Label(String text) {
        super(text);
    }

    @Override
    public void draw() {
        System.out.println("Label: draw");
    }
}
