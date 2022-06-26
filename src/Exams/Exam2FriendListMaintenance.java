package Exams;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exam2FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> friends = Arrays.stream(scanner.nextLine().split(", "))
        		.collect(Collectors.toList());
        String input = scanner.nextLine();
        int countBlacklisted = 0;
        int countLost = 0;

        while (!input.equals("Report")) {
                if (input.contains("Blacklist")) {
                    String name = input.split(" ") [1];
                    if (!friends.contains(name)) {
                        System.out.printf("%s was not found.%n", name);
                    } else {
                        countBlacklisted++;
                        System.out.printf("%s was blacklisted.%n", name);
                        friends.set(friends.indexOf(name), "Blacklisted");
                    }
                } else if (input.contains("Error")) {
                    int index = Integer.parseInt(input.split(" ") [1]);
                    if (index >= 0 && index < friends.size()) {
                        if (!friends.get(index).equals("Blacklisted") && !friends.get(index).equals("Lost")) {
                            countLost++;
                            System.out.printf("%s was lost due to an error.%n", friends.get(index));
                            friends.set(index, "Lost");
                        }
                    }
                } else if (input.contains("Change")) {
                    int index = Integer.parseInt(input.split(" ") [1]);
                    String newName = input.split(" ") [2];
                    if (index >= 0 && index < friends.size()) {
                        System.out.printf("%s changed his username to %s.%n", friends.get(index), newName);
                        friends.set(index, newName);
                    }
                }
            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", countBlacklisted);
        System.out.printf("Lost names: %d%n", countLost);
        for (String friend : friends) {
            System.out.print(friend + " ");
        }
    }
}
