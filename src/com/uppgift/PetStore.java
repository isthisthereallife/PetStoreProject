package com.uppgift;

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    public static final PetStore instance = new PetStore();

    private PetStore(){
        List<Pet> petsInStore= new ArrayList<>();
    }

    public static void getInstance(){

    }
}
