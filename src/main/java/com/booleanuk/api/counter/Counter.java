package com.booleanuk.api.counter;

public class Counter {
    private int number;

    public Counter() {
        this.number = 0;
    }

    public void increment() {
        this.number++;
    }

    public void decrement() {
        this.number--;
    }

    public int getNumber() {
        return this.number;
    }
}
