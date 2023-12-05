package menu.commands.bouquet.create_or_edit_bouquet_commands.flowers;

import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class RemoveFlowerCommand implements Command {
    String lineTab;
    int countTab;
    int index;

    public RemoveFlowerCommand(int index, int countTab, ArrayList<Bouquet> bouquets) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.index = index;
        execute(bouquets);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        Bouquet bouquet = bouquets.get(index);
        String listFlowers = bouquet.getListFlowers(countTab + 1);
        System.out.print(lineTab + "Список квітів у букеті:\n" + listFlowers);
        while (bouquet.getCountFlowers() != 0) {
            String message = "Уведіть номер квітки для вилучення";
            int number = Command.inputNumber(lineTab, message);
            if (number <= 0 || number > bouquet.getCountFlowers()) {
                System.out.println(lineTab + "\tКвітки з таким номером немає!");
            } else {
                bouquet.deleteFlower(number);
                break;
            }
        }
    }
}
