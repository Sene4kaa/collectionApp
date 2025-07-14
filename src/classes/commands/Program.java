package classes.commands;

import classes.based.Person;
import interfaces.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Program  {

    public static void start(ArrayDeque<Person> people, String fileName) throws Exception {

        AddElements.fromFile(people, fileName); // Стартовое добавление элементов в коллекцию

        ArrayList<String> commands = new ArrayList<>(); // Инициализация списка для запоминания введенных команд
        Scanner in = new Scanner(System.in); // Инициализация Сканера

        do {
            String[] line = in.nextLine().split(" "); // Сплит введенной строки

            if (line[0].equals("exit")) {return; }

            Commands.switchCommands(line, people, in, commands, fileName);
            if (!line[0].isEmpty()) {
                commands.add(line[0]);
                if (commands.size() > 9) {
                    commands.removeFirst();
                }
            }
        } while (true);
    }
}
