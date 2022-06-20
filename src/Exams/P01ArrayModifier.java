package Exams;

import java.util.Scanner;
import java.util.Arrays;

public class P01ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            if (input.contains("swap")) {
                int index1 = Integer.parseInt((input.split(" "))[1]);
                int index2 = Integer.parseInt((input.split(" "))[2]);
                int buffer = arr[index2];
                arr[index2] = arr[index1];
                arr[index1] = buffer;

            } else if (input.contains("multiply")) {
                int index1 = Integer.parseInt((input.split(" "))[1]);
                int index2 = Integer.parseInt((input.split(" "))[2]);
                arr[index1] = arr[index1] * arr[index2];

            } else if (input.contains("decrease")) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] -= 1;
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1]);
    }
}


