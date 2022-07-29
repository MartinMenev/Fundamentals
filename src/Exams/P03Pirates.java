package Exams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String, ArrayList<Integer>> cities = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Sail")){
            String[] validInput = input.split("\\|\\|");
            String cityName = validInput[0];
            int population = Integer.parseInt(validInput[1]);
            int gold = Integer.parseInt(validInput[2]);

            if (!cities.containsKey(cityName)){
                cities.put(cityName, new ArrayList<>());
                cities.get(cityName).add(population);
                cities.get(cityName).add(gold);
            } else {
                cities.get(cityName).set(0, cities.get(cityName).get(0)+ population);
                cities.get(cityName).set(1, cities.get(cityName).get(1)+ gold);
            }
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String currentCommand = command.split("=>")[0];
            String town = command.split("=>")[1];

            if (currentCommand.equals("Plunder")) {
                int killedPeople = Integer.parseInt(command.split("=>") [2]);
                int stolenGold = Integer.parseInt(command.split("=>") [3]);
                cities.get(town).set(0, cities.get(town).get(0) - killedPeople);
                cities.get(town).set(1, cities.get(town).get(1) - stolenGold);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, stolenGold, killedPeople);
                if (cities.get(town).get(0) <= 0 || cities.get(town).get(1) <= 0) {
                    System.out.println(town + " has been wiped off the map!");
                    cities.remove(town);
                }

            } else if (currentCommand.equals("Prosper")) {
                int increasingGold = Integer.parseInt(command.split("=>")[2]);
                    if (increasingGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        cities.get(town).set(1, cities.get(town).get(1) + increasingGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", increasingGold, town, cities.get(town).get(1));
                    }
            }
            command = scanner.nextLine();
        }
        if (cities.size() == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            for (Map.Entry<String, ArrayList<Integer>> entry : cities.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }
        }
    }
}
