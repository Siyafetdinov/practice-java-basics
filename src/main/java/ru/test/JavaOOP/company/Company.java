package ru.test.JavaOOP.company;

import ru.test.JavaOOP.airplane.logic.Plane;
import ru.test.Utils.UtilsMenu;

import java.util.List;

public class Company {
    private String name;
    private List<Plane> planes;

    public Company(String name, List<Plane> planes) {
        this.name = name;
        this.planes = planes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    @Override
    public String toString() {
        return "\nИмя компании: " + name +
                ", Самолеты:" + planes + UtilsMenu.indent();
    }
}
