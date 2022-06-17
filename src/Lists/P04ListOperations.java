package Lists;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> items = Arrays.stream(scanner.nextLine().split(" "))
        .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] command = input.split(" ");

            switch(command[0]) {
                case "Add":
                    items.add(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    int value = Integer.parseInt(command[1]);
                    if (index < items.size()) {
                        items.add(index, value);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(command[1]);
                    if (index < items.size()) {
                        items.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String subCommand = command[1];
                    int count = Integer.parseInt(command[2]);

                    switch (subCommand) {
                        case "left":
                            shiftLeft (count, items);
                            break;

                        case "right":
                            shiftRight (count, items);
                            break;
                }

                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(items.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void shiftRight(int count, List<Integer> items) {
        for (int i = 0; i < count; i++) {
            items.add(0,items.get(items.size()-1));
            items.remove(items.size()-1);
        }
    }

    private static void shiftLeft(int count, List<Integer> items) {

            for (int i = 0; i < count; i++) {
                items.add(items.get(0));
                items.remove(0);
            }
        }
    }


