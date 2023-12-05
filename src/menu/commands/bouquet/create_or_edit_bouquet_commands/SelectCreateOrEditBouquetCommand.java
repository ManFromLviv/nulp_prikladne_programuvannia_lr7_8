package menu.commands.bouquet.create_or_edit_bouquet_commands;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.Command;
import menu.commands.bouquet.create_or_edit_bouquet_commands.accessories.AppendAccessorieCommand;
import menu.commands.bouquet.create_or_edit_bouquet_commands.accessories.RemoveAccessorieCommand;
import menu.commands.bouquet.create_or_edit_bouquet_commands.flowers.AppendFlowerCommand;
import menu.commands.bouquet.create_or_edit_bouquet_commands.flowers.RemoveFlowerCommand;

import java.util.ArrayList;

public class SelectCreateOrEditBouquetCommand implements Command {
    String lineTab;
    int countTab;
    int number;
    int index;
    boolean isExit;
    boolean isCreateBouquet;
    ArrayList<AbstractFlower> flowers;
    ArrayList<Accessorie> accessories;

    public SelectCreateOrEditBouquetCommand(boolean isCreateBouquet, int numberCommand, int indexBouquet, int countTab, ArrayList<Bouquet> bouquets, ArrayList<AbstractFlower> flowers, ArrayList<Accessorie> accessories) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.number = numberCommand;
        this.index = indexBouquet;
        isExit = false;
        this.isCreateBouquet = isCreateBouquet;
        this.flowers = flowers;
        this.accessories = accessories;
        execute(bouquets);
    }

    boolean getIsExit() {
        return isExit;
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        switch (number) {
            case 1: new AppendFlowerCommand(index, countTab, bouquets, flowers, accessories); break;
            case 2: new RemoveFlowerCommand(index, countTab, bouquets); break;
            case 3: new AppendAccessorieCommand(index, countTab, bouquets, flowers, accessories); break;
            case 4: new RemoveAccessorieCommand(index, countTab, bouquets); break;
            case 5: new ViewCreateOrEditBouquetCommand(index, countTab, bouquets); break;
            default:
                isExit = Command.comfirmOperation(lineTab + "\t", "+");
                if (isExit) {
                    new ExitFromCreateOrEditBouquet(isCreateBouquet, index, countTab, bouquets);
                } else {
                    System.out.println(lineTab + "\t\tОперацію було скасовано!");
                }
        }
    }
}
