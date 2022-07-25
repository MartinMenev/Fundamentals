package Exams;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while(!input.equals("Generate")) {
            List<String> command = Arrays.stream(input.split(">>>"))
                    .collect(Collectors.toList());

            switch (command.get(0)) {
                case "Contains":
                    String substring = command.get(1);
                    if (!text.contains(substring)) {
                        System.out.println("Substring not found!");
                    } else {
                        System.out.printf("%s contains %s%n", text, substring);
                    }
                    break;
                case "Flip":
                    String type = command.get(1);
                    int startIndex = Integer.parseInt(command.get(2));
                    int endIndex = Integer.parseInt(command.get(3));
                    String currentSubstring = text.substring(startIndex, endIndex);
                    if (type.equals("Upper")) {
                        String changedSubstring = currentSubstring.toUpperCase();
                        text = text.replace(currentSubstring, changedSubstring);
                        System.out.println(text);
                    } else {
                        String changedSubstring = currentSubstring.toLowerCase();
                        text = text.replace(currentSubstring, changedSubstring);
                        System.out.println(text);
                    }
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(command.get(1));
                    endIndex = Integer.parseInt(command.get(2));
                    String currentString = text.substring(startIndex, endIndex);
                    text = text.replace(currentString, "");
                    System.out.println(text);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", text);
    }
}
