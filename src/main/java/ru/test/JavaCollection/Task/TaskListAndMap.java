package ru.test.JavaCollection.Task;

import ru.test.JavaCollection.Utils.UtilsJavaCollection;
import ru.test.Utils.UtilsMenu;
import ru.test.Utils.UtilsScanner;

import java.time.Month;
import java.util.*;


public class TaskListAndMap {
    public static void menuTask() {

        String[] menuCase = {
                "Сгенерируйте список из целых чисел от 1 до Х включительно.",
                "Удалите дубликаты из коллекции.",
                "Создайте новый список, используя только элементы, стоящие на нечетных позициях оригинального списка.",
                "В списке строк подсчитайте строки, состоящие только из уникальных символов, игнорируя пустые строки.",
                "Отсортируйте список строк по длине по убыванию.",
                "Проверьте что в списке чисел нет отрицательных значений.",
                "Сгенерируйте Map<Month, Integer>, в которой ключами будут элементы перечисления java.time.Month, а значениями — длина названия этого месяца. То есть результат должен быть такой: {MAY=3, SEPTEMBER=9, JUNE=4, APRIL=5, AUGUST=6, ...",
                "Создайте новую Map из исходной так, чтобы ключи и значения поменялись местами. При наличии одинаковых значений в исходной Map необходимо выбросить исключение IllegalArgumentException с описанием проблемы и дублирующегося ключа.",
                "Трансформируйте List<Map<String, String>> в список всех значений, которые используются в этих Map, сортировать по длине, затем по алфавиту."
        };


        UtilsMenu.displayMenu("Выберите пункт меню:", menuCase, 1);
        menuHandler(UtilsScanner.getIntFromInput());
    }

    private static void menuHandler(int value) {
        switch (value) {
            case 1: {
                System.out.println("Результат: " +
                        UtilsJavaCollection.getRandomIntList(1, UtilsScanner.getIntFromInput(2, Integer.MAX_VALUE-1)));
                break;
            }
            case 2: {
                List<Integer> newList = UtilsJavaCollection.getRandomIntList(0, 10);
                Set<Integer> set = new LinkedHashSet<>(newList);
                System.out.println("До: " + newList +
                        "\nПосле: " + set);
                break;
            }
            case 3: {
                List<Integer> newList = UtilsJavaCollection.getRandomIntList(0, 10);
                List<Integer> result = new ArrayList<>();
                for (int i = 0; i < newList.size(); i++) {
                    if ((i % 2) == 0) {
                        result.add(newList.get(i));
                    }
                }
                System.out.println("До: " + newList +
                        "\nПосле: " + result);
                break;
            }
            case 4: {
                List<String> newList = new ArrayList<>(Arrays.asList("Hello", "Hi", "", " ", "Aa", "AA", "Ab", "aA", "11", "12"));
                List<String> result = new ArrayList<>();
                Set sets = new LinkedHashSet<>();

                newList.removeIf(s -> s.matches("^(\\s+)*"));

                for (String str : newList) {
                    if (!sets.isEmpty()) {
                        sets.clear();
                    }
                    // Это мне, для изучения на потом (выполняет все тоже самое, что и в методе getCharacterArray)
                    //List<Character> list = str.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
                    sets.addAll(List.of(UtilsJavaCollection.getCharacterArray(str)));
                    if (str.length() == sets.size()) {
                        result.add(str);
                    }
                }
                System.out.println(result);
                break;
            }
            case 5: {
                List<String> newList = new ArrayList<>(Arrays.asList("Максим", "Яна", "     ", " ", "", "Анатолий", "Авадакедавра"));
                newList.removeIf(s -> s.matches("^(\\s+)*"));
                newList.sort(Comparator.comparing(String::length).reversed());
                System.out.println(newList);
                break;
            }
            case 6: {
                List<Integer> newList = UtilsJavaCollection.getRandomIntList(0, 10);
                System.out.println("задали массив! " + newList);
                int sizeOldList = newList.size();
                newList.removeIf(i -> i < 0);

                if (sizeOldList == newList.size()) {
                    System.out.println("В листе нет отрицателных значений!");
                } else {
                    System.out.println("В листе присуствуют отрицательные значения!");
                }
                break;
            }

            case 7: {
                Map<Month, Integer> newMap = new HashMap<>();
                for (int i = 1; i <= 12; i++) {
                    newMap.put(Month.of(i), String.valueOf(Month.of(i)).length());
                }
                System.out.println(newMap);
                break;
            }

            case 8: {
                Map<String, Integer> newMap = new HashMap<>() {{
                    put("aaa", 1);
                    put("bbb", 2);
                    put("ccc", 3);
                    put("ddd", 3);
                }};
                Map<Integer, String> resultMap = new HashMap<>();

                for (var entry : newMap.entrySet()) {
                    if (resultMap.containsKey(entry.getValue())) {
                        throw new IllegalArgumentException("Ключ " + entry.getValue() + " уже усуществует");
                    } else {
                        resultMap.put(entry.getValue(), entry.getKey());
                    }
                }
                System.out.println("Первая мапа: " + newMap + "Вторая мапа " + resultMap);
                break;
            }
            case 9: {
                List<String> result = UtilsJavaCollection.getNewList(UtilsJavaCollection.getNewListAndMap());
                result.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
                System.out.println("Результат: " + result);
                break;
            }
        }
    }
}
