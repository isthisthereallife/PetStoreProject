package com.uppgift;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program<T> {
    List<Person> people;
    List<Pet> pets;
    List<String> petnames;
    static List<String> peoplenames;

    Program() {
        petnames = getNameList(Paths.get("names/petnames.txt"));
        peoplenames = getNameList(Paths.get("names/personnames.txt"));

        pets = makePets(petnames);
        for(Pet p : pets){
            System.out.println("a "+p.getSpecies()+" called " +p.getName());
        }
        people = makePeople();
    }

    //TODO
    private List<Pet> makePets(List<String> petnames) {
        Stream.of(petnames)
                .peek(System.out::println)
                .forEach(n -> pets.add(new Pet("h")));


        /*List<Pet> pets = new ArrayList<>();
        for(String name : petnames){
            pets.add(new Pet(name));
        }
        return pets;*/
        return pets;
    }


    /**
     * ta från listan med personnamn och skapa objekt med varje, där jag skickar in
     *
     * @return
     */
    private List<Person> makePeople() {
        //List<T> nameList =
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

    public static int randomIntOneThroughParam(int max) {
        return (int) (Math.random() * max) + 1;
    }

}