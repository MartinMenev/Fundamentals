package Arrays;

import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int j = 0; j < n; j++) {
            String buffer = arr1 [0];
            for (int i = 1; i <= arr1.length - 1 ; i++) {
                arr1 [i - 1] = arr1 [i];
            }
            arr1 [arr1.length -1] = buffer;
        }
        System.out.println(String.join(" ", arr1));
    }
}
