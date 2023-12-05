package menu.commands.bouquet.create_or_edit_bouquet_commands;

import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class ExitFromCreateOrEditBouquet implements Command {
    int countTab;
    String lineTab;
    int index;
    boolean isCreateBouquet;


    public ExitFromCreateOrEditBouquet(boolean isCreateBouquet, int index, int countTab, ArrayList<Bouquet> bouquets) {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.index = index;
        this.isCreateBouquet = isCreateBouquet;
        execute(bouquets);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) {
        if (bouquets.get(index).getCountFlowers() == 0) {
            System.out.println(lineTab + "\tУ букеті не було виявлено квітів, букет не буде збережено!");
            bouquets.remove(index);
        } else {
            System.out.println(lineTab + "\tБукет № " + (index + 1) + " було успішно " + ((isCreateBouquet) ? "створено" : "редаговано") + "!");
        }
    }
}
