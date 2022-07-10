package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> student = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
            String currentStudent = scanner.nextLine();
            String currentGrade = scanner.nextLine();
            if (!student.containsKey(currentStudent)) {
                student.put(currentStudent, currentGrade);
            } else {
                student.put(currentStudent, student.get(currentStudent) + ", " + currentGrade);
            }
        }
        for (Map.Entry<String, String> entry : student.entrySet()) {
            double [] grades = Arrays
             .stream(entry.getValue().split(", "))
             .mapToDouble(e -> Double.parseDouble(e)).toArray();
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            double average = sum / grades.length;
            if (average >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), average);
            }
        }
    }
}
