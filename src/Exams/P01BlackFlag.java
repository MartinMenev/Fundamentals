package Exams;

import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayOfPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double totalPlunder = 0;

        for (int day = 1; day <= dayOfPlunder; day++) {
            totalPlunder += dailyPlunder;
            if (day % 3 == 0) {
                totalPlunder += 0.5 * dailyPlunder;
            }
            if (day % 5 == 0) {
                totalPlunder -= 0.3 * totalPlunder;
            }
        }
        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", totalPlunder /expectedPlunder * 100);
        }
    }
}
