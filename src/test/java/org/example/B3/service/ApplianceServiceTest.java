package org.example.B3.service;

import org.example.B3.appliances.ElectricalAppliance;
import org.example.B3.appliances.Fridge;
import org.example.B3.appliances.TV;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


class ApplianceServiceTest {

    private ApplianceService service;

    @BeforeEach
    void setUp() {
        service = new ApplianceService();
        service.addAppliance(new Fridge("Fridge", 200));
        service.addAppliance(new TV("TV",150));
    }

    @Test
    void testAddAppliance() {
        ElectricalAppliance tv = new Fridge("Samsung", 100);
        service.addAppliance(tv);

        List<ElectricalAppliance> appliances = service.getAllAppliances();
        assertTrue(appliances.contains(tv));
        assertEquals(3, appliances.size());
    }

    @Test
    void testGetAllAppliances() {
        List<ElectricalAppliance> appliances = service.getAllAppliances();
        assertEquals(2, appliances.size());
    }

    @Test
    void testCalculateTotalPower() {
        service.getAllAppliances().get(0).plugIn(); // Включаем первый прибор
        service.getAllAppliances().get(1).plugIn(); // Включаем второй прибор

        int totalPower = service.calculateTotalPower();
        assertEquals(350, totalPower);
    }

    @Test
    void testFindByPowerRange() {
        List<ElectricalAppliance> result = service.findByPowerRange(100, 200);
        assertEquals(2, result.size());
    }

    @Test
    void testSortByPower() {
        service.sortByPower();
        List<ElectricalAppliance> appliances = service.getAllAppliances();

        assertEquals("Fridge", appliances.get(1).getName());
    }

}