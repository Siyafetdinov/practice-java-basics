package ru.test.JavaOOP.airplane.factories;

import ru.test.JavaOOP.airplane.interfaces.IPlane;
import ru.test.JavaOOP.airplane.logic.Plane;
import ru.test.JavaOOP.airplane.planes.MilitaryPlane;

public class MilitaryFactory implements IPlane {
    @Override
    public Plane createPlane(String nameCompany) {
        String[] names = {"AirbusA330", "AirbusA335", "Boeing770"};
        int[] distances = {10000, 20000, 34000};
        return new MilitaryPlane(
                names[(int) (Math.random() * names.length)],
                nameCompany, "Military",
                distances[(int) (Math.random() * distances.length)],
                (int)(Math.random() * 1000) + 3000,
                (int) (Math.random() * 10000000) + 2000000,
                "Bear");
    }
}
