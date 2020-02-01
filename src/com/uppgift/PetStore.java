package com.uppgift;

import java.util.ArrayList;
import java.util.List;


public class PetStore {

    static List<Pet> pets;
    public static final PetStore instance = new PetStore();

    private PetStore() {
        List<Pet> petsInStore = new ArrayList<>();
    }

    public static void assignPetsToPerson(Person person) {
        int nrOfAnimals = (int) (Math.random() * 5);
        if (pets.size() < 5) {
            nrOfAnimals = pets.size();
        }
        for (int i = 0; i < nrOfAnimals; i++) {
            person.addAnimalFriend(pets.get(0));
            pets.remove(0);
        }
    }
}
