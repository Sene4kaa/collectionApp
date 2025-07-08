package main;

import java.util.ArrayDeque;

import classes.based.*;
import classes.commands.Program;


public class Main {
    public static void main(String[] args) throws Exception{

        ArrayDeque<Person> people = new ArrayDeque<>();
        String fileName = "people.csv";

        Program.start(people, fileName);
    }
}