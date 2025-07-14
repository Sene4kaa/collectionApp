package interfaces;

import classes.based.Person;
import enums.Country;

import java.util.ArrayDeque;
import java.util.ArrayList;

public interface Filter {

    static String heightGreaterThanDigit(ArrayDeque<Person> people, Long height) {

        StringBuilder result = new StringBuilder();
        for (Person p : people) {
            if (p.getHeight() > height) { result.append(p.getMainInfo()).append("\n"); }
        }
        return result.toString();
    }

    static String uniqueNationalities(ArrayDeque<Person> people) {

        ArrayList<Country> countries = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        TwoFors:
        for (Person p : people) {
            if (countries.size() == Country.values().length) { break; }
            for (Country c : countries) {
                if (p.getNationality() == c) {
                    continue TwoFors;
                }
            }
            countries.add(p.getNationality());
        }
        for (Country c : countries.subList(0, countries.size() - 1)) { result.append(c); result.append(", "); }
        result.append(countries.getLast());
        return result.toString();
    }
}
