package Lists;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String winner = "";
        int sum = 0;
        while (firstPlayer.size() > 0 && secondPlayer.size() > 0) {
            if (firstPlayer.get(0) > secondPlayer.get(0)) {
                firstPlayer.add(firstPlayer.get(0));
                firstPlayer.remove(0);
                firstPlayer.add(secondPlayer.get(0));
                secondPlayer.remove(0);
            } else if (secondPlayer.get(0) > firstPlayer.get(0)) {
                secondPlayer.add(secondPlayer.get(0));
                secondPlayer.remove(0);
                secondPlayer.add(firstPlayer.get(0));
                firstPlayer.remove(0);
            } else if (firstPlayer.get(0).equals(secondPlayer.get(0))) {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
        }
        if (firstPlayer.size() == 0) {
            winner = "Second";
            for (Integer card : secondPlayer) {
                sum += card;
            }
        } else {
            winner = "First";
            for (Integer card : firstPlayer) {
                sum += card;
            }
        }
        System.out.printf("%s player wins! Sum: %d", winner, sum);
    }
}