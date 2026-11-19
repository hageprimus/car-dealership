package com.pluralsight;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final String MAIN_MENU = """
            Enter an option:
            0 - Display all vehicles.
            1 - Display vehicles by a given price range.
            2 - Display vehicles by make and model.
            3 - Display vehicles by year.
            4 - Display vehicles by color.
            5 - Display vehicles by mileage.
            6 - Display vehicles by type.
            7 - EXIT
            """;

    private static Dealership dealership;
    private UserInterface(){}

    public static void display() throws FileNotFoundException {
        init();
        Scanner s = new Scanner(System.in);
        boolean complete = false;
        do {
            String userInput = getInputFromConsole(MAIN_MENU, s);
            int command = Integer.parseInt(userInput);
            switch (command) {
                case 0 -> displayVehicles(dealership.getVehicles(v -> true));
                case 1 -> {
                    double min = Double.parseDouble(getInputFromConsole("Enter the low end of the price range to search.", s));
                    double max = Double.parseDouble(getInputFromConsole("Enter the high end of the price range to search.", s));
                    displayVehicles(dealership.getVehicles(v -> dealership.searchPrice(min, max, v)));
                }
                case 2 -> {
                    String make = getInputFromConsole("Enter the make (manufacturer) of the vehicle to search.", s);
                    String model = getInputFromConsole("Enter the model type to search.", s);
                    displayVehicles(dealership.getVehicles(v -> dealership.searchMakeModel(make, model, v)));
                }
                case 3 -> {
                    int min = Integer.parseInt(getInputFromConsole("Enter the oldest year of the range to search.", s));
                    int max = Integer.parseInt(getInputFromConsole("Enter the most recent year of range to search.", s));
                    displayVehicles(dealership.getVehicles(v -> dealership.searchYear(min, max, v)));
                }
                case 4 -> {
                    String color = getInputFromConsole("Enter the color of vehicle to search.", s);
                    displayVehicles(dealership.getVehicles(v -> dealership.searchColor(color, v)));
                }
                case 5 -> {
                    int min = Integer.parseInt(getInputFromConsole("Enter the low end of the mileage range to search.", s));
                    int max = Integer.parseInt(getInputFromConsole("Enter the high end of the mileage range to search.", s));
                    displayVehicles(dealership.getVehicles(v -> dealership.searchMileage(min, max, v)));
                }
                case 6 -> {
                    String type = getInputFromConsole("Enter the type of vehicle to search for.", s);
                    displayVehicles(dealership.getVehicles(v -> dealership.searchType(type, v)));
                }
                case 7 -> {
                    System.out.println("Exiting program.");
                    complete = true;
                }
            }
        } while (!complete);
        s.close();
    }

    private static void init() throws FileNotFoundException {
        dealership = DealershipFileManager.getDealership();
    }

    private static void displayVehicles(List<Vehicle> display) {
        display.forEach(System.out::println);
    }

    private static String getInputFromConsole(String display, Scanner s) {
        System.out.println(display);
        return s.nextLine().trim();
    }
}
