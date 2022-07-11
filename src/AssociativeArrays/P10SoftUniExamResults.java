package AssociativeArrays;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> results = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();

        while(!input.equals("exam finished")){
            if (!input.contains("banned")) {
                String [] command = input.split("-");
                String username = command [0];
                String language = command [1];
                int points = Integer.parseInt(command [2]);
                if (results.containsKey(username) && points > results.get(username)) {
                    results.put(username, points);
                } else if (!results.containsKey(username)) {
                    results.put(username, points);
                }
                submissions.putIfAbsent(language, 0);
                submissions.put(language, submissions.get(language)+1);
            } else {
                String userBanned = input.split("-")[0];
                results.remove(userBanned);
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : submissions.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
