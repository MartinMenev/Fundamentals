package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<string>\\D+)(?<n>\\d{1,2})");
        List<String> uniqueSymbols = new ArrayList<>();

        String text = scanner.nextLine();
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();
        while (matcher.find()){
            String currentString = matcher.group("string");
            int number = Integer.parseInt(matcher.group("n"));
            currentString = currentString.toUpperCase();

            for (Character symbol : currentString.toCharArray()) {
                if (!uniqueSymbols.contains(""+ symbol)) {
                    uniqueSymbols.add(""+ symbol);
                }
            }
            for (int i = 0; i < number; i++) {
                result.append(currentString);
            }
        }
        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        System.out.println(result);
    }
}
