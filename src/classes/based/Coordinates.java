package classes.based;

public class Coordinates {
    private Integer x; //Максимальное значение поля: 613, Поле не может быть null
    private Long y; //Максимальное значение поля: 962, Поле не может быть null

    public Coordinates(Integer x, Long y) { this.x = x; this.y = y; }

    public String getCoordinates() { return x + "," + y; }
}