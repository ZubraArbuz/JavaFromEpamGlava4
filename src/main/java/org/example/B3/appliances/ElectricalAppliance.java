package org.example.B3.appliances;

public class ElectricalAppliance {
    private String name;
    private int power;
    private boolean isOn;

    public ElectricalAppliance(String name, int power) {
        this.name = name;
        this.power = power;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public boolean isOn() {
        return isOn;
    }

    public void plugIn() {
        isOn = true;
    }

    public void plugOut() {
        isOn = false;
    }

    @Override
    public String toString() {
        return name + " (мощность: " + power + " Вт, включен: " + (isOn ? "да" : "нет") + ")";
    }


}
