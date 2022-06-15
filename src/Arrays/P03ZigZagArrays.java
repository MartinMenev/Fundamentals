package Arrays;

import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int [n];

            for (int i = 0; i < n; i++) {
                int nextNum = scanner.nextInt();
                if (i % 2 == 0 )  {
                    arr1 [i] = nextNum;
                    arr2 [i] = scanner.nextInt();
                 } else {
                    arr2[i] = nextNum;
                    arr1[i] = scanner.nextInt();
                }
            }
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1 [i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2 [i] + " ");
        }
    }
}

