package Exams;

import java.util.Scanner;
import java.util.Arrays;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberWaitingPeople = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean enoughSpace = false;
        boolean fullSpaceAndNoMoreWaiting = false;

        for (int i = 0; i < lift.length; i++) {
            int freeSpace = 0;
            if (i != lift.length - 1) {
                if (lift[i] < 4) {
                    freeSpace = 4 - lift[i];
                    if (numberWaitingPeople > freeSpace) {
                        numberWaitingPeople -= freeSpace;
                        lift[i] += freeSpace;
                    } else {
                        lift[i] += numberWaitingPeople;
                        enoughSpace = true; // no more people waiting but some free space
                        break;
                    }
                }
            } else {
                if (lift[i] < 4) {
                    freeSpace = 4 - lift[i];
                    if (numberWaitingPeople > freeSpace) {
                        numberWaitingPeople -= freeSpace;
                        lift[i] += freeSpace;
                    } else if (numberWaitingPeople < freeSpace) {
                        lift [i] += numberWaitingPeople;
                        enoughSpace = true;
                        break;
                    } else {
                        lift[i] += numberWaitingPeople;
                        fullSpaceAndNoMoreWaiting = true; // no more people waiting and NO MORE SPACE!
                        break;
                    }
                }
            }
        }

        if (enoughSpace) {
            System.out.println("The lift has empty spots!");
            for (int item : lift) {
                System.out.print(item + " ");
            }
        } else if (fullSpaceAndNoMoreWaiting) {
            for (int item : lift) {
                System.out.print(item + " ");
            }
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", numberWaitingPeople);
            for (int item : lift) {
                System.out.print(item + " ");
            }
        }
    }
}
