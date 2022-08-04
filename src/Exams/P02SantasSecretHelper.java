package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behavior>[GN])!");
        List<String> goodKids = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            StringBuilder message = new StringBuilder();
            for (Character symbol : input.toCharArray()) {
                char decodedSymbol = (char) (symbol - key);
                message.append(decodedSymbol);
            }
                String text = message.toString();
                Matcher matcher = pattern.matcher(text);

                if (matcher.find()) {
                    String name = matcher.group("name");
                    String behaviour = matcher.group("behavior");
                    if (behaviour.equals("G")) {
                        goodKids.add(name);
                    }
                }

            input = scanner.nextLine();
        }
        for (String kid : goodKids) {
            System.out.println(kid);
        }
    }
}
