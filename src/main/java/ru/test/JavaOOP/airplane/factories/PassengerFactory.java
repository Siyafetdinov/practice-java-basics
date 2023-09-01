package ru.test.JavaOOP.airplane.factories;

import ru.test.JavaOOP.airplane.interfaces.IPlane;
import ru.test.JavaOOP.airplane.logic.Plane;
import ru.test.JavaOOP.airplane.planes.PassengerPlane;

public class PassengerFactory implements IPlane {
    @Override
    public Plane createPlane(String nameCompany) {
        String[] names = {"AirbusA330", "AirbusA335", "Boeing770"};
        int[] distances = {10000, 20000, 34000};
        int[] numberOfPass = {500, 600, 1000};
        return new PassengerPlane(
                names[(int) (Math.random() * names.length)],
                nameCompany, "Passenger",
                distances[(int) (Math.random() * distances.length)],
                (int)(Math.random() * 1000) + 3000,
                (int) (Math.random() * 10000000) + 2000000,
                numberOfPass[(int) (Math.random() * numberOfPass.length)]);
    }
}
