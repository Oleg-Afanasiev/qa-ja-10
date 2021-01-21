package com.academy.telesens.lesson06.exc;

import com.academy.telesens.lesson08.VisualComponent;

public abstract class Component implements VisualComponent {
    private String text;

    public Component(String text) {
        this.text = text;
    }

    @Override
    public abstract void draw();
}
