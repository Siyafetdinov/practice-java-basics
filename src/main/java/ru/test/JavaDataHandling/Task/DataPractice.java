package ru.test.JavaDataHandling.Task;

import ru.test.JavaDataHandling.Utils.UtilsJavaDataHandling;
import ru.test.Utils.UtilsMenu;
import ru.test.Utils.UtilsScanner;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class DataPractice {

    public static void menuTask() {
        String[] menuElements = {
                "По числу вернуть название месяца, соответствующего данному числу. Если исходное число вне диапазона 1-12, вернуть сообщение об ошибке.",
                "Найти все пятницы 13 в году.",
                "Найти последний день месяца переданной даты, вернуть строкой в формате Sunday Jan 31, 2021.",
                "В массиве LocalDateTime найти такую дату-время, которая наиболее удалена от текущего дня (в прошлом или будущем).",
                "Вычислить, сколько часов осталось от переданного времени до полуночи."
        };

        UtilsMenu.displayMenu("Выбери пункт меню:", menuElements, 1);

        menuTaskHandler(UtilsScanner.getIntFromInput());
    }


    private static void menuTaskHandler(int value) {
        switch (value) {
            case 1: {
                System.out.println(LocalDate.of(2023, UtilsScanner.getIntFromInput(1, 12), 1).getMonth());

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }
            case 2: {
                LocalDate date = LocalDate.of(UtilsScanner.getIntFromInput(2000, 2100), Month.JANUARY, 13);
                List<LocalDate> result = UtilsJavaDataHandling.getFridayTheThirteenth(date);

                if (result.isEmpty()) {
                    System.out.println("Ничего не нашлось!");
                } else {
                    System.out.println(result);
                }

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }
            case 3: {
                DateTimeFormatter pattern = DateTimeFormatter.ofPattern("EEEE MMM dd, yyyy");
                System.out.println(pattern.format(UtilsJavaDataHandling.getDateFromInput()));

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }
            case 4: {
                getDateTime(UtilsJavaDataHandling.getRandomDateTime(10));

                UtilsMenu.exitMenu();
                menuTask();
                break;
            }
            case 5: {
                System.out.println("Осталось до полуночи: " + getDuration() + " часов");

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

    private static int getDuration(){
        System.out.println("Сначала введите часы (0-23), потом минуты (0-59)!");
        LocalDateTime timeOne = LocalDateTime.of(LocalDate.now(),
                LocalTime.of(UtilsScanner.getIntFromInput(0, 23), UtilsScanner.getIntFromInput(0, 59)));
        LocalDateTime timeTwo = LocalDateTime.of(LocalDate.from(timeOne.plusDays(1)), LocalTime.MIDNIGHT);

        System.out.println("Для тестов [timeOne]: " + timeOne);
        System.out.println("Для тестов [timeTwo]: " + timeTwo);

        Duration duration = Duration.between(timeOne, timeTwo);

        return Integer.parseInt(String.valueOf(duration.toHours()));
    }

    private static void getDateTimePractice(List<LocalDateTime> dateTime){
        // код нигде не учавствует, было интересно как работает thenComparing()
        dateTime.sort(Comparator.comparing(LocalDateTime::getYear)
                .thenComparing(LocalDateTime::getDayOfMonth)
                .thenComparing(LocalDateTime::getMonth)
                .thenComparing(LocalDateTime::getHour)
                .thenComparing(LocalDateTime::getMinute)
                .thenComparing(LocalDateTime::getSecond));
    }

    private static void getDateTime(List<LocalDateTime> dateTime){
        Duration duration;
        LocalDateTime tmpDateTime = LocalDateTime.now();
        LocalDateTime result = null;
        long seconds = 0;

        for (LocalDateTime date : dateTime) {
            duration = Duration.between(tmpDateTime, date);
            System.out.println("Для тестов" + duration.getSeconds() + "(сек) | " + date);

            if (seconds < Math.abs(duration.getSeconds())){
                result = date;
                seconds = Math.abs(duration.getSeconds());
            }
        }
        System.out.println("\nСамая дальная дата с момента запуска: " + result);
        System.out.println("Она отдалена на: " + seconds + " cекунд");
    }
}
