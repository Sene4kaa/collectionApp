package interfaces;

import classes.based.Person;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.stream.Collectors;


public interface SortDeque {

    static StringBuilder byHeight(ArrayDeque<Person> people) {

        ArrayDeque<Person> sortedDeque = people.stream()
                .sorted(Comparator.comparingLong(Person::getHeight))
                .collect(Collectors.toCollection(ArrayDeque::new));

        StringBuilder result = new StringBuilder();
        sortedDeque.forEach(person -> result.append(person.getMainInfo()).append("\n"));
        return result;
    }
}
