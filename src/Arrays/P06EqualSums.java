package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays
         .stream(scanner.nextLine().split(" "))
         .mapToInt(e -> Integer.parseInt(e)).toArray();
         int index = 0;
         boolean isFound = false;
        for (int i = 0; i < arr.length ; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += arr[j];
            }
            for (int k = i + 1 ; k < arr.length; k++) {
                sumRight += arr [k];
            }
            if (sumLeft == sumRight) {
                isFound = true;
                index = i;
            }
        }
        if (isFound) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
