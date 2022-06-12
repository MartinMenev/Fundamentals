package Methods;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        printSmallest(3);
    }

    public static void printSmallest(int number) {
        Scanner scanner = new Scanner(System.in);
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < number; i++) {
            int current = Integer.parseInt(scanner.nextLine());
            if (current < smallest) {
                smallest = current;
            }
        }
        System.out.println(smallest);
    }
}
