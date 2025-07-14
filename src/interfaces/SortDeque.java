package interfaces;

import classes.based.Person;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static java.util.Collections.min;

public interface SortDeque {

    static String byHeight(ArrayDeque<Person> people) {

        StringBuilder result = new StringBuilder();
        ArrayList<Person> temp = new ArrayList<>(people);
        ArrayList<Person> new_temp = new ArrayList<>();

        for (int i = 0; i < temp.size(); i++) {
            if (temp.fi == min(temp)) {

            }
        }
    }
}
