package TextProcessing;

import java.util.Scanner;


public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner. nextLine().split(", ");
        for (String name : input) {
            if (validLength(name) && validSymbols(name)) {
                System.out.println(name);
            }
        }

    }

    private static boolean validSymbols(String name) {
        boolean isValid = false;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 45 || name.charAt(i) == 95 || name.charAt(i) >= 48 && name.charAt(i) <= 57 ||
                    name.charAt(i) >= 65 && name.charAt(i) <= 90 || name.charAt(i) >= 97 && name.charAt(i) <= 122) {
                isValid = true;
            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private static boolean validLength(String name) {
        return name.length() >=3 && name.length() <=16;
    }
}
