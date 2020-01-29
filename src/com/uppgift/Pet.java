package com.uppgift;

public class Pet {
    private String name;
    private String type;

    Pet() {
        //this.name = PetNameGenerator.getOnePetName();
        this.type = Program.randomIntOneThroughParam(4) % 2 == 0 ? "cat" : "dog";
    }

}
