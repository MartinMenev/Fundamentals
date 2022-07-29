package DataTypes;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int filled = 0;
        for (int i = 1; i <= n ; i++) {
            int nextLitres = Integer.parseInt(scanner.nextLine());
            filled +=nextLitres;
            if (filled > capacity) {
                System.out.println("Insufficient capacity!");
                filled -= nextLitres;
            }
        }
        System.out.println(filled);
    }
}
