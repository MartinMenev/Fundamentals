package Exams;

import java.util.Scanner;

public class P01_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String content = scanner.nextLine();
        String input = scanner.nextLine();
        System.out.println("<h1>");
        System.out.println("    " + title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println("    " + content);
        System.out.println("</article>");

        while (!input.equals("end of comments")) {
            String comment = input;
            System.out.printf("<div>%n    %s%n</div>%n", comment);
            input = scanner.nextLine();
        }
    }
}

