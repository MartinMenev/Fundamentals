package Exams;

import java.util.Scanner;

public class Exam2P01StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Change":
                    String char1 = command[1];
                    String replacement = command[2];
                    for (Character symbol : text.toCharArray()) {
                        text = text.replace (char1, replacement);
                    }
                    System.out.println(text);
                    break;

                case "Includes":
                    String substring = command[1];
                    if (text.contains(substring)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "End":
                    substring = command[1];
                    int substringLength = substring.length();
                    int isFound = text.length() - substringLength;
                    if (isFound == text.lastIndexOf(substring)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;

                case "FindIndex":
                    char1 = command[1];
                    int index = text.indexOf(char1);
                    System.out.println(index);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(command[1]);
                    int count = Integer.parseInt(command[2]);
                    text = text.substring(startIndex, startIndex + count);
                    System.out.println(text);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
