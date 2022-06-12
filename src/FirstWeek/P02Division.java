package FirstWeek;

import java.util.Scanner;

public class P02Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int divisible = 0;
        boolean notDivisible = false;

        if (number % 10 == 0) {
            divisible = 10;
        } else if (number % 7 == 0) {
            divisible = 7;
        } else if (number % 6 == 0) {
            divisible = 6;
        } else if (number % 3 == 0) {
            divisible = 3;
        } else if (number % 2 == 0) {
            divisible = 2;
        } else {
            notDivisible = true;
        }
        if (notDivisible) {
            System.out.printf("Not divisible");
        } else {
            System.out.printf("The number is divisible by %d", divisible);
        }
    }
}
