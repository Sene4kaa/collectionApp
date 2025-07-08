package interfaces;

import classes.based.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;

public interface SaveElements {

    static void save(ArrayDeque<Person> people) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("people.csv"))) {

            for (Person p : people) {
                writer.write(p.getInfoForCSVFile());
                writer.newLine();
            }
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
