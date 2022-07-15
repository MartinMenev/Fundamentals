package Exams;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] command = input.split("\\|");

            switch (command[0]) {
                case "Move" -> {
                    int numberLetters = Integer.parseInt(command[1]);
                    String toMove = text.substring(0, numberLetters);
                    text = text.replace(toMove, "");
                    text += toMove;
                }
                case "Insert" -> {
                    int index = Integer.parseInt(command[1]);
                    String value = command[2];
                    StringBuilder newText = new StringBuilder();
                    newText.append(text);
                    newText.insert(index, value);
                    text = newText.toString();
                }
                case "ChangeAll" -> {
                    String subText = command[1];
                    String replacement = command[2];
                    while (text.contains(subText)) {
                        text = text.replace(subText, replacement);
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", text);
    }
}
