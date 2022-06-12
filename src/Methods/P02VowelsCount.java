package Methods;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        countVowels(scanner.nextLine());
    }

    private static void countVowels(String nextLine) {
        int count = 0;
        for (int i = 0; i < nextLine.length(); i++) {
            char letter = nextLine.toLowerCase().charAt(i);
            switch (letter) {
                case 'a':
                case 'o':
                case 'u':
                case 'e':
                case 'i':
                    count++;
            }
        }
        System.out.println(count);
    }
}
