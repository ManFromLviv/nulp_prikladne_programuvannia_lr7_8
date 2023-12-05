package menu.commands.bouquet.create_or_edit_bouquet_commands.flowers;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.Command;

import java.util.ArrayList;

import static init_data.InitData.getListAllTypesFlowerNow;

public class AppendFlowerCommand implements Command {
    String lineTab;
    int countTab;
    int index;
    ArrayList<AbstractFlower> flowers;
    ArrayList<Accessorie> accessories;

    public AppendFlowerCommand(int index, int countTab, ArrayList<Bouquet> bouquets, ArrayList<AbstractFlower> flowers, ArrayList<Accessorie> accessories) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.index = index;
        this.accessories = accessories;
        this.flowers = flowers;
        execute(bouquets);
    }


    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        String listFlowers = getListAllTypesFlowerNow(countTab, flowers);
        System.out.print(listFlowers);
        while (!flowers.isEmpty()) {
            String message = "Уведіть номер квітки для долучення";
            int number = Command.inputNumber(lineTab, message);
            if (number <= 0 || number > flowers.size()) {
                System.out.println(lineTab + "\tКвітки з таким номером немає!");
            } else {
                bouquets.get(index).appendFlower(flowers.get(number - 1));
                break;
            }
        }
    }
}
