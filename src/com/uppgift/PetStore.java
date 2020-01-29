package com.uppgift;

import java.util.ArrayList;
import java.util.List;

public class PetStore {

    public PetStore(){
        List<Pet> petsInStore= new ArrayList<>();

    }
    private void addPetsToList(List<Pet> petList){
        for (int i = 0; i<100;i++){
            petList.add(new Pet());
        }
    }
}
