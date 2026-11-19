package com.dealership;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addVehicle(Vehicle newVehicle) {
        inventory.add(newVehicle);
    }

    public void removeVehicle(Vehicle toRemove) {
        inventory.remove(toRemove);
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public List<Vehicle> getVehicles(Predicate<Vehicle> tester) {
        return inventory.stream().filter(tester).collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean searchPrice(double min, double max, Vehicle v) {
        return v.getPrice().compareTo(BigDecimal.valueOf(min)) >= 0 && v.getPrice().compareTo(BigDecimal.valueOf(max)) <= 0;    
    }

    public boolean searchMakeModel(String make, String model, Vehicle v) {
        return v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model);
    }

    public boolean searchYear(int min, int max, Vehicle v) {
        return v.getYear() >= min && v.getYear() <= max;    
    }

    public boolean searchColor(String color, Vehicle v) {
        return v.getColor().equalsIgnoreCase(color);    
    }

    public boolean searchMileage(int min, int max, Vehicle v) {
        return v.getOdometer() >= min && v.getOdometer() <= max;    
    }

    public boolean searchType(String vehicleType, Vehicle v) {
        return v.getVehicleType().toLowerCase().contains(vehicleType.toLowerCase());
    }
}
