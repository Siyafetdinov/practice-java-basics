package ru.test.JavaOOP.airplane.planes;

import ru.test.JavaOOP.airplane.logic.Plane;

import java.util.Objects;

public class PassengerPlane extends Plane {
    private int numberOfPassengers;
    public PassengerPlane(String name, String nameCompany, String type, int flyDistance, int cargo, int price, int numberOfPassengers) {
        super(name, nameCompany, type, flyDistance, cargo, price);
        this.numberOfPassengers = numberOfPassengers;
    }
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }


    @Override
    public String toString() {
        return super.toString() + " | Колличество пассажиров: " + numberOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerPlane that = (PassengerPlane) o;
        return numberOfPassengers == that.numberOfPassengers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPassengers);
    }
}
