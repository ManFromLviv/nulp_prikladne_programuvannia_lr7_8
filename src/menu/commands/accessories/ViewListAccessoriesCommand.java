package menu.commands.accessories;

import accessories.Accessorie;
import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

import static init_data.InitData.getListAllTypesAccessorieNow;

public class ViewListAccessoriesCommand implements Command {
    int countTab;
    String lineTab;
    ArrayList<Accessorie> accessories;

    public ViewListAccessoriesCommand(int countTab, ArrayList<Accessorie> accessories) {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.accessories = accessories;
        execute(null);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) {
        if (accessories.isEmpty()) {
            System.out.println(lineTab + "Зараз немає ні одного аксесуара!");
            return;
        }

        System.out.print(getListAllTypesAccessorieNow(countTab + 1, accessories));
    }
}
