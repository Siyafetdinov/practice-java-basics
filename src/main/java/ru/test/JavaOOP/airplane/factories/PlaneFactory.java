package ru.test.JavaOOP.airplane.factories;

import ru.test.JavaOOP.airplane.logic.Plane;

import java.util.List;

public class PlaneFactory {
    public static Plane getNewPlaneOfCompany(String nameCompany) {
        List<Plane> plane = List.of(
                new CargoFactory().createPlane(nameCompany),
                new MilitaryFactory().createPlane(nameCompany),
                new PassengerFactory().createPlane(nameCompany));
        return plane.get((int) (Math.random() * plane.size()));
    }
}
