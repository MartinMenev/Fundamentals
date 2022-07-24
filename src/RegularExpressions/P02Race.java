package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> namesList = Arrays.stream(scanner.nextLine().split(", "))
        		.collect(Collectors.toList());

        Map<String, Integer> racer = new LinkedHashMap<>();

        String input = scanner.nextLine();
        Pattern namePattern = Pattern.compile("[A-Za-z]");
        Pattern digits = Pattern.compile("\\d");

        while (!input.equals("end of race")) {
            Matcher matcher = namePattern.matcher(input);
            String name = "";
            int distance = 0;
            while (matcher.find()) {
                name += matcher.group();
            }
            Matcher digit = digits.matcher(input);
            while (digit.find()){
                distance += Integer.parseInt(digit.group());
            }

            if (namesList.contains(name)) {
                if (!racer.containsKey(name)) {
                    racer.put(name, 0);
                }
                racer.put(name, racer.get(name) + distance);
            }

            input = scanner.nextLine();
        }
       List <String> winner = racer.entrySet().stream()
                       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                               .map(entry -> entry.getKey())
                                       .collect(Collectors.toList());
        
            System.out.printf("1st place: %s%n", winner.get(0));
            System.out.printf("2nd place: %s%n", winner.get(1));
            System.out.printf("3rd place: %s%n", winner.get(2));
        
    }
}
