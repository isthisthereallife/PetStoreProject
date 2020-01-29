package com.uppgift;


public class PetNameGenerator {


    public PetNameGenerator() {

    }

    public String getOnePetName() {
        String nr = String.valueOf(Program.randomIntOneThroughParam(Program.petnames.size()));
        //filtrera bort alla som inte har den siffran



        /*
        *
        *
        *
        * */
        //String name = Program.petnames.stream().filter(s -> s.contains(nr)).
        return "name";
    }


}
