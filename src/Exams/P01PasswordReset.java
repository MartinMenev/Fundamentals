package Exams;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String token = scanner.nextLine();

        while (!token.equals("Done")) {
            String[] command =  token.split(" ");

            switch (command[0]) {
                case "TakeOdd":
                    StringBuilder newText = new StringBuilder();
                    for (int i = 1; i < text.length(); i += 2) {
                        newText.append(text.charAt(i));
                    }
                    text = newText.toString();
                    System.out.println(text);
                    break;

                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    String substring = text.substring(index, length + index);
                    text = text.replace(substring, "");
                    System.out.println(text);
                    break;

                case "Substitute":
                    substring = command[1];
                    String substitute = command [2];
                    if (!text.contains(substring)) {
                        System.out.println("Nothing to replace!");
                    } else {
                        while (text.contains(substring)) {
                            text = text.replace(substring, substitute);
                        }
                        System.out.println(text);
                    }
                    break;
            }
            token = scanner.nextLine();
        }
        System.out.println("Your password is: " + text);
    }
}
