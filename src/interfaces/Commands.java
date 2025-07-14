package interfaces;

import classes.based.Person;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public interface Commands {

    String COUNT_PARAMETERS_ERROR = "Некорректное число параметров";

    static void switchCommands(String[] line, ArrayDeque<Person> people, Scanner in,
                       ArrayList<String> commands, String filename) {

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
                break;
            }
            case "show": {
                for (Person p : people) {
                    System.out.println(p.getMainInfo());
                }
                break;
            }
            case "update": {
                if (line.length != 2) { System.out.println(COUNT_PARAMETERS_ERROR); break; }
                UpdateElements.byID(people, line[1], in);
                break;
            }
            case "remove_by_id": {
                if (line.length != 2) { System.out.println(COUNT_PARAMETERS_ERROR); break; }
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
                if (line.length != 2) { System.out.println(COUNT_PARAMETERS_ERROR); break; }
                if (!line[1].matches("-?\\d+")) { System.out.println("Некорректное число."); break; }

                String answer = Filter.heightGreaterThanDigit(people, Long.parseLong(line[1]));
                if (answer.isEmpty()) { System.out.println("Запрос не вернул результатов."); }
                else { System.out.println(answer); }
                break;
            }
            case "print_ascending": {
                System.out.println(SortDeque.byHeight(people));
                break;
            }
            case "print_unique_nationality": {
                System.out.println(Filter.uniqueNationalities(people));
                break;
            }
            case "execute_script": {
                if (line.length != 2) { System.out.println(COUNT_PARAMETERS_ERROR); break; }
                InputCommands.fromFile(line[1], people, in, commands, filename);
                break;
            }
            case "history": {

                for (String c : commands.subList(0, commands.size() - 2)) {
                    System.out.print(c + ", ");
                }
                System.out.println(commands.getLast());
                break;
            }
            default:
                System.out.println("Неизвестная команда.");
                break;
        }
    }
}
