package Exams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCars = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Integer>> cars = new LinkedHashMap<>();

        for (int i = 1; i <= numberCars; i++) {
            String[] carProperties = scanner.nextLine().split("\\|");
            String car = carProperties[0];
            int mileage = Integer.parseInt(carProperties[1]);
            int fuel = Integer.parseInt(carProperties[2]);
            cars.put(car, new ArrayList<>());
            cars.get(car).add(mileage);
            cars.get(car).add(fuel);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] command = input.split(" : ");
            String givenCar = command[1];

            switch (command[0]) {
                case "Drive":
                    int distance = Integer.parseInt(command[2]);
                    int fuel = Integer.parseInt(command[3]);
                    if (cars.get(givenCar).get(1) < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        cars.get(givenCar).set(0, cars.get(givenCar).get(0) + distance);
                        cars.get(givenCar).set(1, cars.get(givenCar).get(1) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", givenCar, distance, fuel);
                    }
                    if (cars.get(givenCar).get(0) >= 100000) {
                        System.out.printf("Time to sell the %s!%n", givenCar);
                        cars.remove(givenCar);
                    }
                    break;

                case "Refuel":
                    fuel = Integer.parseInt(command[2]);
                    if (fuel > (75 - cars.get(givenCar).get(1))) {
                        fuel = 75 - cars.get(givenCar).get(1);
                    }
                    cars.get(givenCar).set(1, cars.get(givenCar).get(1) + fuel);
                    System.out.printf("%s refueled with %d liters%n", givenCar, fuel);
                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(command[2]);
                    if (cars.get(givenCar).get(0) - kilometers < 10000) {
                        cars.get(givenCar).set(0, 10000);
                    } else {
                        cars.get(givenCar).set(0, cars.get(givenCar).get(0) - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", givenCar, kilometers);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, ArrayList<Integer>> entry : cars.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}
