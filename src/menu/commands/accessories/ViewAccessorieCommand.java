package menu.commands.accessories;

import accessories.Accessorie;
import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class ViewAccessorieCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<Accessorie> accessories;

    public ViewAccessorieCommand(int countTab, ArrayList<Accessorie> accessories) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.accessories = accessories;
        execute(null);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        if (accessories.isEmpty()) {
            System.out.println(lineTab + "Зараз немає ні одного аксесуара!");
            return;
        }

        String message = "Уведіть номер аксесуара, який бажаєте побачити";
        int number = Command.inputNumber(lineTab, message);
        if (number <= 0 || number > accessories.size()) {
            System.out.println(lineTab + "Аксесуара з таким номером немає!");
            return;
        }
        System.out.println(lineTab + "\tАксесуар № " + number + ": " + accessories.get(number - 1));
    }
}
