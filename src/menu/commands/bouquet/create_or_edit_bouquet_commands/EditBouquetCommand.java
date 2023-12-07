package menu.commands.bouquet.create_or_edit_bouquet_commands;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.Command;

import java.util.ArrayList;

import static files.Files.getTextFromFileMenu;
import static menu.Menu.logger;
import static menu.Menu.pathSubMenu1And2;

public class EditBouquetCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<AbstractFlower> flowers;
    ArrayList<Accessorie> accessories;

    public EditBouquetCommand(int countTab, ArrayList<Bouquet> bouquets, ArrayList<AbstractFlower> flowers, ArrayList<Accessorie> accessories) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.accessories = accessories;
        this.flowers = flowers;
        execute(bouquets);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        if (bouquets.isEmpty()) {
            System.out.println(lineTab + "Зараз немає ні одного1 букета!");
            return;
        }

        String message = "Уведіть номер букета, який бажаєте редагувати";
        int number = Command.inputNumber(lineTab, message);
        if (number <= bouquets.size() && number > 0) {
            while (true) {
                System.out.print(getTextFromFileMenu(countTab, pathSubMenu1And2));
                message = "Оберіть пункт для редагування букету";
                int numberCommand = Command.inputNumber(lineTab, message);
                if (numberCommand > countCommandSubMenu1And2 || numberCommand <= 0) {
                    logger.info("Було введено помилковий пункт, головне меню для редагування повторюється");
                    System.out.println(lineTab + "\tОберіть правильний пункт!");
                } else if (new SelectCreateOrEditBouquetCommand(false, numberCommand, number - 1, countTab + 1, bouquets, flowers, accessories).getIsExit()) {
                    break;
                }
            }
        } else {
            System.out.println(lineTab + "Букета з таким номером немає!");
        }
    }
}
