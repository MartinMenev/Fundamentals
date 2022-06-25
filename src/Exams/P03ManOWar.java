package Exams;

import java.util.Scanner;
import java.util.Arrays;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] piratShip = Arrays
                .stream(scanner.nextLine().split(">"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int[] warship = Arrays
                .stream(scanner.nextLine().split(">"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int sumPirateShip = 0;
        int sumWarShip = 0;
        boolean isStalemate = true;

        while (!input.equals("Retire")) {
            if (input.contains("Fire")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int damage = Integer.parseInt(input.split(" ")[2]);
                if (index >= 0 && index <= warship.length - 1) {
                    warship[index] -= damage;
                    if (warship[index] <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        isStalemate = false;
                        break;
                    }
                }

            } else if (input.contains("Defend")) {
                int startIndex = Integer.parseInt(input.split(" ")[1]);
                int endIndex = Integer.parseInt(input.split(" ")[2]);
                int damage = Integer.parseInt(input.split(" ")[3]);
                if (startIndex >= 0 && startIndex <= piratShip.length - 1 && endIndex >= 0 && endIndex <= piratShip.length - 1) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        piratShip[i] -= damage;
                        if (piratShip[i] <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            isStalemate = false;
                            break;
                        }
                    }
                }

            } else if (input.contains("Repair")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int health = Integer.parseInt(input.split(" ")[2]);
                if (index >= 0 && index <= piratShip.length - 1) {
                    piratShip[index] += health;
                    if (piratShip[index] > maxHealthCapacity) {
                        piratShip[index] = maxHealthCapacity;
                    }
                }
            } else if (input.contains("Status")) {
                int count = 0;
                for (int i = 0; i < piratShip.length; i++) {
                    double limit = maxHealthCapacity * 0.2;
                    if (piratShip[i] < limit) {
                        count++;
                    }
                }
                System.out.printf("%d sections need repair.%n", count);
            }

            input = scanner.nextLine();
        }
        if (isStalemate) {
            for (int item : piratShip) {
                sumPirateShip += item;
            }
            for (int item : warship) {
                sumWarShip += item;
            }
            System.out.printf("Pirate ship status: %d%nWarship status: %d%n", sumPirateShip, sumWarShip);
        }
    }
}
