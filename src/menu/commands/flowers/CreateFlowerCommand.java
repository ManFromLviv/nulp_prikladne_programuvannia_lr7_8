package menu.commands.flowers;

import bouquet.Bouquet;
import flowers.AbstractFlower;
import flowers.ValidFlower.FLOWER_COLOR;
import flowers.ValidFlower.FLOWER_TYPE;
import menu.commands.Command;

import java.util.ArrayList;

import static init_data.InitData.createFlower;
import static menu.commands.flowers.input_data.FlowersInputMethods.*;

public class CreateFlowerCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<AbstractFlower> flowers;

    public CreateFlowerCommand(int countTab, ArrayList<AbstractFlower> flowers) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.flowers = flowers;
        execute(null);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        FLOWER_TYPE type = inputFlowerType(countTab);
        FLOWER_COLOR color = inputFlowerColor(countTab);
        int stemLength = inputStemLength(countTab);
        int freshnessLevel = inputFreshnessLevel(countTab);
        double priceFlower = inputPriceFlower(countTab);
        flowers.add(createFlower(type, stemLength, freshnessLevel, priceFlower, color));
        System.out.println(lineTab + "Квітку було створено! Її номер: " + flowers.size());
        System.out.println(lineTab + "\t" + flowers.get(flowers.size() - 1));
    }
}
