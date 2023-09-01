package ru.test.JavaOOP.airplane.logic;

public abstract class Plane {
    private String name;
    private String nameCompany;
    private String type;
    private int flyDistance;
    private int cargo;
    private int price;

    public Plane(String name, String nameCompany, String type, int flyDistance, int cargo, int passengerCapacity) {
        this.name = name;
        this.nameCompany = nameCompany;
        this.type = type;
        this.flyDistance = flyDistance;
        this.cargo = cargo;
        this.price = passengerCapacity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getFlyDistance() {
        return flyDistance;
    }
    public void setFlyDistance(int flyDistance) {
        this.flyDistance = flyDistance;
    }
    public int getCargo() {
        return cargo;
    }
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\nСамолет = " +
                "Имя: " + name +
                " | Компания: " + nameCompany +
                " | Тип Самолета: " + type +
                " | Дальность полета: " + flyDistance +
                " | Грузоподъемность: " + cargo +
                " | Стоимость: " + price;
    }
}
