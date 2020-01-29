package com.uppgift;

public class Pet {
    private String name;
    private String species;

    Pet(String name) {
        this.name = name;
        this.species = Program.randomIntOneThroughParam(4) % 2 == 0 ? "cat" : "dog";
    }
    public String getName(){
        return this.name;
    }
    public String getSpecies(){
        return this.species;
    }
}
