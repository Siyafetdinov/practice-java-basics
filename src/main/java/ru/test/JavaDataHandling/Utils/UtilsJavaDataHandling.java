package ru.test.JavaDataHandling.Utils;

import ru.test.Utils.UtilsScanner;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsJavaDataHandling {

    public static String getDifferentRegister(String str) {
        Matcher matcher = Pattern.compile("([A-Z]+)|([a-z]+)|([А-Я]+)|([а-я]+)").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();

        while (matcher.find()) {
            if (matcher.group().matches("[A-Z]+|[А-Я]+")) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(matcher.group().toLowerCase()));
            } else if (matcher.group().matches("[a-z]+|[а-я]+")) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(matcher.group().toUpperCase()));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String getNewArrayOfString(String str, int step) {
        StringBuilder result = new StringBuilder();
        int count = step;

        for (int i = 0; i < str.length(); i++) {
            if (count == 0) {
                count = step;
                result.append("\n");
            }
            result.append(str.charAt(i) + ", ");
            count--;
        }
        return result.toString();
    }

    public static String getStringReverse(String str) {
        StringBuilder result = new StringBuilder();



        String[] strSplit = str.split(" ");

        for (int i = 0; i < strSplit.length; i++) {
            StringBuilder tmp = new StringBuilder(strSplit[i]);
            tmp.reverse();
            result.append(tmp + " ");
        }
        return result.toString();
    }

    public static String getStringConversionOne(String str) {
        Matcher matcher = Pattern.compile("([a-z])([A-Z])").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();

        while (matcher.find()) {
            char[] chars = matcher.group().toCharArray();
            matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(chars[0] + "_" + chars[1]));
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString().toUpperCase();
    }

    public static String getStringConversionTwo(String str) {
        Matcher matcher = Pattern.compile("([A-Z])_([A-Z])").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();

        while (matcher.find()) {

            char[] chars = matcher.group().toCharArray();
            matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(chars[0] + String.valueOf(chars[2]).toLowerCase()));
        }
        matcher.appendTail(stringBuffer);

        return getDifferentRegister(stringBuffer.toString());
    }

    public static String[] getName(String str, char charSearch) {
        StringBuilder result = new StringBuilder();

        String strSplit[] = str.split(" ");
        for (String name : strSplit) {
            if (String.valueOf(charSearch).equalsIgnoreCase(String.valueOf(name.charAt(0)))){
                if (String.valueOf(name.charAt(0)).equalsIgnoreCase(String.valueOf(name.charAt(name.length() - 1)))) {
                    result.append(name + " ");
                }
            }
        }

        if (result.isEmpty()) {
            return new String[]{"Не найдено по заданным критериям!"};
        } else {
            return result.toString().split(" ");
        }
    }

    public static List<LocalDate> getFridayTheThirteenth(LocalDate date) {
        List<LocalDate> result = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            date = date.withMonth(i);
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                result.add(date);
            }
        }
        return result;
    }

    public static List<LocalDateTime> getRandomDateTime(int size) {
        List<LocalDateTime> dateTime = new ArrayList<>();
        Duration duration;

        for (int i = 0; i < size; i++) {
            duration = Duration.ofMinutes(-10000000 + (int) (Math.random() * 20000000));
            dateTime.add(LocalDateTime.now().plus(duration));
        }
        return dateTime;
    }

    public static String getHEX() {
        System.out.println("Введите цвет в HEX формате. Пример: #FB12F2");
        String str = UtilsScanner.getStringConsole();
        while (!str.matches("^#[0-9,A-F]{6}$")) {
            System.out.println("Вы ввели не верно, попробуйте снова \n" +
                    "Введите цвет в HEX формате. Пример: #FB12F2");
            str = UtilsScanner.getStringConsole();
        }
        return str;
    }

    public static LocalDate getDateFromInput() {
        LocalDate date;
        System.out.println("Введите дату в формате 12.03.2001");
        String str = UtilsScanner.getStringConsole();
        date = thisDateCorrected(str);

        while (!str.matches("^(\\d{2})\\.(\\d{2})\\.(\\d{4})$") || date == null) {
            System.out.println("Неверно! \n" +
                    "Введите дату в формате 12.03.2001");

            str = UtilsScanner.getStringConsole();
            date = thisDateCorrected(str);
        }
        return date;
    }

    private static LocalDate thisDateCorrected(String str) {
        LocalDate date;
        Matcher matcher = Pattern.compile("^(\\d{2})\\.(\\d{2})\\.(\\d{4})$").matcher(str);
        matcher.find();

        try {
            date = LocalDate.of(Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(1)));
        } catch (DateTimeException e) {
            System.out.print("Такой даты увы не существует! ");
            return null;
        } catch (IllegalStateException e) {
            return null;
        }
        return date;
    }

}
