package menu;

import menu.commands.SelectCommand;

import static init_data.InitData.*;


public class Menu {
    public static final String pathHeadMenu = "src/menu/text_menu/headMenu.txt";
    public static final String pathSubMenu1And2 = "src/menu/text_menu/subMenu1And2.txt";
    public static final String pathInputTypeFlower = "src/menu/text_menu/inputTypeFlower.txt";
    public static final String pathInputColorFlower = "src/menu/text_menu/inputColorFlower.txt";
    public static final String pathInputFreshnessLevelFlower = "src/menu/text_menu/inputFreshnessLevelFlower.txt";

    public static void runMenu() throws InterruptedException {
        try {
            new SelectCommand(0, bouquetsNow, flowersNow, accessoriesNow);
        } catch (Exception e) {
            System.out.println("Під час виконання програми трапилася критична помилка!" + e);
        } finally {
            System.out.println("\nПрограму розробив Вальчевський П., група ОІ-11сп для ЛР № 4-8 з Прикладного програмування!");
            System.out.println("Програму завершено!");
            for (int i = 3; i >= 1; i--) {
                System.out.println("\tВікно програми закриється через: " + i);
                Thread.sleep(1000);
            }
        }
    }
}
