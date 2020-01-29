package com.uppgift;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    static List<Person> people;
    static List<Pet> pets;
    static List<String> petnames;
    static List<String> peoplenames;

    Program() {

        petnames = getNameList(Paths.get("names/petnames.txt"));
        peoplenames = getNameList(Paths.get("names/personnames.txt"));




    }


    private List<String> getNameList(Path path){
        List<String> nameList = null;
        try {
            nameList = Files.lines(path)
                    .flatMap(s ->
                            Stream.of(s.split(", "))
                    )
                    .flatMap(s ->
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