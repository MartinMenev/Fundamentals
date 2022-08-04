package Exams;

import java.util.Scanner;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=n ; i++) {
            String input = scanner.nextLine();
            StringBuilder text = new StringBuilder(input);
            int firstPositionName = text.indexOf("@");
            int lastPositionName = text.indexOf("|");
            int firstPositionAge = text.indexOf("#");
            int lastPositionAge = text.indexOf("*");
            String name = text.substring(firstPositionName + 1, lastPositionName);
            String age = text.substring(firstPositionAge + 1, lastPositionAge);
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
