package classes.based;

import enums.*;

import java.time.Instant;

public class Person {

    private static Integer nextId = 1;
    private final Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Long height; //Поле может быть null, Значение поля должно быть больше 0
    private final java.time.LocalDate birthday; //Поле может быть null
    private final Color hairColor; //Поле может быть null
    private final Country nationality; //Поле не может быть null
    private final Location location; //Поле не может быть null

    public Person(String name,
                  Coordinates coordinates,
                  Long height,
                  java.time.LocalDate birthday,
                  Color hairColor,
                  Country nationality,
                  Location location
    ) {

        this.id = nextId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.util.Date.from(Instant.now());
        this.height = height;
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public Person(String name,
                  Coordinates coordinates,
                  java.util.Date creationDate,
                  Long height,
                  java.time.LocalDate birthday,
                  Color hairColor,
                  Country nationality,
                  Location location
    ) {

        this.id = nextId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public String getMainInfo() {

        return "Имя: " + name + ", рост: " + height + "см, локация: " + this.location.getName();
    }

    public String getInfoForCSVFile() {
        return String.format("%s,%s,%s,%d,%s,%s,%s,%s",
                name,
                coordinates.getCoordinates(),
                creationDate,
                height,
                birthday,
                hairColor,
                nationality,
                location.getLocation()
                );
    }
}