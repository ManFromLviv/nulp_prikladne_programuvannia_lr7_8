package menu.commands.accessories;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.Command;

import java.util.ArrayList;

import static menu.commands.accessories.input_data.AccessoriesInputMethods.inputPriceAccessorie;
import static menu.commands.flowers.input_data.FlowersInputMethods.inputFreshnessLevel;
import static menu.commands.flowers.input_data.FlowersInputMethods.inputPriceFlower;

public class EditAccessorieCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<Accessorie> accessories;

    public EditAccessorieCommand(int countTab, ArrayList<Accessorie> accessories) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.accessories = accessories;
        execute(null);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        if (accessories.isEmpty()) {
            System.out.println(lineTab + "Зараз немає ні одного аксесуара!");
            return;
        }

        String message = "Уведіть номер аксесуара, який бажаєте редагувати";
        int number = Command.inputNumber(lineTab, message);
        if (number <= 0 || number > accessories.size()) {
            System.out.println(lineTab + "Аксесуара з таким номером немає!");
            return;
        }

        double priceAccessorie = inputPriceAccessorie(countTab + 1);
        System.out.println(lineTab + "Аксесуар було редаговано!");
        accessories.get(number - 1).setPrice(priceAccessorie);
        System.out.println(lineTab + "\t" + accessories.get(number - 1));
    }
}
