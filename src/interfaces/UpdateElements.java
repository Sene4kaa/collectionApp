package interfaces;

import classes.based.Person;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public interface UpdateElements {

    static void byID(ArrayDeque<Person> people, String id_str, Scanner in) {

        if (!id_str.matches("-?\\d+")) { System.out.println("Некорректный ID."); return; }

        int id = Integer.parseInt(id_str);

        if (id >= people.size() || id < 0) { System.out.println("Некорректный ID."); return; }

        ArrayDeque<Person> person = new ArrayDeque<>();
        AddElements.fromKeyboard(person, in);

        List<Person> temp = new ArrayList<>(people);
        temp.set(id, person.getFirst());
        people.clear();
        people.addAll(temp);
        System.out.printf("Элемент с ID %d обновлен.", id);
    }
}
