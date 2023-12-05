package menu.commands.accessories;

import accessories.Accessorie;
import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

import static menu.commands.accessories.input_data.AccessoriesInputMethods.inputNameOrDescription;
import static menu.commands.accessories.input_data.AccessoriesInputMethods.inputPriceAccessorie;

public class CreateAccessorieCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<Accessorie> accessories;

    public CreateAccessorieCommand(int countTab, ArrayList<Accessorie> accessories) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.accessories = accessories;
        execute(null);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        String name = inputNameOrDescription(countTab, true);
        String description = inputNameOrDescription(countTab, false);
        double priceFlower = inputPriceAccessorie(countTab);
        accessories.add(new Accessorie(name, description, priceFlower));
        System.out.println(lineTab + "Аксесуар було створено! Його номер: " + accessories.size());
        System.out.println(lineTab + "\t" + accessories.get(accessories.size() - 1));
    }
}
