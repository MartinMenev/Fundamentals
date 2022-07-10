package AssociativeArrays;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, ArrayList<String>> company = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String currentCompany = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];
            if (!company.containsKey(currentCompany)) {
                company.put(currentCompany, new ArrayList<>());
            }
                if (!company.get(currentCompany).contains(employeeID)) {
                    company.get(currentCompany).add(employeeID);
                }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, ArrayList<String>> entry : company.entrySet()) {
            System.out.println(entry.getKey());
            for (String s : entry.getValue()) {
                System.out.printf("-- %s%n", s);
            }
        }
    }
}
