package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^%(?<name>[A-Z][a-z]+)%([^\\|\\$%\\.]*)<(?<product>\\w+)>([^\\|\\$%\\.]*)\\|(?<count>\\d+)\\|([^\\|\\$%\\.0-9]*)(?<price>\\d+\\.?\\d*)\\$$");
        String input = scanner.nextLine();

        double totalIncome = 0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double currentIncome = count * price;

                System.out.printf("%s: %s - %.2f%n", name, product, currentIncome);
                totalIncome += currentIncome;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
