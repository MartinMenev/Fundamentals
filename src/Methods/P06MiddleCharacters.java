package Methods;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        getMiddleElement(scanner.nextLine());
    }

    private static void getMiddleElement(String nextLine) {
        if (nextLine.length() % 2 == 0) {
            System.out.println(nextLine.charAt(nextLine.length()/2 -1) + "" + nextLine.charAt(nextLine.length()/2));
        } else {
            System.out.println(nextLine.charAt(nextLine.length()/2));
        }
    }
}
