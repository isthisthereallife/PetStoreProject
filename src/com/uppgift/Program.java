package com.uppgift;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    static List<Person> people;
    static List<Pet> pets;
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


        //printResultat1noStream();
        //TODO
        printResultat1someStream(people);

        /*
        List<String> personlist = people.stream()
                .map(p -> "name: " +p.getName() + " (" + p.getAge()+") ")
                .peek(System.out::println)
                        .collect(Collectors.toList());
        int x = 0;
        do{
            int finalX = x;
            List<String> animals = people.stream()
               // .map(a -> a.getAnimalFriends().get(a))
                .map( a -> a.getAnimalFriends().get(finalX).getSpecies()+" "+a.getAnimalFriends().get(finalX).getName())
                .peek(System.out::println)
                .collect(Collectors.toList());
        x++;
        }while (x<people.size());
        Stream.of(people)
                .flatMap(person->Stream.of(person))
                .flatMap(Stream::of);


        */
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

    public void printResultat1someStream(List<Person> ppl){
        for( Person p : ppl){
            for(Pet pet : p.getAnimalFriends()){
                //TODO
               // Stream.of(pet).map(a -> Stream.of(a.getName()).peek());
            }
        }
    }

    public void printResultat1noStream(){
        //Stream.of(people).flatMap(person -> )

        for (Person person : people) {
            System.out.print("Person " + person.getName() + " (" + person.getAge() + ")");
            if (person.getAnimalFriends().size() > 0) {
                if (person.getAnimalFriends().size() == 1)
                    System.out.print(" has the animal: [");
                else
                    System.out.print(" has the animals: [");
                for (Pet pet : person.getAnimalFriends()) {
                    System.out.print(pet.getSpecies() + ": " + pet.getName());
                }

                System.out.println("]");
            } else System.out.println(" aint got no animal");
        }
    }
    public static void assignPetsToPerson(List<Pet> petlist, Person person) {
        int nrOfAnimals = (int) (Math.random() * 5);
        if (petlist.size() < 5) {
            nrOfAnimals = petlist.size();
        }
        for (int i = 0; i < nrOfAnimals; i++) {
            person.addAnimalFriend(petlist.get(0));
            petlist.remove(0);
        }


        //måste ta bort från listan men det går inte eftersom den används
        //petlist.stream().limit(nrOfAnimals).forEachOrdered(person::addAnimalFriend);
    }

    private List<Pet> makePets(List<String> petnames) {
        pets = new ArrayList<>();
        petnames.stream().forEachOrdered(s -> pets.add(new Pet(s)));
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
                    //.peek(System.out::println)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameList;
    }
}