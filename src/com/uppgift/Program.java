package com.uppgift;

import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
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

        System.out.println("\n~~~LETS GO TO THE PET STORE~~~\n");
        people.stream().forEach(System.out::println);
        System.out.println("\n~~~SORTING BY NAME~~~\n");
        people.stream()
                .sorted(Comparator.comparing((p) -> p.getName()))
                .forEach(System.out::println);
        System.out.println("\n~~~SORTING BY NR OF ANIMALS AND FILTERING OUT PEOPLE WITHOUT~~~\n");
        Stream.of(people)
                .flatMap(p -> p.stream()
                .filter(r -> r.getAnimalFriends().size() > 0))
                .sorted(Comparator.comparingInt(o -> o.getAnimalFriends().size()))
                .forEach(System.out::println);
    }
}