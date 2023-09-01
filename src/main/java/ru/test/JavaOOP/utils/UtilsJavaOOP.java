package ru.test.JavaOOP.utils;

import ru.test.JavaOOP.airplane.logic.Plane;
import ru.test.JavaOOP.company.Company;
import ru.test.JavaOOP.airplane.factories.PlaneFactory;
import ru.test.Utils.UtilsMenu;
import ru.test.Utils.UtilsScanner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UtilsJavaOOP {

    public static void printPlaneCompany(List<Plane> bdList) {
        for (Plane plane : bdList) {
            System.out.println(plane.toString());
        }
    }

    public static List<Company> generateCompany(int countCompany){
        List<Company> tmp = new ArrayList<>();

        UtilsMenu.displayMenu("Как задать название компаний?", new String[]{"Задать автоматически", "Задать названия вручную"}, 1);
        switch (UtilsScanner.getIntFromInput(1, 2)) {
            case 1: {
                for (int i = 0; i < countCompany; i++) {
                    tmp.add(new Company("Аэрофлот " + (i + 1), new ArrayList<Plane>()));
                }
                break;
            }
            case 2: {
                for (int i = 0; i < countCompany; i++) {
                    System.out.println("Введи название компании: " + (i + 1));
                    tmp.add(new Company(UtilsScanner.getStringConsole(), new ArrayList<Plane>()));
                }
                break;
            }
        }

        return tmp;
    }

    public static List<Plane> generatePlane(int size, String nameCompany) {
        List<Plane> tmp = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tmp.add(PlaneFactory.getNewPlaneOfCompany(nameCompany));
        }
        return tmp;
    }

    public static String[] getNameAllCompany(List<Company> bdCompany) {
        String[] menuText = new String[bdCompany.size()];
        for (int i = 0; i < bdCompany.size(); i++) {
            menuText[i] = bdCompany.get(i).getName();
        }
        return menuText;
    }

    public static List<Plane> SortingByFlightLengthHandler(List<Plane> bdPlane) {
        bdPlane.sort(Comparator.comparing(Plane::getFlyDistance).reversed());
        return bdPlane;
    }

    public static List<Plane> sumPlaneAllCompany(List<Company> bdCompany) {
        List<Plane> tmp = new ArrayList<>();
        for (Company company : bdCompany) {
            List<Plane> tmp1 = company.getPlanes();
            tmp.addAll(tmp1);
        }
        return tmp;
    }

    public static List<Plane> SortingByCargo(List<Plane> bdPlane, boolean isReversed) {
        if (isReversed) {
            bdPlane.sort(Comparator.comparing(Plane::getCargo).reversed());
        } else {
            bdPlane.sort(Comparator.comparing(Plane::getCargo));
        }
        return bdPlane;
    }

    public static List<Plane> getResultIsMore(List<Plane> bdPlane, int searchCargo){

        List<Plane> tmp = SortingByCargo(bdPlane, false);
        // Узнать - хорошо(в практие) ли так делать?
        // bdPlane = SortingByCargo(bdPlane, false);

        List<Plane> result = new ArrayList<>();

        for (Plane plane : tmp) {
            // Проверка на уже найденные значения (если у двух самолетов одинаковое значение)
            if (!result.isEmpty()) {
                if (result.get(0).getCargo() == plane.getCargo()) {
                    result.add(plane);
                } else {
                    break;
                }
            }

            // Поиск первого значения, которое БОЛЬШЕ того что ищем
            // Среди сортированного списка (от меньшего к большему)
            if (searchCargo < plane.getCargo()) {
                result.add(plane);
            }
        }
        return result;
    }

    public static List<Plane> getResultIsLess(List<Plane> bdPlane, int searchCargo){

        List<Plane> tmp = SortingByCargo(bdPlane, true);
        List<Plane> result = new ArrayList<>();

        for (Plane plane : tmp) {
            // Проверка на уже найденные значения (если у двух самолетов одинаковое значение)
            if (!result.isEmpty()) {
                if (result.get(0).getCargo() == plane.getCargo()) {
                    result.add(plane);
                } else {
                    break;
                }
            }

            // Поиск первого значения, которое МЕНЬШЕ того что ищем
            // Среди сортированного списка (от большего к меньшему)
            if (searchCargo > plane.getCargo()) {
                result.add(plane);
            }
        }
        return result;
    }
}
