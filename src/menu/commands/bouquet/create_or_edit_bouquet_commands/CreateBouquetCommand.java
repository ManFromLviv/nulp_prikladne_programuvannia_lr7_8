package menu.commands.bouquet.create_or_edit_bouquet_commands;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.Command;

import java.util.ArrayList;

import static files.Files.getTextFromFileMenu;
import static menu.Menu.logger;
import static menu.Menu.pathSubMenu1And2;

public class CreateBouquetCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<AbstractFlower> flowers;
    ArrayList<Accessorie> accessories;

    public CreateBouquetCommand(int countTab, ArrayList<Bouquet> bouquets, ArrayList<AbstractFlower> flowers, ArrayList<Accessorie> accessories) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.accessories = accessories;
        this.flowers = flowers;
        execute(bouquets);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        bouquets.add(new Bouquet());
        while (true) {
            System.out.print(getTextFromFileMenu(countTab, pathSubMenu1And2));
            String message = "Оберіть пункт для створюваного букету";
            int number = Command.inputNumber(lineTab, message);
            if (number > countCommandSubMenu1And2 || number <= 0) {
                logger.info("Було введено помилковий пункт, головне меню для створення повторюється");
                System.out.println(lineTab + "\tОберіть правильний пункт!");
            } else if (new SelectCreateOrEditBouquetCommand(true, number, bouquets.size() - 1, countTab + 1, bouquets, flowers, accessories).getIsExit()) {
                break;
            }
        }
    }
}
