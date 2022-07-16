package TextProcessing;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (int i = 0; i < input.length; i++) {
            char first = input[i].charAt(0);
            char last = input [i].charAt(input[i].length()-1);
            double num = Double.parseDouble(input[i].substring(1, input[i].length() - 1));

            if (isUppercase(first)) {
                num /= (first - 64);
            } else {
                num *= (first - 96);
            }

            if (isUppercase(last)) {
                num -= (last - 64);
            } else {
                num += (last - 96);
            }

            sum += num;
        }
        System.out.printf("%.2f", sum);
    }

    private static boolean isUppercase(char first) {
        return first >= 65 && first <= 90;
    }
}
