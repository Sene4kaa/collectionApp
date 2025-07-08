package classes.based;

public class Location {
    private final Integer x; //Поле не может быть null
    private final int y;
    private final String name; //Длина строки не должна быть больше 929, Поле не может быть null

    public Location(String name, Integer x, int y) { this.name = name; this.x = x; this.y = y; }

    public String getName() { return name; }

    public String getLocation() { return name + "," + x + "," + y;}
}