package Exams;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sumWithoutTaxes = 0;
        double specialSumWOtaxes = 0;
        double taxes = 0;
        boolean invalidOrder = false;
        while(!input.equals("special") && !input.equals("regular")){
            double priceWithoutTax = Double.parseDouble(input);
            if (priceWithoutTax < 0) {
                System.out.println("Invalid price!");
            } else {
                sumWithoutTaxes +=priceWithoutTax;
            }
            input = scanner.nextLine();
        }
        if (input.equals("special")) {
            specialSumWOtaxes = sumWithoutTaxes - 0.10 * sumWithoutTaxes;
        } else {
            specialSumWOtaxes = sumWithoutTaxes;
        }
        taxes = sumWithoutTaxes * 0.20;
        if (sumWithoutTaxes == 0) {
            invalidOrder = true;
        }

        if (invalidOrder) {
            System.out.println("Invalid order!");
        } else {
                System.out.printf("Congratulations you've just bought a new computer!%nPrice without taxes: %.2f$%nTaxes: %.2f$%n-----------%nTotal price: %.2f$%n",
                        sumWithoutTaxes, taxes, specialSumWOtaxes + specialSumWOtaxes * 0.20);

        }
    }
}
