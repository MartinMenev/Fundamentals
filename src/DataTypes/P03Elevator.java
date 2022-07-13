package DataTypes;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // number of persons
        int p = Integer.parseInt(scanner.nextLine()); // capacity of elevator

        int courses =  (int) Math.ceil ( (double) n / p);
        System.out.println(courses);
    }
}
