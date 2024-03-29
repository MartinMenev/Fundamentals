package DataTypes;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String biggest = "";
        double maxVolume = Double.MIN_VALUE;
        for (int i = 1; i <= n ; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI * radius * radius * height;
            if (volume > maxVolume) {
                maxVolume = volume;
                biggest = model;
            }
        }
        System.out.println(biggest);
    }
}
