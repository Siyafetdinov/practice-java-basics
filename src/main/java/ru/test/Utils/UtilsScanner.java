package ru.test.Utils;

import java.util.Scanner;

public class UtilsScanner {
    public static String getStringConsole() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static String getNotEmptyStringConsole() {
        String str = getStringConsole();
        while (str.matches("^\\s+$")) {
            System.out.println("Вы ввели полностью пустую строку! Повторите ввод");
            str = getStringConsole();
        }
        return str;
    }

    public static String getDigitFromInput() {
        String str = getStringConsole();
        while (!str.matches("\\d*")) {
            System.out.println("Ошибка, вы ввели не число!");
            str = getStringConsole();
        }
        return str;
    }

    public static char getLetterFromInput() {
        System.out.println("Введите букву от a-z или A-Z: ");
        String str = getStringConsole();
        while (!str.matches("^[a-zA-z]$")) {
            System.out.println("Неверно! \n" +
                    "Введите букву от a-z или A-Z");
            str = getStringConsole();
        }
        return str.charAt(0);
    }

    public static int getIntFromInput() {
        String str = getDigitFromInput();
        return Integer.parseInt(str);
    }

    public static int getIntFromInput(int min, int max) {
        System.out.println("Введите число от " + min + " до " + max);
        int value = getIntFromInput();
        while (value > max || value < min) {
            System.out.println("Введите число от " + min + " до " + max);
            value = getIntFromInput();
        }
        return value;
    }

    public static long getLongFromInput() {
        String str = getDigitFromInput();
        return Long.parseLong(str);
    }

    public static long getLongFromInput(long min, long max) {
        System.out.println("Введите число от " + min + " до " + max);
        long value = getLongFromInput();
        while (value > max || value < min) {
            System.out.println("Введите число от " + min + " до " + max);
            value = getLongFromInput();
        }
        return value;
    }
}
