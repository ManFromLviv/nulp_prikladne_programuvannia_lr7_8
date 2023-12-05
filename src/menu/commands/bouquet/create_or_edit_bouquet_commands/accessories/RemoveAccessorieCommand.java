package menu.commands.bouquet.create_or_edit_bouquet_commands.accessories;

import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class RemoveAccessorieCommand implements Command {
    String lineTab;
    int countTab;
    int index;

    public RemoveAccessorieCommand(int index, int countTab, ArrayList<Bouquet> bouquets) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.index = index;
        execute(bouquets);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        Bouquet bouquet = bouquets.get(index);
        String listFlowers = bouquet.getListAccessories(countTab + 1);
        System.out.print(lineTab + "Список аксесуарів у букеті:\n" + listFlowers);
        while (bouquet.getCountAccessories() != 0) {
            String message = "Уведіть номер аксесуарів для вилучення";
            int number = Command.inputNumber(lineTab, message);
            if (number <= 0 || number > bouquet.getCountAccessories()) {
                System.out.println(lineTab + "\tАксесуара з таким номером немає!");
            } else {
                bouquet.deleteAccessorie(number);
                break;
            }
        }
    }
}
