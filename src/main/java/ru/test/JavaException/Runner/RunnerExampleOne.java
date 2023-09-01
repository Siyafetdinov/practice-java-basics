package ru.test.JavaException.Runner;

import ru.test.JavaException.Utils.UtilsJavaException;
import ru.test.JavaOOP.airplane.planes.PassengerPlane;
import ru.test.Utils.UtilsScanner;


public class RunnerExampleOne {

    public static void main(String[] args) {
        int flyDistance;
        int cargo;
        int passengerCapacity;

        System.out.println("Введите параметр 'Дальность полета'");
        flyDistance = UtilsJavaException.getIntValueExampleOne(UtilsScanner.getStringConsole(), "Дальность полета");

        System.out.println("Введите параметр 'Грузоподъемность'");
        cargo = UtilsJavaException.getIntValueExampleOne(UtilsScanner.getStringConsole(), "Грузоподъемность");

        System.out.println("Введите параметр 'Пассажировместимость'");
        passengerCapacity = UtilsJavaException.getIntValueExampleOne(UtilsScanner.getStringConsole(), "Пассажировместимость");

        PassengerPlane plane = new PassengerPlane("A330", "Airbus", "Passenger", flyDistance, cargo, 989898, passengerCapacity);

        System.out.println(plane);
    }
}
