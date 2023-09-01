package ru.test.JavaDataHandling.Task;

import ru.test.JavaDataHandling.Utils.UtilsJavaDataHandling;
import ru.test.Utils.UtilsMenu;
import ru.test.Utils.UtilsScanner;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

    public static void menuTask() {
        String menuCase[] = {
                "В строке, состоящей из имени и фамилии, определить, начинаются ли имя и фамилия на одну и ту же букву, например Sarah smith. – игнорировать кейс буквы",
                "В строке, состоящей из слов, разделенных пробелами, перевернуть все слова задом наперед. Привет меня зовут Олег – Тевирп янем Гело",
                "Преобразовать строку из lowerCaseName в LOWER_CASE_NAME",
                "Преобразовать строку из UPPER_CASE_NAME в upperCaseName",
                "Дана строка, состоящая из имен. Найти имена, которые начинаются и заканчиваются на X, вернуть в виде массива. Если таких имен в строке нет, вернуть сообщение об этом."

        };

        UtilsMenu.displayMenu("Выберите пункт меню:", menuCase, 1);
        menuTaskHandler(UtilsScanner.getIntFromInput());
    }

    private static void menuTaskHandler(int value) {

        switch (value) {
            case 1: {
                System.out.println("Введите Имя с Фамилией. Пример: Sarah Smith, Sarah smith");
                System.out.println("Результат: " +
                        taskOne(UtilsScanner.getNotEmptyStringConsole()));

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }
            case 2: {
                System.out.println("Введи строку: ");
                System.out.println("Резултат: " +
                        stringReverse(UtilsScanner.getNotEmptyStringConsole()));

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }
            case 3: {
                System.out.println("Введите текст. Пример: lowerCaseName");
                System.out.println("Резульат: " +
                        stringConversionOne(UtilsScanner.getNotEmptyStringConsole()));

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }
            case 4: {
                System.out.println("Введите текст. Пример: UPPER_CASE_NAME");
                System.out.println("Резульат: " +
                        stringConversionTwo(UtilsScanner.getNotEmptyStringConsole()));

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }
            case 5: {
                System.out.println("Введите имена черезе пробел, регистр Важен!\n" +
                        "Пример: Sara Smith Anton");

                System.out.println("Резульат: " +
                        Arrays.toString(searchName(UtilsScanner.getNotEmptyStringConsole())));

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

    private static String[] searchName(String str) {

        while (!str.matches("^[A-Z][a-z]+( [A-Z][a-z]+)*")) {
            System.out.println("Текст не подходит по критериям! Регистр важен! Пример: Sara Smith Anton");
            Matcher matcher = Pattern.compile("[A-Z][a-z]+").matcher(str);
            str = UtilsScanner.getNotEmptyStringConsole();
        }

        return UtilsJavaDataHandling.getName(str, UtilsScanner.getLetterFromInput());
    }

    private static String taskOne(String str) {
        while (!str.matches("^([a-zA-Z]+) ([a-zA-Z]+)*")) {
            System.out.println("Текст не подходит по критериям! Пример: Sarah Smith или Sarah smith");
            str = UtilsScanner.getNotEmptyStringConsole();
        }
        String strSplit[] = str.split(" ");

        return String.valueOf(strSplit[0].charAt(0))
                .equalsIgnoreCase(String.valueOf(strSplit[1].charAt(0))) ?
                "Первые буквы совпадают" : "Первые буквы не совпадают";
    }

    private static String stringConversionOne(String str) {
        while (!str.matches("^([a-z]+)([A-Z][a-z]+)*")) {
            System.out.println("Текст не подходит по критериям! Пример: lowerCaseName");
            str = UtilsScanner.getNotEmptyStringConsole();
        }
        return UtilsJavaDataHandling.getStringConversionOne(str);
    }

    private static String stringConversionTwo(String str) {
        while (!str.matches("^[A-Z]+(_[A-Z]+)*")) {
            System.out.println("Текст не подходит по критериям! Пример: UPPER_CASE_NAME");
            str = UtilsScanner.getNotEmptyStringConsole();
        }
        return UtilsJavaDataHandling.getStringConversionTwo(str);
    }

    private static String stringReverse(String str){
        while (!str.matches("^\\S+( \\S+)*")){
            System.out.println("Текст не подходит под критериям! Пример: Привет меня зовут Олег");
            str = UtilsScanner.getNotEmptyStringConsole();
        }
        return UtilsJavaDataHandling.getStringReverse(str);
    }
}
