package com.uppgift;

public class Pet {
    private String name;
    private String species;
    private boolean available;

    Pet(String name) {
        this.name = name;
        this.species = ((int) (Math.random() * 4) + 1) % 2 == 0 ? "Cat" : "Dog";
        this.available = true;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setAvailable() {
        available = false;
    }
}
