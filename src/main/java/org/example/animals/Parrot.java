package org.example.animals;

import org.springframework.stereotype.Component;

@Component("parrot-popka")
public class Parrot {
    private String name = "Попка";

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
