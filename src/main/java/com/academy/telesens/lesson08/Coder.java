package com.academy.telesens.lesson08;

public interface Coder {
    void coding();
    default void engSpeaking() {
        System.out.println("Non now");
    }
}
