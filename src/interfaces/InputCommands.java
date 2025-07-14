package interfaces;

import classes.based.Person;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public interface InputCommands {

    static void fromFile(String fileInput, ArrayDeque<Person> people, Scanner in,
                         ArrayList<String> commandsHistory, String filename) {

        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileInput))) {

            String lineInputFile;
            while ((lineInputFile = reader.readLine()) != null) {

                String[] command = lineInputFile.split(" ");
                Commands.switchCommands(command, people, in, commandsHistory, filename);
            }
            System.out.println("Команды из файла успешно выполнены.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
