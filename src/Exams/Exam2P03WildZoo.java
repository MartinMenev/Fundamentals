package Exams;

import java.util.*;

public class Exam2P03WildZoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> animals = new LinkedHashMap<>();
        Map<String, Integer> areas = new LinkedHashMap<>();

        while (!input.equals("EndDay")) {
            String[] currentCommand = input.split(": ");
            String command = currentCommand[0];
            String name = currentCommand[1].split("-")[0];
            String food = currentCommand[1].split("-")[1];

            switch (command) {
                case "Add":
                    String area = currentCommand[1].split("-")[2];
                    if (!animals.containsKey(name)) {
                        animals.put(name, new ArrayList<>());
                        animals.get(name).add(0, ""+0);
                        animals.get(name).add(1, ""+0);
                    }
                    animals.get(name).set(0, ""+ (Integer.parseInt(animals.get(name).get(0)) + Integer.parseInt(food)));
                    animals.get(name).set(1, area);
                    break;

                case "Feed":
                    if (animals.containsKey(name)) {
                        animals.get(name).set(0, ""+(Integer.parseInt(animals.get(name).get(0)) - Integer.parseInt(food)));
                        if (Integer.parseInt(animals.get(name).get(0)) <= 0) {
                            System.out.printf("%s was successfully fed%n", name);
                            animals.remove(name);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : animals.entrySet()) {
            String currentArea = entry.getValue().get(1);
            if (!areas.containsKey(currentArea)) {
                areas.put(currentArea, 0);
            }
            areas.put(currentArea, areas.get(currentArea) +1);
        }

        System.out.println("Animals:");
        for (Map.Entry<String, List<String>> entry : animals.entrySet()) {
            System.out.printf(" %s -> %sg%n", entry.getKey(), entry.getValue().get(0));
        }
        System.out.println("Areas with hungry animals:");
        for (Map.Entry<String, Integer> entry : areas.entrySet()) {
            System.out.printf(" %s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
