package com.pluralsight;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final String MAIN_MENU = """
            Enter an option:
            1 - Display vehicles by a given price range.
            2 -
            """;

    private Dealership dealership;
    private UserInterface(){};

    public void display() throws FileNotFoundException {
        init();
        Scanner s = new Scanner(System.in);
        boolean complete = false;
        do {
            String userInput = getInputFromConsole(MAIN_MENU, s, false);
            int command = Integer.parseInt(userInput);
            switch (command) {
                case 1 -> {
                    double min = Integer.parseInt(getInputFromConsole("Enter the low end of the price range to search.", s, false));
                    double max = Integer.parseInt(getInputFromConsole("Enter the high end of the price range to search.", s, false));
                    displayVehicles(dealership.getVehicles(tester -> searchPrice(min, max)));
                }
            }
        } while (!complete);
        s.close();
    }

    private void init() throws FileNotFoundException {
        dealership = DealershipFileManager.getDealership();
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

    private static void displayVehicles(List<Vehicle> display) {
        for (Vehicle v : display) {
            System.out.println(v);
        }
    }

    private static String getInputFromConsole(String display, Scanner s, boolean clearBuffer) {
        if (clearBuffer) s.nextLine();
        System.out.println(display);
        return s.nextLine().trim();
    }
}
