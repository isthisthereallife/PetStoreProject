package com.uppgift;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    List<Person> people;
    List<Pet> pets;
    List<String> petnames;
    List<String> peoplenames;

    Program() {

        petnames = getNameList(Paths.get("names/petnames.txt"));
        peoplenames = getNameList(Paths.get("names/personnames.txt"));
        pets = makePets(petnames);
        people = makePeople(peoplenames);
        for (Person p : people) {
            assignPetsToPerson(pets, p);
        }
        System.out.println(people.get(0).getAnimalFriends().size());

        for (Person person : people) {
            System.out.println("Person: " + person.getName() + " (" + person.getAge() + ")");
            for (Pet pet : person.getAnimalFriends()) {
                System.out.println("Name: " + pet.getName() + " Species: " + pet.getSpecies());
            }
        }


        Stream.of(people)
                .filter(x -> x.get(0).getAnimalFriends().size() < 0)
                .peek(x -> System.out.println(x + "TUTOTOTO")).close();

        //Stream.of(people).flatMap(p -> p.)
        //people.stream()
        //.filter(l->l)

        //skapa en ström av folk,
        // 1. skriv ut namn och djur Person Olle (24) owns the animals: [Cat: Blackie, Cat: Cedric]
        // 2. sortera efter namn,
        //          gruppera djur
        //          skriv ut (e.g Person Kalle (32) owns the animals: [Cat: Sixten, Dog: Balder])
        // 3. filtrera bort alla som inte har djur,
        //          sortera efter färst djur
        //          om endast 1 djur, skriv inte ut som array


    }

    public static void assignPetsToPerson(List<Pet> petlist, Person person) {
        int nrOfAnimals = (int) (Math.random() * 5);
        //
        petlist.stream()
                .limit(nrOfAnimals)
                .forEachOrdered(person::addAnimalFriend);
    }

    private List<Pet> makePets(List<String> petnames) {
        pets = new ArrayList<>();
        petnames.stream()
                .peek(System.out::println)
                .forEachOrdered(s -> pets.add(new Pet(s)));
        return pets;
    }

    private List<Person> makePeople(List<String> peoplenames) {
        people = new ArrayList<>();
        peoplenames.stream().forEachOrdered(s -> people.add(new Person(s)));
        return people;
    }

    private List<String> getNameList(Path path) {
        List<String> nameList = null;
        try {
            nameList = Files.lines(path)
                    .flatMap(s ->
                            Stream.of(s.split(", "))
                    ).flatMap(s ->
                            Stream.of(s.split("\"*\\d+\\. "))
                    ).flatMap(s ->
                            Stream.of(s.split("\""))
                    ).flatMap(s ->
                            Stream.of(s.split(" "))
                    )
                    .filter(s -> s.length() > 0)
                    .peek(System.out::println)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameList;
    }
}