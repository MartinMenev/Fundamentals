package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
        .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while(!input.equals("end")) {
            String[] arr = input.split(" ");
            if (arr[0].equals("Add")) {
                addWagonWithPassengers(Integer.parseInt(arr[1]), wagons);
            } else {
                addPassengers(Integer.parseInt(arr[0]), wagons, maxCapacity);
            }
            input = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));

    }

    private static void addPassengers(int passengers, List<Integer> wagons, int limit) {
        for (int i = 0; i < wagons.size(); i++) {
            if (passengers + wagons.get(i) <= limit) {
                wagons.set(i, passengers + wagons.get(i));
                break;
            }
        }
    }

    private static void addWagonWithPassengers (int passengers, List<Integer> wagons) {
        wagons.add(passengers);
    }
}

