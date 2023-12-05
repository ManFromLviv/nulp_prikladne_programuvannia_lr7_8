package menu.commands.bouquet.create_or_edit_bouquet_commands;

import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class ViewCreateOrEditBouquetCommand implements Command {
    int countTab;
    String lineTab;
    int index;

    public ViewCreateOrEditBouquetCommand(int index, int countTab, ArrayList<Bouquet> bouquets) {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.index = index;
        execute(bouquets);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) {
        int number = bouquets.size();
        System.out.println(bouquets.get(index).toStringForList(number, countTab));
    }
}
