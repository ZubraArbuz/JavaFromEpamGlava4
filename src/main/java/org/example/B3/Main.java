package org.example.B3;

import org.example.B3.appliances.Fridge;
import org.example.B3.appliances.TV;
import org.example.B3.service.ApplianceService;

public class Main {
    public static void main(String[] args){
        ApplianceService service = new ApplianceService();

        service.addAppliance(new Fridge("Холодильник", 200));
        service.addAppliance(new TV("Телевизор", 150));

        service.getAllAppliances().get(0).plugIn();
        service.getAllAppliances().get(1).plugIn();

        System.out.println("Общая потребляемая мощность: " + service.calculateTotalPower() + "Вт");

        System.out.println("Приборы после сортировки: ");
        for(var appliance : service.sortByPower()){
            System.out.println(appliance);
        }

        System.out.println("Приборы в диапазоне 100-200 Вт:");
        for(var appliance: service.findByPowerRange(100,200)){
            System.out.println(appliance);
        }
    }
}
