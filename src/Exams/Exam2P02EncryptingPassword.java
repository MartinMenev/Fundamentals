package Exams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam2P02EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^(.*)>(?<password>\\d{3}\\|[a-z]{3}\\|[A-Z]{3}\\|[^<>]{3})<\\1$");
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String nextInput = scanner.nextLine();
            Matcher matcher = pattern.matcher(nextInput);
            if (matcher.find()) {
                String[] text = matcher.group("password").split("\\|");
                StringBuilder buildingPassword = new StringBuilder();

                for (String element : text) {
                    buildingPassword.append(element);
                }
                System.out.println("Password: " + buildingPassword);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
