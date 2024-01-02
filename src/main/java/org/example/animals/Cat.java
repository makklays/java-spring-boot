package org.example.animals;

import org.springframework.stereotype.Component;

@Component
public class Cat {
    private String name = "Барсик";

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {}

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

