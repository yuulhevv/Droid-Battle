package arena;
import droid.Combatant;
import main.Main;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.*;

public class Arena {

    private final static Scanner scanner = new Scanner(System.in);
    public static final Logger LOGGER = Logger.getLogger(Arena.class.getName());

    static {
        try {
            // Remove the default console handler
            LOGGER.setUseParentHandlers(false);

            // Create a new console handler
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.OFF);  // Set console log level to OFF

            // Create a file handler
            FileHandler fileHandler = new FileHandler("battle_log.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.INFO);

            // Add the console handler to the logger
            LOGGER.addHandler(consoleHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void writeBattleToFile(String message) {
        LOGGER.info(message);
    }
    public static void readBattleFromFile() {
        System.out.println("Результати поєдинку, що відбувся:");
        try {
            // Вказати шлях до вашого файлу логів
            String filePath = "battle_log.log";

            // Створити об'єкт FileReader для зчитування з файлу
            FileReader fileReader = new FileReader(filePath);

            // Створити об'єкт BufferedReader для ефективного зчитування
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Зчитати кожен рядок з файлу та вивести на екран
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            // Закрити потоки після завершення
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void teamBattle() {
        List<Combatant> team1 = new ArrayList<>();
        List<Combatant> team2 = new ArrayList<>();
        List<Combatant> availableDroids = new ArrayList<>(Main.droid);

        System.out.println("Виберіть кількість учасників у командах:");
        int teamCount = scanner.nextInt();

        System.out.println("Додайте дроїдів до команди 1:");
        for (int i = 0; i < teamCount; i++) {
            team1.add(Main.chooseDroid(availableDroids));
        }

        System.out.println("Додайте дроїдів до команди 2:");
        for (int i = 0; i < teamCount; i++) {
            team2.add(Main.chooseDroid(availableDroids));
        }
        System.out.println("Початок командного поєдинку між командою 1 та командою 2");

        Random random = new Random();

        while (areAnyAlive(team1) && areAnyAlive(team2)) {
            Combatant attacker;
            Combatant defender;

            // Визначте, яка команда атакує і яка захищається
            if (random.nextBoolean()) {
                attacker = chooseRandomAliveDroid(team1, random);
                defender = chooseRandomAliveDroid(team2, random);
            } else {
                attacker = chooseRandomAliveDroid(team2, random);
                defender = chooseRandomAliveDroid(team1, random);
            }

            if (attacker != null && defender!=null) {
                attacker.performAction(defender);
                if (defender.isAlive()) {
                    defender.performAction(attacker);
                }
            }
        }
        if (areAnyAlive(team1)) {
            System.out.println("Команда 1 перемагає!");
            writeBattleToFile("Команда 1 перемагає!");
        } else {
            System.out.println("Команда 2 перемагає!");
            writeBattleToFile("Команда 2 перемагає!");
        }
    }

    // Перевірка, чи є ще живі дроїди в команді
    private static boolean areAnyAlive(List<Combatant> team) {
        for (Combatant droid : team) {
            if (droid.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    // Виберіть випадкового живого дроїда з команди
    private static Combatant chooseRandomAliveDroid(List<Combatant> team, Random random) {
        List<Combatant> aliveDroids = new ArrayList<>();
        for (Combatant droid : team) {
            if (droid.getHealth() > 0) {
                aliveDroids.add(droid);
            }
        }
        if (!aliveDroids.isEmpty()) {
            return aliveDroids.get(random.nextInt(aliveDroids.size()));
        } else {
            // Якщо всі дроїди мертві, поверніть null або обробте цей випадок за вашим вибором
            return null;
        }
    }

    public static void twoDroidBattle() {
        List<Combatant> availableDroids = new ArrayList<>(Main.droid);
        Combatant droid1 = Main.chooseDroid(availableDroids);
        Combatant droid2 = Main.chooseDroid(availableDroids);

        System.out.println("Початок поєдинку між " + droid1.getName() + " та " + droid2.getName());

        Random random = new Random();

        while (droid1.getHealth() > 0 && droid2.getHealth() > 0) {
            if (new Random().nextBoolean()) {
                droid1.performAction(droid2);
            } else {
                droid2.performAction(droid1);
            }
        }
        if(droid1.getHealth() > 0) {
            System.out.println(droid1.getName() + " перемагає!");
            writeBattleToFile(droid1.getName() + " перемагає!");
        } else {
            System.out.println(droid2.getName() + " перемагає!");
            writeBattleToFile(droid2.getName() + " перемагає!");
        }
    }
}