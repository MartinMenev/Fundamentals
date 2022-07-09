package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map <String, String> course = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String courseName = input.split(" : ")[0];
            String studentName = input.split(" : ") [1];
            if (!course.containsKey(courseName)) {
                course.put(courseName, studentName);
            } else {
                course.put(courseName, course.get(courseName) + ", " + studentName);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : course.entrySet()) {
            String [] names = entry.getValue().split(", ");
            System.out.printf("%s: %d%n", entry.getKey(), names.length);
            for (String name : names) {
                System.out.printf("-- %s%n", name);
            }
        }
    }
}
