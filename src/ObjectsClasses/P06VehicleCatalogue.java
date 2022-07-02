package ObjectsClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class P06VehicleCatalogue {
    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicle (String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
            return this.type;
        }

        public String getModel() {
            return this.model;
        }

        public String getColor() {
            return this.color;
        }

        public int getHorsePower() {
            return this.horsePower;
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!input.equals("End")) {
            String[] command = input.split(" ");
            String type = command[0];
            String model = command[1];
            String color = command[2];
            int horsePower = Integer.parseInt(command[3]);
            Vehicle currentVehicle = new Vehicle(type, model, color, horsePower);
            vehicles.add(currentVehicle);
            input = scanner.nextLine();
        }

        String modelSearch = scanner.nextLine();
        double sumHorsePowerCars = 0;
        int countCars = 0;
        double sumHorsePowerTrucks = 0;
        int countTrucks = 0;


        while (!modelSearch.equals("Close the Catalogue")) {
            for (Vehicle item : vehicles) {
                if (item.getModel().equals(modelSearch)) {
                    String currentType = item.getType();
                    if (currentType.equals("car")) {
                        currentType = "Car";
                    } else {
                        currentType = "Truck";
                    }
                    System.out.printf("Type: %s%n", currentType);
                    System.out.printf("Model: %s%n", item.getModel());
                    System.out.printf("Color: %s%n", item.getColor());
                    System.out.printf("Horsepower: %s%n", item.getHorsePower());
            }

            }
            modelSearch = scanner.nextLine();
        }

        for (Vehicle item : vehicles) {
            if (item.getType().equals("car")) {
                sumHorsePowerCars += item.getHorsePower();
                countCars++;
            } else if (item.getType().equals("truck")) {
                sumHorsePowerTrucks += item.getHorsePower();
                countTrucks++;
            }
        }
        if (countTrucks == 0) {
            countTrucks = 1;
        }
        if (countCars == 0) {
            countCars = 1;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", sumHorsePowerCars / countCars);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", sumHorsePowerTrucks / countTrucks);
    }
}
