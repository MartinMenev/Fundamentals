package TextProcessing;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        String str1 = input[0];
        String str2 = input[1];
        int n = Math.min(str1.length(), str2.length());
            int sum = sumOfStrings(str1,str2, n);
            if (str1.length() > n) {
                for (int i = n; i < str1.length() ; i++) {
                    sum+= str1.charAt(i);
                }
            } else {
                for (int i = n; i < str2.length() ; i++) {
                    sum+= str2.charAt(i);
                }
            }
        System.out.println(sum);
    }

    private static int sumOfStrings(String str1, String str2, int n) {
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += str1.charAt(i) * str2.charAt(i);
        }
        return currentSum;
    }
}
