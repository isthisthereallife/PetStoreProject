package com.uppgift;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameGenerator {

    static List<String> getNameList(Path path) {
        List<String> list = null;
        try {
            list = Files.lines(path)
                    .flatMap(s -> Stream.of(s.replaceAll("[^a-zA-Z]+", "\n")
                            .trim()
                            .split("\n")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
