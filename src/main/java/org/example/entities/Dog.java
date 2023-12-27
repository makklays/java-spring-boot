package org.example.entities;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    private String name = "Dodick";

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
