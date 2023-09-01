package ru.test.JavaException.Runner;

import ru.test.JavaException.Exception.ZeroException;
import ru.test.JavaException.Utils.UtilsJavaException;
import ru.test.JavaOOP.airplane.planes.PassengerPlane;
import ru.test.Utils.UtilsScanner;

public class RunnerExampleTwo {
    public static void main(String[] args) throws ZeroException {
        int flyDistance;
        int cargo;
        int passengerCapacity;

        System.out.println("Введите параметр 'Дальность полета'");
        flyDistance = UtilsJavaException.getIntValueExampleTwo(UtilsScanner.getStringConsole(), "Дальность полета");

        System.out.println("Введите параметр 'Грузоподъемность'");
        cargo = UtilsJavaException.getIntValueExampleTwo(UtilsScanner.getStringConsole(), "Грузоподъемность");

        System.out.println("Введите параметр 'Пассажировместимость'");
        passengerCapacity = UtilsJavaException.getIntValueExampleTwo(UtilsScanner.getStringConsole(), "Пассажировместимость");

        PassengerPlane plane = new PassengerPlane("A330", "Airbus", "Passenger", flyDistance, cargo, 989898, passengerCapacity);

        System.out.println(plane);
    }
}
