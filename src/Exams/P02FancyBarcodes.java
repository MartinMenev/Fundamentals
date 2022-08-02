package Exams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(@#+)(?<barcode>[A-Z][A-Za-z\\d]{4,}[A-Z])(@#+)");
        Pattern digit = Pattern.compile("\\d");
        int barcodeCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= barcodeCount ; i++) {
            String currentBarcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(currentBarcode);
            String productGroup = "00";
            if (matcher.find()) {
                StringBuilder digits = new StringBuilder();
                Matcher matcherDigits = digit.matcher(matcher.group("barcode"));
                while (matcherDigits.find()) {
                    digits.append(matcherDigits.group());
                    if (!digits.toString().equals("")) {
                        productGroup = digits.toString();
                    }
                }
                System.out.println("Product group: " + productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
