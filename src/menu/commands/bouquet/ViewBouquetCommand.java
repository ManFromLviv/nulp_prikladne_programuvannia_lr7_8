package menu.commands.bouquet;

import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class ViewBouquetCommand implements Command {
    int countTab;
    String lineTab;


    public ViewBouquetCommand(int countTab, ArrayList<Bouquet> bouquets) {
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

        String message = "Уведіть номер букета, який бажаєте переглянути";
        int number = Command.inputNumber(lineTab, message);
        if (number <= bouquets.size() && number > 0) {
            System.out.println(bouquets.get(number - 1).toStringForList(number, countTab));
        } else {
            System.out.println(lineTab + "Букета з таким номером немає!");
        }
    }
}

