package AssociativeArrays;

import java.util.*;

public class P04Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();
        Map<String, Double> productPrice = new LinkedHashMap<>();

        while (!product.equals("buy")) {
            String item = product.split(" ") [0];
            double price = Double.parseDouble(product.split(" ") [1]);
            int quantity = Integer.parseInt(product.split(" ") [2]);
            if (!productQuantity.containsKey(item)) {
                productQuantity.put(item, 0);
                productPrice.put(item, 0.0);

            }
            productPrice.put(item, price);
            productQuantity.put(item, productQuantity.get(item) + quantity);
            product = scanner.nextLine();
        }
        for (Map.Entry<String, Double> item : productPrice.entrySet()) {
            System.out.printf("%s -> %.2f%n", item.getKey(), item.getValue() * productQuantity.get(item.getKey()));
        }
    }
}
