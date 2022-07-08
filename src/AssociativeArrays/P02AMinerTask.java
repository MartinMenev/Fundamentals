package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> task = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            if (!task.containsKey(input)) {
                task.put(input, 0);
            }
            task.put(input, task.get(input) + Integer.parseInt(scanner.nextLine()));
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> item : task.entrySet()) {
            System.out.printf("%s -> %d%n", item.getKey(), item.getValue());
        }
    }
}
