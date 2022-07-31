package Exams;

import java.sql.SQLOutput;
import java.util.*;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroes = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
            String[] currentHero = scanner.nextLine().split(" ");
            int hitPoints = Integer.parseInt(currentHero[1]);
            int manaPoints = Integer.parseInt(currentHero[2]);
            heroes.put(currentHero[0], new ArrayList<>() );
            heroes.get(currentHero[0]).add(0, hitPoints);
            heroes.get(currentHero[0]).add(1, manaPoints);
        }
            String token = scanner.nextLine();
        while (!token.equals("End")) {
            String[] command = token.split(" - ");
            String type = command[0];
            String heroName = command[1];

            switch (type) {
                case "CastSpell":
                    int manaPointsNeeded = Integer.parseInt(command[2]);
                    String spellName = command[3];
                    if (manaPointsNeeded <= heroes.get(heroName).get(1)) {
                        heroes.get(heroName).set(1, heroes.get(heroName).get(1) - manaPointsNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName,heroes.get(heroName).get(1));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(command[2]);
                    String attacker = command[3];
                    heroes.get(heroName).set(0, heroes.get(heroName).get(0) - damage);
                    if (heroes.get(heroName).get(0) > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroes.get(heroName).get(0));
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroes.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(command[2]);
                    if (200 - heroes.get(heroName).get(1) < amount) {
                        amount = 200 - heroes.get(heroName).get(1);
                    }
                    heroes.get(heroName).set(1, heroes.get(heroName).get(1) + amount);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    break;
                case "Heal":
                    amount = Integer.parseInt(command[2]);
                    if (100 - heroes.get(heroName).get(0) < amount) {
                        amount = 100 - heroes.get(heroName).get(0);
                    }
                    heroes.get(heroName).set(0, heroes.get(heroName).get(0) + amount);
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                    break;
            }
            token = scanner.nextLine();
        }
        for (Map.Entry<String, List<Integer>> entry : heroes.entrySet()) {
            System.out.println(entry.getKey());
            System.out.printf(" HP: %d%n", entry.getValue().get(0));
            System.out.printf(" MP: %d%n", entry.getValue().get(1));
        }
    }
}
