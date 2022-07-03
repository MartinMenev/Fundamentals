package Methods;

import java.util.Scanner;

public class P07NxN_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        getMatrix(Integer.parseInt(scanner.nextLine()));
    }

    private static void getMatrix(int n) {
        for (int i = 0; i < n ; i++) {
            getline(n);
        }
    }

    private static void getline(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

}
