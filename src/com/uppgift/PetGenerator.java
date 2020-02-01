package com.uppgift;

import java.util.ArrayList;
import java.util.List;

public class PetGenerator {


    static List<Pet> makePets(List<String> petnames) {
        PetStore.pets = new ArrayList<>();
        petnames.stream().forEachOrdered(s -> PetStore.pets.add(new Pet(s)));
        return PetStore.pets;
    }
}
