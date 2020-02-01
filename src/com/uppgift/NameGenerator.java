package com.uppgift;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameGenerator {

    static List<String> getNameList(Path path) {
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
