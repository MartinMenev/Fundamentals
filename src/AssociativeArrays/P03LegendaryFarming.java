package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> materials = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        Map<String, Integer> junk = new LinkedHashMap<>();
        boolean isWon = false;
        while (!isWon) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                if (i % 2 == 1) {
                    String mat = input[i].toLowerCase();
                    if (mat.equals("shards") || mat.equals("fragments") || mat.equals("motes")) {

                        materials.put(mat, materials.get(mat) + Integer.parseInt(input[i - 1]));
                        if (materials.get(mat) >= 250) {
                            materials.put(mat, materials.get(mat) - 250);
                            switch (mat) {
                                case "shards":
                                    System.out.println("Shadowmourne obtained!");
                                    break;
                                case "fragments":
                                    System.out.println("Valanyr obtained!");
                                    break;
                                case "motes":
                                    System.out.println("Dragonwrath obtained!");
                                    break;
                            }
                            isWon = true;
                            break;
                        }
                    } else {
                        if (!junk.containsKey(mat)) {
                            junk.put(mat, 0);
                        }
                        junk.put(mat, junk.get(mat) + Integer.parseInt(input[i - 1]));
                    }

                }
            }
        }
        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}


