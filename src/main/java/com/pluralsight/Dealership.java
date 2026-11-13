package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehicles(Predicate<Vehicle> tester) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (tester.test(v))
                results.add(v);
        }
        return results;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public boolean searchPrice(double min, double max) {
        return true;    //TODO
    }

    public boolean searchMakeModel(String make, String model) {
        return true;    //TODO
    }

    public boolean searchYear(int min, int max) {
        return true;    //TODO
    }

    public boolean searchColor(String color) {
        return true;    //TODO
    }

    public boolean searchMileage(int min, int max) {
        return true;    //TODO
    }

    public boolean searchType(String vehicleType) {
        return true;    //TODO
    }

    public void addVehicle(Vehicle newVehicle) {
        inventory.add(newVehicle);
    }

    public void removeVehicle(Vehicle toRemove) {
        inventory.remove(toRemove);
    }
}
