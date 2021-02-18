package com.academy.api.rest;

public class NotFoundSubscriberException extends RuntimeException {
    private final int id;

    public NotFoundSubscriberException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
