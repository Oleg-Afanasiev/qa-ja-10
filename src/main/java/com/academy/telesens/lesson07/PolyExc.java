package com.academy.telesens.lesson07;

import com.academy.telesens.lesson06.exc.Button;
import com.academy.telesens.lesson06.exc.Component;
import com.academy.telesens.lesson06.exc.Label;

public class PolyExc {
    public static void main(String[] args) {
        Component[] array = new Component[4];
        Button button = new Button("Button");
        Label label = new Label("Label");

        array[0] = button;
        array[1] = label;
        array[2] = button;
        array[3] = button;

        for (int i=0; i < array.length; i++) {
            array[i].draw();
        }
    }
}
