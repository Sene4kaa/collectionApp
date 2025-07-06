package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Arrays;

import classes.based.Coordinates;
import classes.based.Location;
import classes.based.Person;
import classes.errors.Validate;
import classes.commands.Command;
import enums.*;

public class Main {
    public static void main(String[] args) {

        ArrayDeque<Person> people = new ArrayDeque<Person>();

        while (true) {

            Scanner in = new Scanner(System.in);

            switch (in.nextLine()) {
                case "help": {
                    System.out.println(Command.getHelpMessage());
                    break;
                }
                case "info": {
                    System.out.println(people.getClass());
                    break;
                }
                case "add": {

                    System.out.println("Введите имя: ");
                    String name = in.nextLine();
                    Validate.validateEmptyString(name, in);

                    System.out.println("Введите координату X: ");
                    String x = in.nextLine();
                    Validate.validateCoordinate(x, in, 613);

                    System.out.println("Введите координату Y: ");
                    String y = in.nextLine();
                    Validate.validateCoordinate(y, in, 962);

                    System.out.println("Введите рост: ");
                    String height = in.nextLine();
                    Validate.validateNumberGreater0(height, in);

                    System.out.println("Введите дату рождения: ");
                    String birthday = in.nextLine();
                    birthday = Validate.validateDate(birthday, in);

                    LocalDate finalBirthday;
                    if (birthday.isEmpty()) { finalBirthday = null; }
                    else { finalBirthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy")); }

                    System.out.printf("Введите цвет волос. Доступные цвета: %s", Arrays.toString(Color.values()));
                    String color = in.nextLine();
                    color = Validate.validateEnum(color, in, Color.class, true);
                    Color finalColor = Color.valueOf(color);

                    System.out.printf("Введите национальность. Доступные нации: %s", Arrays.toString(Country.values()));
                    String country = in.nextLine();
                    country = Validate.validateEnum(country, in, Country.class, false);
                    Country finalCountry = Country.valueOf(country);

                    System.out.println("Введите название локации: ");
                    String locationName = in.nextLine();
                    Validate.validateCapableString(locationName, in, 929);

                    System.out.println("Введите координату X локации: ");
                    String locationX = in.nextLine();
                    Validate.validateCoordinate(locationX, in, false);

                    System.out.println("Введите координату Y локации: ");
                    String locationY = in.nextLine();
                    Validate.validateCoordinate(locationY, in, true);

                    people.add(new Person(
                            name,
                            new Coordinates(Integer.parseInt(x), Long.parseLong(y)),
                            Long.parseLong(height),
                            finalBirthday,
                            finalColor,
                            finalCountry,
                            new Location(
                                    Integer.parseInt(locationX),
                                    Integer.parseInt(locationY),
                                    locationName
                            )
                    ));
                    System.out.println("Объект успешно добавлен!!!");
                    break;

                }
                case "show": {
                    for (Person p : people) {
                        System.out.println(p.getInfo());
                    }
                    break;
                }
                case "exit": {
                    return;
                }
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
        }
    }
}