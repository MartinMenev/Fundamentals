package Lists;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> items = Arrays.stream(scanner.nextLine().split(" "))
        .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while(!input.equals("end")) {
            String[] arr = input.split(" ");

            switch (arr[0]) {
                case "Delete":
                    deleteElement(Integer.parseInt(arr[1]), items);
                    break;

                case "Insert":
                    insertElement(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),items);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(items.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void insertElement(int element, int position, List<Integer> items) {
        items.add(position, element);
    }

    private static void deleteElement(int element, List<Integer> items) {
        for (int i = 0; i < items.size(); i++) {
            if (element == items.get(i)) {
                items.remove(i--);
            }
        }
    }
}
