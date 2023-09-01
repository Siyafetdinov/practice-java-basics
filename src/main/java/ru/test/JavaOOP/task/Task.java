package ru.test.JavaOOP.task;

import ru.test.JavaOOP.airplane.logic.Plane;
import ru.test.JavaOOP.company.Company;
import ru.test.JavaOOP.utils.UtilsJavaOOP;
import ru.test.Utils.UtilsMenu;
import ru.test.Utils.UtilsScanner;

import java.util.ArrayList;
import java.util.List;

public class Task {
    public static List<Company> bdCompany = new ArrayList<>();

    public static void startHandler() {
        bdCompany = UtilsJavaOOP.generateCompany(UtilsScanner.getIntFromInput(1, 10));
        mainMenu();
    }

    public static void mainMenu() {
        String menuItem[] = {
                "Вывести названия всех компаний и их самолеты",
                "Заполнить самолетами желаемую компаниию",
                "Заполнить самолетами все компаниии, в которых их 0",
                "Провести сортировку самолетов определенной компании по дальности полета",
                "Провести сортировку самолетов всех компаний",
                "Найти самолет в компании, соответствующий заданной грузоподъемности"};

        UtilsMenu.displayMenu("Колличество компаний: " + bdCompany.size(), menuItem, 1);
        mainMenuHandler(UtilsScanner.getIntFromInput());
    }

    public static void mainMenuHandler(int menuItem) {
        switch (menuItem) {
            case 1: {
                printAllCompany(bdCompany);

                UtilsMenu.exitMenu();
                mainMenu();
                break;
            }
            case 2: {
                UtilsMenu.displayMenu("Выберите какую компанию хотите заполнить самолетами", UtilsJavaOOP.getNameAllCompany(bdCompany), 0);
                fillAeroplanes(UtilsScanner.getIntFromInput(0, bdCompany.size()), bdCompany);

                UtilsMenu.exitMenu();
                mainMenu();
                break;
            }
            case 3: {
                fillAeroplanesEmptyCompany(bdCompany);

                UtilsMenu.exitMenu();
                mainMenu();
                break;
            }
            case 4: {
                UtilsMenu.displayMenu("Провести сортировку самолетов определенной компании по дальности полета\n" +
                        "Выберите id компании:", UtilsJavaOOP.getNameAllCompany(bdCompany), 0);

                makeSortingAirplanesCompany(UtilsScanner.getIntFromInput(0, bdCompany.size()), bdCompany);

                UtilsMenu.exitMenu();
                mainMenu();
                break;
            }
            case 5: {
                makeSortingAirplanesAllCompany(bdCompany);

                UtilsMenu.exitMenu();
                mainMenu();
                break;
            }
            case 6: {
                System.out.println("Введите поиск желаемого размера груза");
                searchPlanes(bdCompany, UtilsScanner.getIntFromInput(1, 999999999));

                UtilsMenu.exitMenu();
                mainMenu();
                break;
            }
            case 0: {
                System.out.println("exit!");
                break;
            }
            default: {
                System.out.println("Нет такого пункта");
                mainMenuHandler(UtilsScanner.getIntFromInput());

                UtilsMenu.exitMenu();
                mainMenu();
                break;
            }
        }
    }

    private static void printAllCompany(List<Company> bdCompany) {
        for (Company company : bdCompany) {
            if (company.getPlanes().isEmpty()) {
                System.out.println("Компания: " + company.getName() + " без самолетов!");
            } else {
                System.out.println(company.toString());
            }
        }
    }

    private static void fillAeroplanes(int item, List<Company> bdCompany) {
        if (bdCompany.get(item).getPlanes().isEmpty()) {
            System.out.println("В данной компании нет самолетов. " +
                    "Введите желаемое количество самолетов (min 1 | max 1000)");

            bdCompany.get(item).setPlanes(UtilsJavaOOP.generatePlane(UtilsScanner.getIntFromInput(1, 1000), bdCompany.get(item).getName()));
        } else {
            System.out.println("В данной компании уже есть самолеты." +
                    "Введите желаемое количество самолетов (min 1 | max 1000)");

            List<Plane> tmp = bdCompany.get(item).getPlanes();
            tmp.addAll(UtilsJavaOOP.generatePlane(UtilsScanner.getIntFromInput(1, 1000), bdCompany.get(item).getName()));

            bdCompany.get(item).setPlanes(tmp);
        }
    }

    private static void fillAeroplanesEmptyCompany(List<Company> bdCompany) {
        for (Company company : bdCompany) {
            if (company.getPlanes().isEmpty()) {
                company.setPlanes(UtilsJavaOOP.generatePlane((int) (Math.random() * 10), company.getName()));
                System.out.println("Компания: " + company.getName() + " была пустой, заполнили ее!");
            } else {
                System.out.println("В Компании: " + company.getName() + " была самолеты, мы ее не трогали!");
            }
        }
    }

    public static void makeSortingAirplanesCompany(int item, List<Company> bdCompany) {
        List<Plane> tmp = bdCompany.get(item).getPlanes();
        if (tmp.isEmpty()) {
            System.out.println("К сожалению нечего сортировать :(");
        } else {
            System.out.println("Список до: \n" + tmp.toString());
            UtilsJavaOOP.SortingByFlightLengthHandler(tmp);
            System.out.println(UtilsMenu.indent() + "\nСписок после: \n" + tmp.toString());
        }
    }

    private static void makeSortingAirplanesAllCompany(List<Company> bdCompany) {
        List<Plane> tmp = UtilsJavaOOP.sumPlaneAllCompany(bdCompany);

        if (tmp.isEmpty()) {
            System.out.println("Все компании без самолетов :(");
        } else {
            System.out.println("Список до: \n" + tmp.toString());
            UtilsJavaOOP.SortingByFlightLengthHandler(tmp);
            System.out.println(UtilsMenu.indent() + "\nСписок после: \n" + tmp.toString());
        }
    }

    private static void searchPlanes(List<Company> bdCompany, int cargo) {
        List<Plane> tmp = UtilsJavaOOP.sumPlaneAllCompany(bdCompany);
        List<Plane> result = new ArrayList<>();

        if (tmp.isEmpty()) {
            System.out.println("Все компании без самолетов :(");
        } else {
            // Поиск идеального совпадения
            for (Plane plane : tmp) {
                if (plane.getCargo() == cargo) {
                    result.add(plane);
                }
            }

            if (!result.isEmpty()) {
                System.out.println("Идеально совпадение \n" + result.toString());
            } else {
                System.out.println("Идеальных совпадений не нашлось! \nМогу вам придложить ближайшие самолеты к заданному значению грузоподъемности: " + cargo +
                        UtilsMenu.indent() + "\nБольше желаемого: " + UtilsJavaOOP.getResultIsMore(tmp, cargo).toString()  +
                        UtilsMenu.indent() + "\nМеньше желаемого: " + UtilsJavaOOP.getResultIsLess(tmp, cargo).toString() + UtilsMenu.indent());
            }
            System.out.println("Для проверки список всех самолетов:" + UtilsJavaOOP.SortingByCargo(tmp, false).toString());

        }
    }
}
