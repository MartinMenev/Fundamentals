package ObjectsClasses;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03OpinionPoll {

    static class Person {
        String name;
        int age;

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Person currentPerson = new Person();
            currentPerson.setName(input [0]);
            currentPerson.setAge(Integer.parseInt(input [1]));
            persons.add(currentPerson);
        }

        for (Person current : persons) {
            if (current.getAge() > 30) {
                System.out.printf("%s - %d%n", current.getName(), current.getAge());
            }
        }
    }
}
