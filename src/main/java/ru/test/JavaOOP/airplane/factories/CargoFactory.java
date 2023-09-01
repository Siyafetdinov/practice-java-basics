package ru.test.JavaOOP.airplane.factories;

import ru.test.JavaOOP.airplane.interfaces.IPlane;
import ru.test.JavaOOP.airplane.logic.Plane;
import ru.test.JavaOOP.airplane.planes.CargoPlane;

public class CargoFactory implements IPlane {
    @Override
    public Plane createPlane(String nameCompany) {
        String[] names = {"AirbusA330", "AirbusA335", "Boeing770", "NewBoeing"};
        int[] distances = {10000, 20000, 34000};
        int[] cargo = {5, 10, 20};
        int[] luggage = {10, 20, 40};
        return new CargoPlane(
                names[(int) (Math.random() * names.length)],
                nameCompany, "Cargo",
                distances[(int) (Math.random() * distances.length)],
                (int)(Math.random() * 1000) + 3000,
                (int) (Math.random() * 10000000) + 2000000,
                luggage[(int) (Math.random() * luggage.length)]);
    }
}
