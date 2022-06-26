package Exams;

import java.util.Scanner;

public class Exam1CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numberStudents = Integer.parseInt(scanner.nextLine());
        double packFlourPrice = Double.parseDouble(scanner.nextLine());
        double singleEggPrice = Double.parseDouble(scanner.nextLine());
        double singleApronPrice = Double.parseDouble(scanner.nextLine());

        double apronCost = singleApronPrice * (numberStudents + Math.ceil(0.20 * numberStudents));
        double eggsCost = singleEggPrice * 10 * numberStudents;
        int freePackage = numberStudents / 5;
        double flourCost = packFlourPrice * (numberStudents - freePackage);
        double totalCost = apronCost + eggsCost + flourCost;

        if (totalCost <= budget) {
            System.out.printf("Items purchased for %.2f$.", totalCost);
        } else {
            System.out.printf("%.2f$ more needed.", totalCost - budget);
        }
    }
}
