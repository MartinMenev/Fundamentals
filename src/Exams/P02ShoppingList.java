package Exams;

import java.util.Scanner;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] shoppingList = text.split("!");

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Urgent":
                    boolean isFound = false;
                    for (int i = 0; i < shoppingList.length; i++) {
                        if (command[1].equals(shoppingList[i])) {
                            isFound = true;
                            break;
                        }
                    }
                    if (!isFound) {
                        String temp = command[1] + " " + String.join(" ", shoppingList);
                        shoppingList = temp.split(" ");
                    }
                    break;

                case "Unnecessary":
                    for (int i = 0; i < shoppingList.length; i++) {
                        if (command[1].equals(shoppingList[i])) {
                            for (int j = i; j < shoppingList.length - 1; j++) {
                                shoppingList[j] = shoppingList[j + 1];
                            }
                            String [] temp = new String [shoppingList.length - 1];
                            for (int k = 0; k < temp.length; k++) {
                                temp[k] = shoppingList[k];
                            }
                            shoppingList = temp.clone();
                        }
                    }


                    break;

                case "Correct":
                    for (int i = 0; i < shoppingList.length; i++) {
                        if (command[1].equals(shoppingList[i])) {
                            shoppingList[i] = command[2];
                        }
                    }
                    break;

                case "Rearrange":
                    for (int i = 0; i < shoppingList.length; i++) {
                        if (command[1].equals(shoppingList[i])) {
                            String temp1 = shoppingList[i];
                            for (int j = i; j < shoppingList.length - 1; j++) {
                                shoppingList[j] = shoppingList[j + 1];
                            }
                            shoppingList[shoppingList.length - 1] = temp1;
                        }
                    }

                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < shoppingList.length - 1; i++) {
            System.out.print(shoppingList[i] + ", ");
        }
        System.out.println(shoppingList[shoppingList.length - 1]);
    }
}
