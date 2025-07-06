package classes.errors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public interface Validate {

    static void validateEmptyString(String field, Scanner in) {

        while (field.isEmpty()) {

            System.out.println("Некорректный ввод. Поле не может быть пустым.\nПопробуйте еще раз: ");
            field = in.nextLine();
        }
    }

    static void validateCapableString(String field, Scanner in, Integer count) {

        while (field.length() > count || field.isEmpty()) {

            System.out.printf(
                    "Некорректный ввод. Строка должна быть длиной от 1 до %d символов.%nПопробуйте еще раз: ", count
            );
            field = in.nextLine();
        }
    }

    static void validateCoordinate(String coordinate, Scanner in, Integer cap) {

        while (!coordinate.matches("-?\\d+") || Integer.parseInt(coordinate) > cap) {

            System.out.printf(
                    "Некорректный ввод. Не является целым числом, или число больше %d. " +
                    "Попробуйте еще раз.\nВведите координату: ", cap
            );
            coordinate = in.nextLine();
        }
    }

    static void validateNumberGreater0(String number, Scanner in) {

        while (!number.isEmpty() && (!number.matches("-?\\d+") || Integer.parseInt(number) <= 0)) {

            System.out.println(
                            "Некорректный ввод. Не является целым числом, или число меньше 0. " +
                            "Попробуйте еще раз.\nВведите число: "
            );
            number = in.nextLine();
        }
    }

    static void validateCoordinate(String coordinate, Scanner in, boolean isEmpty) {

        while (isEmpty && coordinate.isEmpty() || !coordinate.matches("-?\\d+")) {

            System.out.println("Некорректный ввод. Не является целым числом. Попробуйте еще раз.\nВведите координату: ");
            coordinate = in.nextLine();
        }
    }

    static String validateDate(String date, Scanner in) throws DateTimeParseException {

        boolean flag = true;
        while (flag) {

            if (date.isEmpty()) { flag = false; }
            else {
                try {
                    LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    flag = false;
                } catch (DateTimeParseException e) {

                    System.out.println("Некорректный ввод. Не является датой. Попробуйте еще раз.\nВведите дату: ");
                    date = in.nextLine();
                }
            }
        }
        return date;
    }

    static <T extends Enum<T>> String validateEnum(String element, Scanner in, Class<T> enumClass, boolean isEmpty)
            throws IllegalArgumentException {

        if (isEmpty && element.isEmpty()) { return ""; }

        boolean flag = true;
        while (flag) {

            try {
                Enum.valueOf(enumClass, element);
                flag = false;
            } catch (IllegalArgumentException  e) {

                System.out.println(
                        "Некорректный ввод. Не является элементом перечисления.\n" +
                                "Попробуйте еще раз: "
                );
                element = in.nextLine();
            }
        }
        return element;
    }
}
