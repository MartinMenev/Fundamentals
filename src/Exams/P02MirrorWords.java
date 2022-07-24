package Exams;

import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> mirrors = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([@\\#])([A-Za-z]{3,})(\\1){2}([A-Za-z]{3,})(\\1)");
        Matcher matcher = pattern.matcher(text);
        boolean foundMatches = false;
        int  countPairs = 0;
        while (matcher.find()) {
            foundMatches = true;
            countPairs ++;
            String currentWord = matcher.group(2);
            String possibleMirror = matcher.group(4);
            StringBuilder mirror = new StringBuilder(possibleMirror);
            mirror.reverse();
            String newMirror = mirror.toString();

            if (currentWord.equals(newMirror)) {
                mirrors.put(currentWord, possibleMirror);
            }
        }
        if (!foundMatches) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", countPairs);
        }
        if (mirrors.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            for (Map.Entry<String, String> entry : mirrors.entrySet()) {
                result.add(entry.getKey() + " <=> " + entry.getValue());
            }
        }
        String output = String.join(", ", result);
        System.out.println(output);
    }
}
