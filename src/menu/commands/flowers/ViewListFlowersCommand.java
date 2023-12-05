package menu.commands.flowers;

import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.Command;

import java.awt.*;
import java.util.ArrayList;

import static init_data.InitData.getListAllTypesFlowerNow;

public class ViewListFlowersCommand implements Command {
    int countTab;
    String lineTab;
    ArrayList<AbstractFlower> flowers;

    public ViewListFlowersCommand(int countTab, ArrayList<AbstractFlower> flowers) {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.flowers = flowers;
        execute(null);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) {
        if (flowers.isEmpty()) {
            System.out.println(lineTab + "Зараз немає ні однієї квітки!");
            return;
        }

        System.out.print(getListAllTypesFlowerNow(countTab + 1, flowers));
    }

}
