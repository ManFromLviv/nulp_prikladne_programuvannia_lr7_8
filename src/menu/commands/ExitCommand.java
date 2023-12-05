package menu.commands;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;

import java.util.ArrayList;

import static init_data.InitData.*;

public class ExitCommand implements Command {

    int countTab;
    String lineTab;
    ArrayList<AbstractFlower> flowers;
    ArrayList<Accessorie> accessories;

    public ExitCommand(int countTab, ArrayList<Bouquet> bouquets, ArrayList<AbstractFlower> flowers, ArrayList<Accessorie> accessories) {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.flowers = flowers;
        this.accessories = accessories;
        execute(bouquets);
    }


    @Override
    public void execute(ArrayList<Bouquet> bouquets) {
        updateAllInitData(bouquets, flowers, accessories);
    }
}

