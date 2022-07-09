package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map <String, String> user = new LinkedHashMap<>();
        for (int i = 1; i <= n ; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String username = input[1];

            switch (command) {
                case "register":
                    String licencePlate = input[2];
                    if (user.containsKey(username)){
                        System.out.printf("ERROR: already registered with plate number %s%n", user.get(username));
                    } else {
                        user.put(username, licencePlate);
                        System.out.printf("%s registered %s successfully%n", username, user.get(username));
                    }
                    break;
                case "unregister":
                        if (!user.containsKey(username)) {
                            System.out.printf("ERROR: user %s not found%n", username);
                        } else {
                            System.out.printf("%s unregistered successfully%n", username);
                            user.remove(username);
                        }
                    break;
            }
        }
        for (Map.Entry<String, String> entry : user.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
