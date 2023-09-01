package ru.test.JavaDataHandling.Task;

import ru.test.JavaDataHandling.Utils.UtilsJavaDataHandling;
import ru.test.Utils.UtilsMenu;
import ru.test.Utils.UtilsScanner;

import java.awt.*;

public class StringPractice {

    public static void menuTask() {

        String menuCase[] = {
                "Перевести положительное число в двоичный код, вернуть в виде строки.",
                "Дан цвет в HEX виде, например #FB12F2, то есть # и три пары 16-ных чисел. Преобразовать его в rgb-цвет в формате rgb(251, 18, 242). Если исходная строка не соответствует формату, вернуть сообщение об этом.",
                "В строке поменять регистр всех букв на противоположный. Пример: FaSt -> fAsT",
                "Выведете массив чисел на печать, элементы должны идти порциями по Х элементов через запятую и пробел, каждая порция на новой строке."
        };

        UtilsMenu.displayMenu("Выберите пункт меню:", menuCase, 1);
        menuTaskHandler(UtilsScanner.getIntFromInput());
    }

    private static void menuTaskHandler(int value) {
        switch (value) {
            case 1: {
                System.out.println("Введите положительное число! от: 0 до: " + Long.MAX_VALUE);
                System.out.println("Результат:\n" +
                        Long.toBinaryString(UtilsScanner.getLongFromInput(0, Long.MAX_VALUE)));

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }

            case 2: {
                Color color = Color.decode(UtilsJavaDataHandling.getHEX());
                System.out.println("Результат:\n" +
                        "rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")");

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }

            case 3: {
                System.out.println("Введите строку:");
                System.out.println("Результат:\n" +
                        UtilsJavaDataHandling.getDifferentRegister(UtilsScanner.getStringConsole()));

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }

            case 4: {
                System.out.println("Введите строку, а затем значение на которую делить строку:");
                System.out.println("Результа:\n" +
                        UtilsJavaDataHandling.getNewArrayOfString(UtilsScanner.getNotEmptyStringConsole(), UtilsScanner.getIntFromInput(0, Integer.MAX_VALUE)));

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }
            default: {
                System.out.println("Что-то пошло не по плану :(");
                menuTask();
                break;
            }
        }
    }
}
