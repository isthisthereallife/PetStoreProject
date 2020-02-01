package com.uppgift;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    static List<Person> people;
    List<String> petnames;
    List<String> peoplenames;

    Program() {

        petnames = NameGenerator.getNameList(Paths.get("names/petnames.txt"));
        peoplenames = NameGenerator.getNameList(Paths.get("names/personnames.txt"));
        PetStore.pets = PetGenerator.makePets(petnames);
        people = PersonGenerator.makePeople(peoplenames);
        people.stream().forEach(a -> PetStore.assignPetsToPerson(a));

        printResultat3(people);
        //printResultat1noStream();
        //TODO
        //printResultat1someStream(people);


        //skapa en ström av folk,
        // 1. skriv ut namn och djur Person Olle (24) owns the animals: [Cat: Blackie, Cat: Cedric]
        // 2. sortera efter namn,
        //          gruppera djur
        //          skriv ut (e.g Person Kalle (32) owns the animals: [Cat: Sixten, Dog: Balder])
        // 3. filtrera bort alla som inte har djur,
        //          sortera efter färst djur
        //          om endast 1 djur, skriv inte ut som array
    }


    public void printResultat3(List<Person> ppl) {
        var test = Stream.of(ppl).flatMap(p -> p.stream()
                .filter(r -> r.getAnimalFriends().size() > 0))
                .toArray();
        System.out.println(test);
        System.out.println();
    }

    public void printResultat1someStream(List<Person> ppl) {
        for (Person p : ppl) {
            System.out.printf("%s (%d)", p.getName(), p.getAge());
            if (p.getAnimalFriends().size() > 0) {
                System.out.print(" has the animals: ");
                p.getAnimalFriends().stream()
                        .forEach(a -> System.out.printf("%s: %s ", a.getSpecies(), a.getName()));

                Stream.of(p.getAnimalFriends())
                        .flatMap(a -> a.stream())
                        .forEach(q -> System.out.printf("%s: %s, ", q.getSpecies(), q.getName()));
            }
       /* for (Pet pet : p.getAnimalFriends()) {
                Stream.of(pet).forEach(a -> System.out.printf("%s: %s, ", a.getSpecies(), a.getName()));
            }
            */
            System.out.println();
        }
    }

    public void printResultat1noStream() {
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


    //måste ta bort från listan men det går inte eftersom den används
    //petlist.stream().limit(nrOfAnimals).forEachOrdered(person::addAnimalFriend);


}