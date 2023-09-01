package ru.test.JavaException.Utils;

import ru.test.JavaException.Exception.ZeroException;

import java.io.IOException;

public class UtilsJavaException {

    public static int getIntValueExampleOne(String value, String nameValue) {
        int result = 0;

        try {
            result = Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            System.out.println("К сожалению не получилось получить ЧИСЛО " + e);
        } finally {
            if (result <= 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Параметра '" + nameValue + "' , меньше 0, равно 0, или число не было задано!");
                } finally {
                    result = 1000;
                    System.out.println("Присвоено стандартное значение для параметра '" + nameValue + "' " + result);
                }
            }
        }
        return result;
    }

    public static int getIntValueExampleTwo(String value, String nameValue) throws ZeroException {
        int result = 0;

        if (!value.matches("^\\d*")) {
            throw new NumberFormatException("К сожалению не получилось получить ЧИСЛО");
        } else {
            result = Integer.parseInt(value);
        }

        if (result <= 0) {
            throw new ZeroException("Параметра '" + nameValue + "' , меньше 0, равно 0, или число не было задано!");
        }

        return result;
    }
}
