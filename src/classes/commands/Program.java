package classes.commands;

import classes.based.Person;
import interfaces.*;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Program
        implements Validate, AddElements, ArrayInfo, SaveElements, UpdateElements, GetHelpMessage  {

    public static void start(ArrayDeque<Person> people, String fileName) throws Exception {

        AddElements.fromFile(people, fileName);

        Scanner in = new Scanner(System.in);
        while (true) {

            String[] line = in.nextLine().split(" ");

            switch (line[0]) {
                case "help": {
                    System.out.println(GetHelpMessage.message());
                    break;
                }
                case "info": {
                    System.out.println(ArrayInfo.getArrayInfo(people));
                    break;
                }
                case "add": {
                    AddElements.fromKeyboard(people, in);
                    break;
                }
                case "show": {
                    for (Person p : people) {
                        System.out.println(p.getMainInfo());
                    }
                    break;
                }
                case "update": {
                    if (line.length != 2) { System.out.println("Некорректное число параметров"); break; }
                    UpdateElements.byID(people, line[1], in);
                    break;
                }
                case "save": {
                    SaveElements.save(people);
                    break;
                }
                case "exit": {
                    return;
                }
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
        }
    }
}
