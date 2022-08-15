package DataTypes;

import java.util.Scanner;

public class P05PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int last = Integer.parseInt(scanner.nextLine());
        for (char i = (char) first; i <= (char) last; i++) {
            System.out.print(i + " ");
        }
    }
}
