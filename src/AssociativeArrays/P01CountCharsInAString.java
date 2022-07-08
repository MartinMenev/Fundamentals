package AssociativeArrays;

import com.sun.jdi.Value;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String join = String.join("", input);
        String[] text = join.split("");

       Map<String, Integer> result = new LinkedHashMap<>();
        for (String letter : text) {
            if (!result.containsKey(letter)) {
                result.put(letter, 0);
            }
            result.put(letter, result.get(letter) + 1);
        }


        //  result.values().stream().sorted().count();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            result.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));

            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}