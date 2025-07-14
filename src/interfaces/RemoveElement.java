package interfaces;

import classes.based.Person;

import java.util.ArrayDeque;
import java.util.ArrayList;

public interface RemoveElement {

    static void byID(ArrayDeque<Person> people, String id_str) {

        if (!(Validate.validateID(people, id_str))) {return; }

        int id = Integer.parseInt(id_str);
        ArrayList<Person> temp = new ArrayList<>(people);
        temp.remove(id);
        people.clear();
        people.addAll(temp);
        System.out.printf("Элемент с ID %d удален.%n", id);
    }
}
