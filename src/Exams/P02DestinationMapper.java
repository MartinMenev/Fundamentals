package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([=/])(?<place>[A-Z][A-Za-z]{2,})(\\1)");
        String text = scanner.nextLine();
        int travelPoint = 0;
        List<String> destinations = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            destinations.add(matcher.group("place"));
            travelPoint += matcher.group("place").length();
        }
        System.out.printf("Destinations: %s%n", String.join(", ", destinations));
        System.out.printf("Travel Points: %d", travelPoint);
    }
}
