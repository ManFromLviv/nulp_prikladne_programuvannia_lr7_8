package menu.commands.bouquet;

import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class ListBouquetsCommand implements Command {
    int countTab;
    String lineTab;

    public ListBouquetsCommand(int countTab, ArrayList<Bouquet> bouquets) {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        execute(bouquets);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) {
        if (bouquets.isEmpty()) {
            System.out.println(lineTab + "Зараз немає ні одного букета!");
            return;
        }

        System.out.println(lineTab + "СПИСОК УСІХ БУКЕТІВ:");
        int counter = 1;
        for (Bouquet bouquet : bouquets) {
            System.out.println(bouquet.toStringForList(counter++, countTab + 1));
        }
    }
}
