package Exams;

import java.util.*;
import java.util.stream.Stream;

public class P03Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        Map<String, String> contests = new LinkedHashMap<>();
        Map<String, List<String>> user = new TreeMap<>();
        String bestCandidate = "";
        int bestPoints = 0;

        while (!content.equals("end of contests")) {
            String contest = content.split(":")[0];
            String password = content.split(":")[1];
            contests.put(contest, password);
            content = scanner.nextLine();
        }
        String input = scanner.nextLine();
        while (!input.equals("end of submissions")) {
            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String name = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);
            boolean noNeedtoAdd = false;
            if (contests.containsKey(contest) && contests.get(contest).equals(password)) {
                if (!user.containsKey(name)) {
                    user.put(name, new ArrayList<>());
                } else {
                    for (int i = 0; i < user.get(name).size() - 1; i += 2) {
                        if (user.get(name).get(i).equals(contest)) {
                            noNeedtoAdd = true;
                            if (Integer.parseInt(user.get(name).get(i + 1)) < points) {
                                user.get(name).set(i + 1, "" + points);
                            }
                        }
                    }
                }
                if (!noNeedtoAdd) {
                    user.get(name).add(contest);
                    user.get(name).add("" + points);
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : user.entrySet()) {
            int totalPointPerUser = 0;
            for (int i = 1; i < entry.getValue().size(); i += 2) {
                totalPointPerUser += Integer.parseInt(entry.getValue().get(i));
            }
            if (totalPointPerUser > bestPoints) {
                bestPoints = totalPointPerUser;
                bestCandidate = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestPoints);
        System.out.println("Ranking:");
        for (Map.Entry<String, List<String>> entry : user.entrySet()) {
            System.out.println(entry.getKey());
            Map<String, Integer> tempList = new TreeMap<>();
            for (int i = 0; i < entry.getValue().size() - 1; i += 2) {
                tempList.put(entry.getValue().get(i), Integer.parseInt(entry.getValue().get(i + 1)));
            }

            LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

            tempList.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, Integer> current : sortedMap.entrySet()) {
                System.out.println("#  " + current.getKey() + " -> " + current.getValue());
            }
        }
    }
}
