package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> items = Arrays.stream(scanner.nextLine().split(" "))
        .map(Integer::parseInt).collect(Collectors.toList());
            int sumList = 0;
        for (int i = 0; i < items.size(); i++) {
            sumList += items.get(i);
        }
            double avgList = 1.0 * sumList/ items.size();
        List <Integer> top5Numbers = new ArrayList<>();

        int countTopNumbers = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) > avgList) {
                top5Numbers.add(items.get(i));
            }
        }
        Collections.sort(top5Numbers);
        Collections.reverse(top5Numbers);
        for (int i = 5; i < top5Numbers.size() ; i++) {
            top5Numbers.remove(i);
            i--;
        }

        if (top5Numbers.isEmpty()) {
            System.out.println("No");
        } else {
            for (int item : top5Numbers) {
                System.out.print(item + " ");
            }
        }
    }
}
