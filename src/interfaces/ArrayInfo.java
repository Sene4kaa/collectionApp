package interfaces;

import classes.based.Person;

import java.util.ArrayDeque;

public interface ArrayInfo {

    static String getArrayInfo(ArrayDeque<Person> arrayDeque) {

        int countElements = arrayDeque.size();
        String firstElement = (arrayDeque.isEmpty())
                ? "коллекция пуста"
                : arrayDeque.getFirst().getMainInfo();

        return String.format("Размер коллекции: %d%nПервый элемент коллекции: %s", countElements, firstElement);
    }
}
