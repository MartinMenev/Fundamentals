package Exams;

import java.util.Scanner;
import java.util.Arrays;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays
         .stream(scanner.nextLine().split(" "))
         .mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scanner.nextLine();
        int shotTargets = 0;
        while (!input.equals("End")) {
            int nextTarget = Integer.parseInt(input);
            if (nextTarget >= 0 && nextTarget < targets.length) {
                for (int i = 0; i < targets.length; i++) {
                    if (i != nextTarget && targets [i] != -1) {
                        if (targets [i] <= targets [nextTarget]) {
                            targets [i] += targets [nextTarget];
                        } else {
                            targets [i] -= targets [nextTarget];
                        }
                    }
                }
                if (targets[nextTarget] != -1) {
                    targets[nextTarget] = -1;
                    shotTargets++;
                }
            }
            input = scanner.nextLine();
        }
        StringBuilder result = new StringBuilder();
                for (int item : targets) {
                    result.append(item+ " ");
                }
        System.out.printf("Shot targets: %d -> %s", shotTargets, result.toString());
    }
}
