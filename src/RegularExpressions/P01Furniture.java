package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> boughtFurniture = new ArrayList<>();
        Pattern regex = Pattern.compile(">>([A-Z]+[a-z]*)<<(\\d+.\\d*)!(\\d+)");
        double totalPrice = 0;

        while(!input.equals("Purchase")) {
            Matcher matcher = regex.matcher(input);
            if (matcher.find()) {
                String furniture = matcher.group(1);
                double price =  Double.parseDouble(matcher.group(2));
                int quantity =  Integer.parseInt(matcher.group(3));
                boughtFurniture.add(furniture);
                totalPrice += price * quantity;
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String furniture : boughtFurniture) {
            System.out.println(furniture);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
