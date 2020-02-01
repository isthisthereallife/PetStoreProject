package com.uppgift;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.uppgift.Program.people;

public class PersonGenerator {




    static List<Person> makePeople(List<String> peoplenames) {
        people = new ArrayList<>();
        peoplenames.stream().forEachOrdered(s -> people.add(new Person(s)));
        return people;
    }
}
