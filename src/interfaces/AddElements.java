package interfaces;

import enums.*;
import classes.based.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public interface AddElements {

    static void fromKeyboard(ArrayDeque<Person> p, Scanner in, boolean isMax) {

        System.out.println("Введите имя: ");
        String name = in.nextLine();
        name = Validate.validateEmptyString(name, in);

        System.out.println("Введите координату X: ");
        String x = in.nextLine();
        x = Validate.validateCoordinate(x, in, 613);

        System.out.println("Введите координату Y: ");
        String y = in.nextLine();
        y = Validate.validateCoordinate(y, in, 962);

        System.out.println("Введите рост: ");
        String height = in.nextLine();
        height = Validate.validateNumberGreater0(height, in);

        System.out.println("Введите дату рождения: ");
        String birthday = in.nextLine();
        birthday = Validate.validateDate(birthday, in);

        LocalDate finalBirthday;
        if (birthday.isEmpty()) {
            finalBirthday = null;
        } else {
            finalBirthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        System.out.printf("Введите цвет волос. Доступные цвета: %s%n", Arrays.toString(Color.values()));
        String color = in.nextLine();
        color = Validate.validateEnum(color, in, Color.class, true);
        Color finalColor = Color.valueOf(color);

        System.out.printf("Введите национальность. Доступные нации: %s%n", Arrays.toString(Country.values()));
        String country = in.nextLine();
        country = Validate.validateEnum(country, in, Country.class, false);
        Country finalCountry = Country.valueOf(country);

        System.out.println("Введите название локации: ");
        String locationName = in.nextLine();
        locationName = Validate.validateCapableString(locationName, in, 929);

        System.out.println("Введите координату X локации: ");
        String locationX = in.nextLine();
        locationX = Validate.validateCoordinate(locationX, in, false);

        System.out.println("Введите координату Y локации: ");
        String locationY = in.nextLine();
        locationY = Validate.validateCoordinate(locationY, in, true);

        if (isMax) {
            String check = Filter.heightGreaterThanDigit(p, Long.parseLong(height));
            if (!check.isEmpty()) {
                System.out.println("Рост этого человека не выше максимального в коллекции.");
                return;
            }
        }
        p.add(new Person(
                name,
                new Coordinates(Integer.parseInt(x), Long.parseLong(y)),
                Long.parseLong(height),
                finalBirthday,
                finalColor,
                finalCountry,
                new Location(
                        locationName,
                        Integer.parseInt(locationX),
                        Integer.parseInt(locationY)
                )
        ));
        System.out.println("Объект успешно добавлен!!!");
    }

    static void fromFile(ArrayDeque<Person> p, String file) throws  Exception {

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                p.add(new Person(
                        values[0],
                        new Coordinates(Integer.parseInt(values[1]), Long.parseLong(values[2])),
                        format.parse(values[3]),
                        Long.parseLong(values[4]),
                        LocalDate.parse(values[5]),
                        Enum.valueOf(Color.class, values[6]),
                        Enum.valueOf(Country.class, values[7]),
                        new Location(
                                values[8],
                                Integer.parseInt(values[9]),
                                Integer.parseInt(values[10])

                        )));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
