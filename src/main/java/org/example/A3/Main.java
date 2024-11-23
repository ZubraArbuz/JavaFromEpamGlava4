package org.example.A3;

import java.util.Objects;

class Wing {
    private double length;

    public Wing(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wing wing = (Wing) o;
        return Double.compare(wing.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }

    @Override
    public String toString() {
        return "Крыло длиной " + length + " метров";
    }
}

class Chassis {
    private int wheels;

    public Chassis(int wheels) {
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chassis chassis = (Chassis) o;
        return wheels == chassis.wheels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wheels);
    }

    @Override
    public String toString() {
        return "Шасси с " + wheels + " колесами";
    }
}

class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Objects.equals(type, engine.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Двигатель типа " + type;
    }
}

class Airplane {
    private Wing wing;
    private Chassis chassis;
    private Engine engine;
    private String route;
    private String fly;

    public Airplane(Wing wing, Chassis chassis, Engine engine) {
        this.wing = wing;
        this.chassis = chassis;
        this.engine = engine;
    }

    public void setFly(String fly) {
        this.fly = fly;
    }

    public String setRoute(String route) {
        this.route = route;
        return route;
    }

    public void printFly() {
        System.out.println("Статус полета: " + (fly != null ? fly : "Самолет не летит."));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Objects.equals(wing, airplane.wing) &&
                Objects.equals(chassis, airplane.chassis) &&
                Objects.equals(engine, airplane.engine) &&
                Objects.equals(route, airplane.route) &&
                Objects.equals(fly, airplane.fly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wing, chassis, engine, route, fly);
    }

    @Override
    public String toString() {
        return "Самолет: " + wing + ", " + chassis + ", " + engine;
    }
}

public class Main {
    public static void printRoute(String route) {
        System.out.println("Маршрут самолета: " + (route != null ? route : "Маршрут не задан."));
    }

    public static void main(String[] args) {
        Wing wing = new Wing(25.0);
        Chassis chassis = new Chassis(12);
        Engine engine = new Engine("Турбореактивный");

        Airplane airplane = new Airplane(wing, chassis, engine);

        System.out.println(airplane);
        String Route1 = airplane.setRoute("Москва -> Санкт-Петербург");
        printRoute(Route1);
        airplane.setFly("Летит");
        airplane.printFly();
    }


}
