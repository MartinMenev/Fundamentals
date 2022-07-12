package TextProcessing;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            int enc = current + 3;
            char next = (char) enc;
            encrypted.append(next);
        }
        System.out.println(encrypted);
    }
}
