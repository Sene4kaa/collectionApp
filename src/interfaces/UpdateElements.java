package interfaces;

import classes.based.Person;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public interface UpdateElements {

    static void byID(ArrayDeque<Person> people, String id_str, Scanner in) {

        if (!(Validate.validateID(people, id_str))) {return; }

        int id = Integer.parseInt(id_str);
        ArrayDeque<Person> person = new ArrayDeque<>();
        AddElements.fromKeyboard(person, in, false);

        List<Person> temp = new ArrayList<>(people);
        temp.set(id, person.getFirst());
        people.clear();
        people.addAll(temp);
        System.out.printf("Элемент с ID %d обновлен.%n", id);
    }
}
