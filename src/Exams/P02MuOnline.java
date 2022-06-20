package Exams;

        import java.util.Scanner;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int bitcoin = 0;
        String[] rooms = scanner.nextLine().split("\\|");
        int bestResult = 0;
        int bestRoom = -1;
        boolean gameComplete = true;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].contains("potion")) {
                int heal = Integer.parseInt(rooms[i].split(" ")[1]);
                if (health + heal > 100) {
                    heal = 100 - health;
                }
                System.out.printf("You healed for %d hp.%n", heal);
                health += heal;
                System.out.printf("Current health: %d hp.%n", health);
            } else if (rooms[i].contains("chest")) {
                int currentBitcoin = Integer.parseInt(rooms[i].split(" ")[1]);
                bitcoin += currentBitcoin;
                System.out.printf("You found %d bitcoins.%n", currentBitcoin);
            } else {
                int attack = Integer.parseInt(rooms[i].split(" ")[1]);
                health -= attack;
                String monster = rooms[i].split(" ")[0];
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", monster);



                } else {
                    System.out.printf("You died! Killed by %s.%n", monster);
                    System.out.printf("Best room: %d", i + 1);
                    gameComplete = false;
                    break;
                }
            }
        }
        if (gameComplete) {
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoin, health);
        }
    }
}
