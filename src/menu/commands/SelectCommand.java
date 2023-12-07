package menu.commands;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.accessories.*;
import menu.commands.bouquet.*;
import menu.commands.bouquet.create_or_edit_bouquet_commands.CreateBouquetCommand;
import menu.commands.bouquet.create_or_edit_bouquet_commands.EditBouquetCommand;
import menu.commands.flowers.*;

import java.util.ArrayList;

import static files.Files.getTextFromFileMenu;
import static menu.Menu.logger;
import static menu.Menu.pathHeadMenu;

public class SelectCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<AbstractFlower> flowers;
    ArrayList<Accessorie> accessories;

    public SelectCommand(int countTab, ArrayList<Bouquet> bouquets, ArrayList<AbstractFlower> flowers, ArrayList<Accessorie> accessories) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.accessories = accessories;
        this.flowers = flowers;
        execute(bouquets);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        boolean isExit = false;
        do {
            System.out.print(getTextFromFileMenu(countTab, pathHeadMenu));
            String message = "Ваш вибір";
            int number = Command.inputNumber(lineTab, message);
            if (number > countCommandHeadMenu || number <= 0) {
                logger.info("Було введено помилковий пункт, головне меню повторюється");
                System.out.println(lineTab + "\tОберіть правильний пункт!");
                continue;
            }

            logger.info("Обрано головного меню № " + number);

            int countTabRunSubcommand = countTab + 1;
            switch (number) {
                case 1: new CreateBouquetCommand(countTabRunSubcommand, bouquets, flowers, accessories); break;
                case 2: new EditBouquetCommand(countTabRunSubcommand, bouquets, flowers, accessories); break;
                case 3: new ViewBouquetCommand(countTabRunSubcommand, bouquets); break;
                case 4: new ListBouquetsCommand(countTabRunSubcommand, bouquets); break;
                case 5: new DeleteBouquetCommand(countTabRunSubcommand, bouquets); break;
                case 6: new SortFlowersByFreshnessLevelBouquetCommand(countTabRunSubcommand, bouquets); break;
                case 7: new FindRangeByStemLengthFlowersBouquetCommand(countTabRunSubcommand, bouquets); break;
                case 8: new CreateFlowerCommand(countTabRunSubcommand, flowers); break;
                case 9: new EditFlowerCommand(countTabRunSubcommand, flowers); break;
                case 10: new DeleteFlowerCommand(countTabRunSubcommand, flowers); break;
                case 11: new ViewFlowerCommand(countTabRunSubcommand, flowers); break;
                case 12: new ViewListFlowersCommand(countTabRunSubcommand, flowers); break;
                case 13: new CreateAccessorieCommand(countTabRunSubcommand, accessories); break;
                case 14: new EditAccessorieCommand(countTabRunSubcommand, accessories); break;
                case 15: new DeleteAccessorieCommand(countTabRunSubcommand, accessories); break;
                case 16: new ViewAccessorieCommand(countTabRunSubcommand, accessories); break;
                case 17: new ViewListAccessoriesCommand(countTabRunSubcommand, accessories); break;
                default:
                    isExit = Command.comfirmOperation(lineTab + "\t", "+");
                    if (isExit) {
                        new ExitCommand(countTabRunSubcommand, bouquets, flowers, accessories);
                    } else {
                        System.out.println(lineTab + "\t\tОперацію було скасовано!");
                    }
            }
        } while (!isExit);
    }
}
