package ObjectsClasses;

import java.util.*;

public class P05Students {

    static class Students {
        String firstName;
        String lastName;
        double grade;

        public Students(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public double getGrade() {
            return this.grade;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Students> listStudents = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            Students currentStudent = new Students (command [0], command [1], Double.parseDouble(command[2]));
            listStudents.add(currentStudent);
        }
        listStudents.sort(Comparator.comparingDouble(Students :: getGrade).reversed());

        for (Students item : listStudents) {
            System.out.printf("%s %s: %.2f%n", item.getFirstName(), item.getLastName(), item.getGrade());
        }
    }
}
