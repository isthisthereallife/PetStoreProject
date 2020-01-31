package com.uppgift;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Person {
    private String name;
    private int age;
    private ArrayList<Pet> animalFriends;
    Person(String name){
        this.name = name;
        this.age = (int) (Math.random() * 70) +15;
        this.animalFriends = new ArrayList<>();
    }
    public void addAnimalFriend(Pet pet){
        this.animalFriends.add(pet);
        pet.setAvailable();
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<Pet> getAnimalFriends(){
        return animalFriends;
    }
    public int getAge(){
        return this.age;
    }
}