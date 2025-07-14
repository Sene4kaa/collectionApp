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
        Scanner in = new Scanner(System.in); // Инициализация Сканнера

        while (true) {

            String[] line = in.nextLine().split(" "); // Сплит введенной строки

            switch (line[0]) { // Проверка первой команды
                case "help": {
                    System.out.println(GetHelpMessage.message());
                    break;
                }
                case "info": {
                    System.out.println(ArrayInfo.getArrayInfo(people));
                    break;
                }
                case "add": {
                    AddElements.fromKeyboard(people, in, false);
                    break;
                }
                case "add_if_max": {
                    AddElements.fromKeyboard(people, in, true);
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
                case "remove_by_id": {
                    if (line.length != 2) { System.out.println("Некорректное число параметров"); break; }
                    RemoveElement.byID(people, line[1]);
                    break;
                }
                case "remove_first": {
                    people.pollFirst();
                    System.out.println("Первый элемент коллекции удален.");
                    break;
                }
                case "clear": {
                    people.clear();
                    System.out.println("Коллекция очищена.");
                    break;
                }
                case "save": {
                    SaveElements.save(people);
                    break;
                }
                case "filter_greater_than_height": {
                    if (line.length != 2) { System.out.println("Некорректное число параметров"); break; }
                    if (!line[1].matches("-?\\d+")) { System.out.println("Некорректное число."); break; }

                    String answer = Filter.heightGreaterThanDigit(people, Long.parseLong(line[1]));
                    if (answer.isEmpty()) { System.out.println("Запрос не вернул результатов."); }
                    else { System.out.println(answer); }
                    break;
                }
                case "print_unique_nationality": {
                    System.out.println(Filter.uniqueNationalities(people));
                    break;
                }
                case "history": {

                    for (String c : commands) {
                        System.out.print(c + ", ");
                    }
                    break;
                }
                case "exit": {
                    return;
                }
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
            if (!line[0].isEmpty()) {
                commands.add(line[0]);
                if (commands.size() > 9) { commands.removeFirst(); }
            }
        }
    }
}
