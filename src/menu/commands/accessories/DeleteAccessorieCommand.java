package menu.commands.accessories;

import accessories.Accessorie;
import bouquet.Bouquet;
import menu.commands.Command;

import java.util.ArrayList;

public class DeleteAccessorieCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<Accessorie> accessories;

    public DeleteAccessorieCommand(int countTab, ArrayList<Accessorie> accessories) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.accessories = accessories;
        execute(null);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        if (accessories.isEmpty()) {
            System.out.println(lineTab + "Зараз немає ні однієї аксесуара!");
            return;
        }

        String message = "Уведіть номер аксесуара, який бажаєте видалити";
        int number = Command.inputNumber(lineTab, message);
        if (number <= 0 || number > accessories.size()) {
            System.out.println(lineTab + "Аксесуара з таким номером немає!");
            return;
        }

        System.out.println(lineTab + "Аксесуар: " + accessories.get(number - 1));
        if (Command.comfirmOperation(lineTab, "+")) {
            accessories.remove(number - 1);
            System.out.println(lineTab + "Аксесуар № " + number + " був видалений, нумерація зсунулась!");
        } else {
            System.out.println(lineTab + "\tОперацію було скасовано!");
        }
    }
}
