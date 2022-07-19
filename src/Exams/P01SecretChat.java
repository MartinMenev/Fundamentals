package Exams;

import java.util.Scanner;
import java.util.StringJoiner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while(!input.equals("Reveal")){
            String [] command = input.split(":\\|:");
            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(command [1]);
                    StringBuilder sb = new StringBuilder(text);
                    sb.insert(index, " ");
                    text = sb.toString();
                    System.out.println(text);
                    break;

                case "Reverse":
                    String subString = command [1];
                    if (!text.contains(subString)){
                        System.out.println("error");
                    } else {
                        sb = new StringBuilder();
                        sb.append(subString);
                        sb.reverse();
                        int stringStart = text.indexOf(subString);
                        int stringEnd = subString.length() + stringStart - 1;
                        StringBuilder newText = new StringBuilder(text);
                        newText.replace(stringStart, stringEnd +1,"");
                        text = newText.toString();
                        text += sb.toString();
                        System.out.println(text);
                    }
                    break;

                case "ChangeAll":
                    subString = command [1];
                    String replacement = command [2];
                     while (text.contains(subString)) {
                         text = text.replace(subString, replacement);
                         System.out.println(text);
                     }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", text);
    }
}
