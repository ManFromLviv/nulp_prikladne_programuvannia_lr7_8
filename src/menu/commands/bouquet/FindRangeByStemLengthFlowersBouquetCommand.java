package menu.commands.bouquet;

import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class FindRangeByStemLengthFlowersBouquetCommand implements Command {
    int countTab;
    String lineTab;


    public FindRangeByStemLengthFlowersBouquetCommand(int countTab, ArrayList<Bouquet> bouquets) {
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
            while (true) {
                message = "Уведіть мінімальну довжину стебла";
                int minStemLength = Command.inputNumber(lineTab + "\t", message);
                message = "Уведіть максимальну довжину стебла";
                int maxStemLength = Command.inputNumber(lineTab + "\t", message);
                if (minStemLength <= maxStemLength) {
                    System.out.println(bouquets.get(number - 1).findRangeByStemLengthFlowers(minStemLength, maxStemLength, countTab + 2));
                    return;
                }
                System.out.println(lineTab + "\t\tПотрібно ввести коректні дані - [min, max]!");
            }
        } else {
            System.out.println(lineTab + "Букета з таким номером немає!");
        }
    }
}
