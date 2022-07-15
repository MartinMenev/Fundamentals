package Methods;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char start = scanner.nextLine().charAt(0);
        char stop = scanner.nextLine().charAt(0);
        printChars(start, stop);
    }

    private static void printChars(int start, int stop) {
        if (start < stop) {
            for (int i = start + 1; i < stop ; i++) {
                char current = (char) i;
                System.out.print(current + " ");
            }
        } else {
            for (int i = stop + 1; i < start ; i++) {
                char current = (char) i;
                System.out.print(current + " ");
            }
        }
    }
}
