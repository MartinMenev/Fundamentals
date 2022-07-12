package TextProcessing;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int nPoint = input.indexOf(".");
        int n = input.lastIndexOf("\\");
        System.out.printf("File name: %s%n", input.substring(n + 1,nPoint));
        System.out.printf("File extension: %s%n", input.substring(nPoint + 1));
    }
}
