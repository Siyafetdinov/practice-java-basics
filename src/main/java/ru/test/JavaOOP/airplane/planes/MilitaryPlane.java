package ru.test.JavaOOP.airplane.planes;

import ru.test.JavaOOP.airplane.logic.Plane;

import java.util.Objects;

public class MilitaryPlane extends Plane {
    private String camouflage;
    public MilitaryPlane(String name, String nameCompany, String type, int flyDistance, int cargo, int price, String camouflage) {
        super(name, nameCompany, type, flyDistance, cargo, price);
        this.camouflage = camouflage;
    }
    public String getCamouflage() {
        return camouflage;
    }
    public void setCamouflage(String camouflage) {
        this.camouflage = camouflage;
    }

    @Override
    public String toString() {
        return super.toString() + " | Каммуфляж: " + camouflage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return Objects.equals(camouflage, that.camouflage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(camouflage);
    }
}
