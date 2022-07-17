package Exams;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            if (command.contains("Add")) {
                int index = Integer.parseInt(command.split(" ")[1].split(":")[1]);
                String newStop = command.split(" ")[1].split(":")[2];
                if (index < input.length()) {
                    input.insert(index, newStop);
                }
                System.out.println(input);
            } else if (command.contains("Remove")) {
                int startIndex = Integer.parseInt(command.split(" ")[1].split(":")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[1].split(":")[2]);
                if (startIndex >= 0 && startIndex < input.length() && endIndex >= 0 && endIndex < input.length()) {
                    input.replace(startIndex, endIndex +1, "");
                }
                System.out.println(input);
            } else if (command.contains("Switch")) {
                String oldString = command.split(":")[1];
                String newString = command.split(":")[2];
                if (input.toString().contains(oldString)) {
                    String newInput = input.toString().replace(oldString, newString);
                    input.setLength(0);
                    input.append(newInput);
                }
                System.out.println(input);
            }
            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", input);
    }
}
