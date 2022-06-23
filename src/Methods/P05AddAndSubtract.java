package Methods;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        System.out.println(getSubstract(getSum(n1, n2),n3));
    }

    private static int getSum (int num1, int num2) {
        return num1 + num2;
    }

    private static int getSubstract (int num1, int num2) {
        return num1 - num2;
    }
}
