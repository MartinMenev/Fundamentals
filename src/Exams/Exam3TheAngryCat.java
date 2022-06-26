package Exams;

import java.util.Scanner;
import java.util.Arrays;

public class Exam3TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] items = Arrays
         .stream(scanner.nextLine().split(", "))
         .mapToInt(e -> Integer.parseInt(e)).toArray();

        int entryPoint = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        int sumLeft = 0;
        int sumRight = 0;

        if (type.equals("cheap")) {
            for (int i = 0; i < entryPoint; i++) {
                if (items [i] < items [entryPoint]) {
                    sumLeft += items [i];
                }
            }
            for (int i = entryPoint + 1; i < items.length ; i++) {
                if (items [i] < items [entryPoint]) {
                    sumRight += items [i];
                }
            }
        } else if (type.equals("expensive")) {
            for (int i = 0; i < entryPoint; i++) {
                if (items [i] >= items [entryPoint]) {
                    sumLeft += items [i];
                }
            }
            for (int i = entryPoint + 1; i < items.length ; i++) {
                if (items [i] >= items [entryPoint]) {
                    sumRight += items [i];
                }
            }
        }
        if (sumLeft >= sumRight) {
            System.out.printf("Left - %d", sumLeft);
        } else {
            System.out.printf("Right - %d", sumRight);
        }
    }
}
