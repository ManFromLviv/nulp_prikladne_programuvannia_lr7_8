package menu.commands.bouquet;

import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class SortFlowersByFreshnessLevelBouquetCommand implements Command {
    int countTab;
    String lineTab;


    public SortFlowersByFreshnessLevelBouquetCommand(int countTab, ArrayList<Bouquet> bouquets) {
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

        String message = "Уведіть номер букета для сортування його квітів";
        int number = Command.inputNumber(lineTab, message);
        if (number <= bouquets.size() && number > 0) {
            bouquets.get(number - 1).sortFlowersByFreshnessLevel();
            System.out.println(lineTab + "Для букета № " + number + " було відсортовано квіти за рівнем свіжості:");
            bouquets.get(number - 1).getListFlowers(countTab + 1);
        } else {
            System.out.println(lineTab + "Букета з таким номером немає!");
        }
    }
}
