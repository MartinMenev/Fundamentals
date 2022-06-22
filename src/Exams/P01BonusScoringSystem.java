package Exams;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nStudents = Integer.parseInt(scanner.nextLine());
        int totalNumberLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonusPoints = 0;
        int attendedLectures = 0;
        for (int i = 1; i <= nStudents; i++) {
            int countAttendancesPerStudent = Integer.parseInt(scanner.nextLine());

          double totalBonus = countAttendancesPerStudent * 1.0 / totalNumberLectures * (5 + additionalBonus);
            if (totalBonus > maxBonusPoints) {
                maxBonusPoints = totalBonus;
                attendedLectures = countAttendancesPerStudent;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonusPoints));
        System.out.printf("The student has attended %d lectures.", attendedLectures);
    }
}
