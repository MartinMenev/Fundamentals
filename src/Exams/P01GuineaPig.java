package Exams;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double qtyFood = Double.parseDouble(scanner.nextLine());
        double qtyHay = Double.parseDouble(scanner.nextLine());
        double qtyCover = Double.parseDouble(scanner.nextLine());
        double pigWeight = Double.parseDouble(scanner.nextLine());

        double excessFood = qtyFood * 1000;
        double excessHay = qtyHay * 1000;
        double excessCover = qtyCover * 1000;
        boolean isEnough = true;

        for (int i = 1; i <= 30; i++) {
            excessFood -= 300;

            if (i % 2 == 0) {
                excessHay -= excessFood * 0.05;
            }
            if (i % 3 == 0) {
                excessCover -= pigWeight * 1000 / 3;
            }
            if (excessFood <= 0 || excessCover <= 0 || excessHay <= 0) {
                isEnough = false;
                System.out.println("Merry must go to the pet store!");
                break;
            }
        }
        if (isEnough) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", excessFood / 1000, excessHay / 1000, excessCover / 1000 );
        }
    }
}