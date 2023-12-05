package menu.commands.accessories.input_data;

import menu.commands.Command;

import static accessories.Accessorie.*;


public class AccessoriesInputMethods {
    static public double inputPriceAccessorie(int countTab) {
        String lineTab = Command.getLineTab(countTab);
        String validRangeStr = new StringBuilder("").append(MIN_PRICE).append("; ").append(MAX_PRICE).toString();
        double number;
        while (true) {
            String message = "Уведіть ціну аксесуара в діапазоні [" + validRangeStr + "]";
            number = Command.inputFractionNumber(lineTab, message);
            if (isValidPrice(number)) {
                return (int) (number * 100.0) / 100.0;
            }
            System.out.println(lineTab + "\tОберіть значення з діапазону!");
        }
    }

    static public String inputNameOrDescription(int countTab, boolean isName) {
        String lineTab = Command.getLineTab(countTab);
        String strTypeInput = (isName) ? "ім'я" : "опис";
        while (true) {
            String message = "Уведіть " + strTypeInput + " аксесуара";
            return Command.inputString(lineTab, message);
        }
    }
}
