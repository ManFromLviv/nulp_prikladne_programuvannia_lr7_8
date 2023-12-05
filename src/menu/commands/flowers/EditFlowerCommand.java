package menu.commands.flowers;

import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.Command;

import java.util.ArrayList;

import static menu.commands.flowers.input_data.FlowersInputMethods.*;

public class EditFlowerCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<AbstractFlower> flowers;

    public EditFlowerCommand(int countTab, ArrayList<AbstractFlower> flowers) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.flowers = flowers;
        execute(null);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        if (flowers.isEmpty()) {
            System.out.println(lineTab + "Зараз немає ні однієї квітки!");
            return;
        }

        String message = "Уведіть номер квітки, яку бажаєте редагувати";
        int number = Command.inputNumber(lineTab, message);
        if (number <= 0 || number > flowers.size()) {
            System.out.println(lineTab + "Квітки з таким номером немає!");
            return;
        }

        int freshnessLevel = inputFreshnessLevel(countTab + 1);
        double priceFlower = inputPriceFlower(countTab + 1);
        System.out.println(lineTab + "Квітку було редаговано!");
        AbstractFlower flower = flowers.get(number - 1);
        flower.setPrice(priceFlower);
        flower.setFreshnessLevel(freshnessLevel);
        System.out.println(lineTab + "\t" + flower);
    }
}
