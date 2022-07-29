package DataTypes.FirstWeek;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPeople = Integer.parseInt(scanner.nextLine());
        String typeGroup = scanner.nextLine();
        String day = scanner.nextLine();

        double totalPrice = 0;
        double price = 0;
        switch (typeGroup) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                break;
        }
        totalPrice = numberPeople * price;

        if (numberPeople >= 30 && typeGroup.equals("Students")) {
            totalPrice = totalPrice - totalPrice * .15;
        }
        if (typeGroup.equals("Business") && numberPeople >= 100) {
            totalPrice = (numberPeople - 10) * price;
        }
        if (typeGroup.equals("Regular") && numberPeople >= 10 && numberPeople <= 20) {
            totalPrice = totalPrice - totalPrice * 0.05;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
