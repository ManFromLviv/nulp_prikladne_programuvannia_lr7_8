package menu.commands.flowers;

import bouquet.Bouquet;
import flowers.AbstractFlower;
import menu.commands.Command;

import java.util.ArrayList;

public class DeleteFlowerCommand implements Command {
    String lineTab;
    int countTab;
    ArrayList<AbstractFlower> flowers;

    public DeleteFlowerCommand(int countTab, ArrayList<AbstractFlower> flowers) throws Exception {
        this.countTab = countTab;
        lineTab = Command.getLineTab(countTab);
        this.flowers = flowers;
        execute(null);
    }

    @Override
    public void execute(ArrayList<Bouquet> bouquets) throws Exception {
        if (flowers.isEmpty()) {
            System.out.println(lineTab + "Зараз немає ні однієї квітки!");
            return;
        }

        String message = "Уведіть номер квітки, яку бажаєте видалити";
        int number = Command.inputNumber(lineTab, message);
        if (number <= 0 || number > flowers.size()) {
            System.out.println(lineTab + "Квітки з таким номером немає!");
            return;
        }

        System.out.println(lineTab + "Квітка: " + flowers.get(number - 1));
        if (Command.comfirmOperation(lineTab, "+")) {
            flowers.remove(number - 1);
            System.out.println(lineTab + "Квітка № " + number + " була видалена, нумерація зсунулась!");
        } else {
            System.out.println(lineTab + "\tОперацію було скасовано!");
        }
    }
}
