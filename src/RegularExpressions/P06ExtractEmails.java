package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[\\w\\.-]+@[a-z-]+.[a-z-\\.]+\\b");
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
