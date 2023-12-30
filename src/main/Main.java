package main;
import droid.*;
import menu.Menu;
import java.util.*;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public final static List<Combatant> droid = new ArrayList<>();

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.handleMenuInput();
    }
    public static void createDroid(){
        System.out.println("\u001B[32m"+"\u001B[1m"+"Види дроїдів:"+"\u001B[0m");
        System.out.println("\u001B[36m"+"1. Воїн"+"\u001B[0m");
        System.out.println("\u001B[36m"+"2. Лікар"+"\u001B[0m");
        System.out.print("\u001B[35m"+"\u001B[4m"+"Виберіть вид дроїда:"+"\u001B[0m");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введіть ім'я:");
        String name = scanner.nextLine();
        System.out.print("Введіть здоров'я:");
        int health = scanner.nextInt();
        System.out.print("Введіть урон:");

        int damage = scanner.nextInt();
        if (type == 1) {
            System.out.print("Введіть силу воїна:");
            int strength = scanner.nextInt();
            Warrior warrior = new Warrior(name, health, damage, strength);
            droid.add(warrior);
        } else if (type == 2) {
            System.out.print("Введіть силу лікування лікаря:");
            int healingPower = scanner.nextInt();
            Healer healer = new Healer(name, health, damage, healingPower);
            droid.add(healer);
        } else {
            System.out.println("Неправильний вибір.");
            createDroid();
        }
    }
    public static void showDroidList(List<Combatant> droids) {
        for (int i = 0; i < droids.size(); i++) {
            Combatant droid = droids.get(i);
            String color = (i % 2 == 0) ? "\u001B[32m" : "\u001B[34m";  // Зелений або синій колір через ANSI escape-послідовності
            System.out.println(color + (i + 1) + ". " + droid.toString() + "\u001B[0m");  // Скидання кольору
        }
    }
    public static Combatant chooseDroid(List<Combatant> availableDroids) {
        System.out.println("Список доступних дроїдів:");
        showDroidList(availableDroids);
        System.out.println("Оберіть номер дроїда:");
        int droidChoice = scanner.nextInt();

        if (droidChoice >= 1 && droidChoice <= availableDroids.size()) {
            Combatant selectedDroid = availableDroids.get(droidChoice - 1);
            availableDroids.remove(selectedDroid);
            return selectedDroid;
        } else {
            System.out.println("Неправильний вибір. Оберіть ще раз.");
            return chooseDroid(availableDroids);
        }
    }
}