package Exams;

import java.util.Scanner;
import java.util.Arrays;

public class P01TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] keyArray = Arrays
         .stream(scanner.nextLine().split(" "))
         .mapToInt(e -> Integer.parseInt(e)).toArray();

        String input = scanner.nextLine();
        while (!input.equals("find")) {
            StringBuilder decriptedMessage = new StringBuilder();
            int j = 0;
            for (int i = 0; i < input.length(); i++) {
                if (i % keyArray.length == 0) {
                    j = 0;
            }
                char symbol = (char) (input.charAt(i) - keyArray[j]);
                j++;
                decriptedMessage.append(symbol);
            }
            String message = decriptedMessage.toString();
            String type = message.substring(message.indexOf("&") + 1, message.lastIndexOf("&"));
            String coordinates = message.substring(message.indexOf("<") + 1, message.lastIndexOf(">"));
            System.out.printf("Found %s at %s%n", type, coordinates);

            input = scanner.nextLine();
        }
    }
}
