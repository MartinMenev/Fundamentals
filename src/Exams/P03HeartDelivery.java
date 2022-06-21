package Exams;

import java.util.Scanner;
import java.util.Arrays;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] houses = Arrays
         .stream(scanner.nextLine().split("@"))
         .mapToInt(e -> Integer.parseInt(e)).toArray();

        String jump = scanner.nextLine();
        int position = 0;
        int countFailed = 0;
        while (!jump.equals("Love!")) {
            int currentJump = Integer.parseInt(jump.split(" ") [1]);
            position += currentJump;
            if (position > houses.length -1) {
                position = 0;
            }
            if (houses[position] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", position);
            } else {
                houses [position] -= 2;
                if (houses [position] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", position);
                }
            }
            jump = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", position);
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] > 0) {
                countFailed++;
            }
        }
        if (countFailed == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", countFailed);
        }
    }
}
