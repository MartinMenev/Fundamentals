package ObjectsClasses;

import java.util.*;

public class P07OrderByAge {
    private static class Person {
        String name;
        String idNumber;
        int age;

        public Person (String name, String idNumber, int age) {
            this.name = name;
            this.idNumber = idNumber;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public String getIdNumber() {
            return this.idNumber;
        }

        public int getAge() {
            return this.age;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> persons = new ArrayList<>();

        while (!input.equals("End")) {
            String name = input.split(" ") [0];
            String idNumber = input.split(" ") [1];
            int age = Integer.parseInt(input.split(" ") [2]);
            Person currentPerson = new Person(name, idNumber, age);
            persons.add(currentPerson);
            input = scanner.nextLine();
        }

        persons.sort(Comparator.comparingInt(Person :: getAge));

            for (Person item : persons) {
                System.out.printf("%s with ID: %s is %d years old.%n", item.getName(), item.getIdNumber(), item.getAge());
            }
    }
}
