package menu;

import menu.commands.SelectCommand;
import org.apache.log4j.Logger;

import static init_data.InitData.*;


public class Menu {
    public static final String pathHeadMenu = "src/menu/text_menu/headMenu.txt";
    public static final String pathSubMenu1And2 = "src/menu/text_menu/subMenu1And2.txt";
    public static final String pathInputTypeFlower = "src/menu/text_menu/inputTypeFlower.txt";
    public static final String pathInputColorFlower = "src/menu/text_menu/inputColorFlower.txt";
    public static final String pathInputFreshnessLevelFlower = "src/menu/text_menu/inputFreshnessLevelFlower.txt";

    public static Logger logger = Logger.getLogger("ЛР № 4-8");

    public static void runMenu() throws InterruptedException {
        try {
            logger.info("Запуск програми");
            new SelectCommand(0, bouquetsNow, flowersNow, accessoriesNow);
            logger.info("Відбувся вихід з головного меню користувачем");
        } catch (Exception e) {
            String messageError = "Під час виконання програми трапилася критична помилка!" + e.toString();
            System.out.println(messageError);
            logger.info(messageError);
        } finally {
            System.out.println("\nПрограму розробив Вальчевський П., група ОІ-11сп для ЛР № 4-8 з Прикладного програмування!");
            System.out.println("Програму завершено!");
            for (int i = 3; i >= 1; i--) {
                System.out.println("\tВікно програми закриється через: " + i);
                Thread.sleep(1000);
            }
            logger.info("Закривається вікно програми й програма завершує роботу");
        }
    }
}
