package org.example.entities;

import org.springframework.stereotype.Component;

@Component
public class Cat {
    private String name = "Барсик";

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

