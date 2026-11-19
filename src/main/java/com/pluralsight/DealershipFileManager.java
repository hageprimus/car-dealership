package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    public static Dealership getDealership() throws FileNotFoundException {
        String name = "", address = "", phone = "";
        List<Vehicle> inventory = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
        try {
            String fileLine;
            int lineCount = 0;
            while ((fileLine = reader.readLine()) != null) {
                String[] tokens = fileLine.split("\\|");
                if (lineCount == 0) {
                    name = tokens[0];
                    address = tokens[1];
                    phone = tokens[2];
                } else {
                    int vin = Integer.parseInt(tokens[0]);
                    int year = Integer.parseInt(tokens[1]);
                    String make = tokens[2];
                    String model = tokens[3];
                    String vehicleType = tokens[4];
                    String color = tokens[5];
                    int odometer = Integer.parseInt(tokens[6]);
                    BigDecimal price = new BigDecimal(tokens[7]);
                    inventory.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                }
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        Dealership output = new Dealership(name, address, phone);
        output.setInventory(inventory);
        return output;
    }

    public static void saveDealership(Dealership toSave) throws IOException {
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv"));
        String header = String.format("%s|%s|%s", toSave.getName(), toSave.getAddress(), toSave.getPhone());
        bufWriter.write(header + "\n");
        for (Vehicle v : toSave.getVehicles(v -> true)) bufWriter.write(v.toCsv() + "\n");
        bufWriter.close();
    }
}
