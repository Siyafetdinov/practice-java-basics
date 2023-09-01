package ru.test.Utils;

public class UtilsMenu {

    public static void displayMenu(String heading, String[] item, int startCounting) {
        System.out.println("\n" + heading + "\n");
        for (int i = 0; i < item.length; i++) {
            System.out.println((i + startCounting) + ". " + item[i]);
        }
    }

    public static void exitMenu() {
        System.out.println("Для продолжения нажмите Enter");
        UtilsScanner.getStringConsole();
    }

    public static String indent() {
        return ("\n------------------------");
    }
}
