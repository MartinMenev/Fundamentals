package Exams;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", "))
        		.collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.contains("Craft!")) {
            String command = input.split(" - ") [0];
            String item = input.split(" - ") [1];

            if (command.contains("Collect")) {
                if (!items.contains(item)) {
                    items.add(item);
                }
            } else if (command.contains("Drop")) {
                items.remove(item);
            } else if (command.contains("Combine")) {
                String subCommand = input.split(" - ") [1];

                String oldItem = subCommand.split(":") [0];
                String newItem = subCommand.split(":") [1];

                if (items.contains(oldItem)) {
                    items.add(items.indexOf(oldItem)+ 1, newItem);
                }

            } else if (command.contains("Renew")) {
                if (items.contains(item)) {
                    items.remove(item);
                    items.add(item);
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < items.size() -1; i++) {
            System.out.print(items.get(i)+ ", ");
        }
        System.out.println(items.get(items.size()-1));
    }
}
