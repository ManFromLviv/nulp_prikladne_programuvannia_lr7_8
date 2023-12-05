package menu.commands.bouquet.create_or_edit_bouquet_commands.accessories;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.Command;

import java.util.ArrayList;

import static init_data.InitData.getListAllTypesAccessorieNow;

public class AppendAccessorieCommand implements Command {
    String lineTab;
    int countTab;
    int index;
    ArrayList<AbstractFlower> flowers;
    ArrayList<Accessorie> accessories;

    public AppendAccessorieCommand(int index, int countTab, ArrayList<Bouquet> bouquets, ArrayList<AbstractFlower> flowers, ArrayList<Accessorie> accessories) {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.index = index;
        this.flowers = flowers;
        this.accessories = accessories;
        execute(bouquets);
    }


    @Override
    public void execute(ArrayList<Bouquet> bouquets) {
        String listAccessories = getListAllTypesAccessorieNow(countTab, accessories);
        System.out.print(listAccessories);
        while (!accessories.isEmpty()) {
            String message = "Уведіть номер аксесуару для долучення";
            int number = Command.inputNumber(lineTab, message);
            if (number <= 0 || number > accessories.size()) {
                System.out.println(lineTab + "\tАксесуара з таким номером немає!");
            } else {
                bouquets.get(index).appendAccessorie(accessories.get(number - 1));
                break;
            }
        }
    }
}
