package Exams;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());


        String input = scanner.nextLine();
        int numberOfMoves = 0;
        boolean isWon = false;
        while (!input.equals("end")) {
            int index1 = Integer.parseInt(input.split(" ")[0]);
            int index2 = Integer.parseInt(input.split(" ")[1]);
            numberOfMoves++;
            if (index1 == index2 || index1 < 0 || index2 < 0 || index1 > items.size() - 1 || index2 > items.size() -1) {
                String addingElement = "-" + numberOfMoves + "a";
                items.add(items.size() / 2, addingElement);
                items.add(items.size() / 2 + 1, addingElement);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (items.get(index1).equals(items.get(index2))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", items.get(index1));
                if (index1 < index2) {
                    items.remove(index1);
                    items.remove(index2 -1);
                } else {
                    items.remove(index2);
                    items.remove(index1 - 1);
                }
            } else {
                System.out.println("Try again!");
            }
            if (items.isEmpty()) {
                System.out.printf("You have won in %d turns!", numberOfMoves);
                isWon = true;
                break;
            }
            input = scanner.nextLine();
        }
        if (!isWon) {
            System.out.println("Sorry you lose :(");
            for (String item : items) {
                System.out.print(item + " ");
            }
        }
    }
}
