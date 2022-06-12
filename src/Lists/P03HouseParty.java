package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> partyList = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[2]) {
                case "going!":
                        addPersonToPartyList(input[0], partyList);
                    break;
                case "not":
                    removePersonFromPartyList (input[0], partyList);
                    break;
            }
        }
        for (int i = 0; i < partyList.size(); i++) {
            System.out.println(partyList.get(i));
        }
    }

    private static void removePersonFromPartyList(String name, List<String> partyList) {
        boolean nameExists = false;
        for (int i = 0; i < partyList.size(); i++) {
            if (name.equals(partyList.get(i))) {
                nameExists = true;
                partyList.remove(i--);
            }
        }
        if (!nameExists) {
            System.out.printf("%s is not in the list!%n", name);
        }
    }

    private static void addPersonToPartyList(String name, List<String> partyList) {
        boolean nameExists = false;
        for (int i = 0; i < partyList.size(); i++) {
            if (name.equals(partyList.get(i))) {
                nameExists = true;
                System.out.printf("%s is already in the list!%n", name);
                break;
            }
        }
        if (!nameExists) {
            partyList.add(name);
        }
    }
}
