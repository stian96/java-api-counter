package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private Counter counter;

    public CounterController(Counter counter) {
        this.counter = counter;
    }

    @GetMapping
    public String showCounter() {
        if (counter != null) {
            return "Initial value of the counter: " + counter.getNumber();
        }
        else {
            return "Counter not created yet";
        }
    }

    @GetMapping("/increment")
    public String incrementCounter() {
        this.counter.increment();
        return "Incremented counter, new value is: " + this.counter.getNumber();
    }

    @GetMapping("/decrement")
    public String decrementCounter() {
        this.counter.decrement();
        return "Decremented counter, new values is: " + this.counter.getNumber();
    }

    @GetMapping("/custom/{name}")
    public String createCustomCounter(@PathVariable String name) {
        if (!this.counter.getName().equals(name)) {
            this.counter = new Counter(name);
            return "New counter created for: " + name + "!";
        }
        else {
            return "Counter for " + name + " already exists. Counter value is: " + this.counter.getNumber();
        }
    }
}
