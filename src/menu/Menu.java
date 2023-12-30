package menu;
import arena.Arena;
import main.Main;
import java.util.Scanner;
public class Menu {
    private final static Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\u001B[35m"+"\u001B[1m"+"Меню:"+"\u001B[0m");
        System.out.println("\u001B[93m"+"1. Створити дроїда."+"\u001B[0m");
        System.out.println("\u001B[93m"+"2. Показати список створених дроїдів."+"\u001B[0m");
        System.out.println("\u001B[93m"+"3. Запустити бій 1 на 1."+"\u001B[0m");
        System.out.println("\u001B[93m"+"4. Запустити бій команда на команду."+"\u001B[0m");
        System.out.println("\u001B[93m"+"5. Відтворити проведений бій зі збереженого файлу."+"\u001B[0m");
        System.out.println("\u001B[93m"+"6. Вийти з програми."+"\u001B[0m");
    }
    public void handleMenuInput() {
        while (true) {
            displayMenu();
            System.out.print("\u001B[35m"+"\u001B[4m"+"Виберіть опцію: "+"\u001B[0m");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера введення

            switch (choice) {
                case 1 ->
                    // Логіка для створення дроїда
                        Main.createDroid();
                case 2 -> {
                    // Логіка для відображення списку дроїдів
                    System.out.println("Список дроїдів:");
                    Main.showDroidList(Main.droid);
                }
                case 3 ->
                    // Логіка для запуску бою 1 на 1
                        Arena.twoDroidBattle();
                case 4 ->
                    // Логіка для запуску бою команда на команду
                        Arena.teamBattle();
                case 5 ->
                    // Логіка для відтворення бою з файлу
                        Arena.readBattleFromFile();
                case 6 -> {
                    System.out.println("Завершення роботи програми.");
                    System.exit(0);
                }
                default -> System.out.println("Неправильний вибір. Спробуйте знову.");
            }
        }
    }
}