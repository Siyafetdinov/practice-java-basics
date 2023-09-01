package ru.test.JavaOOP.airplane.planes;

import ru.test.JavaOOP.airplane.logic.Plane;

import java.util.Objects;

public class CargoPlane extends Plane {
    private int luggageSize;

    public CargoPlane(String name, String nameCompany, String type, int flyDistance, int cargo, int price, int luggageSize) {
        super(name, nameCompany, type, flyDistance, cargo, price);
        this.luggageSize = luggageSize;
    }

    public int getLuggageSize() {
        return luggageSize;
    }

    public void setLuggageSize(int luggageSize) {
        this.luggageSize = luggageSize;
    }

    @Override
    public String toString() {
        return super.toString() + " | Размер перевозимого груза: " + luggageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoPlane that = (CargoPlane) o;
        return luggageSize == that.luggageSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(luggageSize);
    }
}
