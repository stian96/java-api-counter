package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
    private Counter counter = new Counter();

    @GetMapping("/counter")
    public String showCounter() {
        return "Initial value of the counter: " + counter.getNumber();
    }

    @GetMapping("/counter/increment")
    public String incrementCounter() {
        this.counter.increment();
        return "Incremented counter, new value is: " + this.counter.getNumber();
    }

    @GetMapping("/counter/decrement")
    public String decrementCounter() {
        this.counter.decrement();
        return "Decremented counter, new values is: " + this.counter.getNumber();
    }
}
