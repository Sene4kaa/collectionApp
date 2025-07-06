package classes.based;

public class Location {
    private final Integer x; //Поле не может быть null
    private final int y;
    private final String name; //Длина строки не должна быть больше 929, Поле не может быть null

    public Location(Integer x, int y, String name) {this.x = x; this.y = y; this.name = name; }

    public String getName() { return name; }
}