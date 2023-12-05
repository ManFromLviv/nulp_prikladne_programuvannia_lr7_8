package menu.commands.bouquet;

import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class DeleteBouquetCommand implements Command {
    int countTab;
    String lineTab;


    public DeleteBouquetCommand(int countTab, ArrayList<Bouquet> bouquets) {
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

        String message = "Уведіть номер букета, який бажаєте видалити";
        int number = Command.inputNumber(lineTab, message);
        if (number <= 0 || number > bouquets.size()) {
            System.out.println(lineTab + "Букета з таким номером немає!");
            return;
        }

        System.out.println(bouquets.get(number - 1).toStringForList(number, countTab));
        if (Command.comfirmOperation(lineTab, "+")) {
            bouquets.remove(number - 1);
            System.out.println(lineTab + "Букета № " + number + " був  видалений, нумерація зсунулась!");
        } else {
            System.out.println(lineTab + "\tОперацію було скасовано!");
        }
    }
}

