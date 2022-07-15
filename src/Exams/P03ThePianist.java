package Exams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<String>> plays = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] currentPlay = scanner.nextLine().split("\\|");
            String key = currentPlay[2];
            String piece = currentPlay[0];
            String composer = currentPlay[1];
            plays.put(piece, new ArrayList<>());
            plays.get(piece).add(composer);
            plays.get(piece).add(key);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] command = input.split("\\|");

            String keyToRemove = "";
            switch (command[0]) {
                case "Add":
                    String currentPiece = command[1];
                    String currentComposer = command[2];
                    String currentKey = command[3];

                   if (plays.containsKey(currentPiece)) {
                       System.out.printf("%s is already in the collection!%n", currentPiece);
                   } else {
                        plays.put(currentPiece, new ArrayList<>());
                        plays.get(currentPiece).add(currentComposer);
                        plays.get(currentPiece).add(currentKey);
                        System.out.printf("%s by %s in %s added to the collection!%n", currentPiece, currentComposer, currentKey);
                    }
                    break;

                case "Remove":
                    currentPiece = command[1];

                    if (!plays.containsKey(currentPiece)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                        } else {
                        plays.remove(currentPiece);
                        System.out.printf("Successfully removed %s!%n", currentPiece);
                    }
                    break;

                case "ChangeKey":
                    currentPiece = command[1];
                    String newKey = command[2];

                   if (plays.containsKey(currentPiece)) {
                       plays.get(currentPiece).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", currentPiece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",currentPiece);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, ArrayList<String>> entry : plays.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}

