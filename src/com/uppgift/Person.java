package com.uppgift;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Person {
    private String name;
    private int age;
    private ArrayList<Pet> animalFriends;

    Person(String name) {
        this.name = name;
        this.age = (int) (Math.random() * 70) + 15;
        this.animalFriends = new ArrayList<>();
    }

    public void addAnimalFriend(Pet pet) {
        this.animalFriends.add(pet);
        pet.setAvailable();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Pet> getAnimalFriends() {
        return animalFriends;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        if (animalFriends.size() < 1) {
            return String.format("%s (%d) got no animal at all", this.name, this.age);
        } else if (this.animalFriends.size() == 1) {
            return String.format("%s (%d) got a %s called %s", this.name, this.age, this.animalFriends.get(0).getSpecies(), this.animalFriends.get(0).getName());
        } else {
            return String.format("%s (%d) got these %d animals: [%s]", this.name, this.age, animalFriends.size(), animalFriends.stream()
                    .collect(groupingBy(Pet::getSpecies))
                    .entrySet()
                    .stream()
                    .map(x -> x.getKey() + "s: " + x.getValue().stream().map(Pet::getName).collect(Collectors.joining(", "))).collect(Collectors.joining(" | ")));
        }
    }
}