package menu.commands.flowers.input_data;

import flowers.ValidFlower;
import menu.commands.Command;

import static files.Files.getTextFromFileMenu;
import static flowers.ValidFlower.*;
import static menu.Menu.*;

public class FlowersInputMethods {
    static public FLOWER_TYPE inputFlowerType(int countTab) {
        String lineTab = Command.getLineTab(countTab);
        System.out.print(getTextFromFileMenu(countTab, pathInputTypeFlower));
        int number;
        while (true) {
            String message = "Уведіть тип для створюваної квітки";
            number = Command.inputNumber(lineTab, message);
            if (number >= 1 && number <= FLOWER_TYPE.values().length) {
                break;
            }
            System.out.println(lineTab + "\tОберіть значення з пункту!");
        }

        return switch (number) {
            case 1 -> FLOWER_TYPE.ROSE;
            case 2 -> FLOWER_TYPE.TULIP;
            case 3 -> FLOWER_TYPE.LILY;
            case 4 -> FLOWER_TYPE.ASTER;
            default -> throw new IllegalStateException("Невідоме значення типу квітки: " + number);
        };
    }

    static public FLOWER_COLOR inputFlowerColor(int countTab) {
        String lineTab = Command.getLineTab(countTab);
        System.out.print(getTextFromFileMenu(countTab, pathInputColorFlower));
        int number;
        while (true) {
            String message = "Уведіть колір для створюваної квітки";
            number = Command.inputNumber(lineTab, message);
            if (number >= 1 && number <= FLOWER_COLOR.values().length) {
                break;
            }
            System.out.println(lineTab + "\tОберіть значення з пункту!");
        }

        return switch (number) {
            case 1 -> FLOWER_COLOR.BLACK;
            case 2 -> FLOWER_COLOR.YELLOW;
            case 3 -> FLOWER_COLOR.WHITE;
            case 4 -> FLOWER_COLOR.RED;
            case 5 -> FLOWER_COLOR.ORANGE;
            default -> throw new IllegalStateException("Невідоме значення кольору квітки: " + number);
        };
    }

    static public int inputStemLength(int countTab) {
        String lineTab = Command.getLineTab(countTab);
        String validRangeStr = new StringBuilder("").append(minStemLength).append("; ").append(maxStemLength).toString();
        int number;
        while (true) {
            String message = "Уведіть довжину стебла квітки з діапазону [" + validRangeStr + "]";
            number = Command.inputNumber(lineTab, message);
            if (ValidFlower.isValidStemLength(number)) {
                return number;
            }
            System.out.println(lineTab + "\tОберіть значення з діапазону!");
        }
    }

    static public int inputFreshnessLevel(int countTab) {
        String lineTab = Command.getLineTab(countTab);
        int number;
        System.out.print(getTextFromFileMenu(countTab, pathInputFreshnessLevelFlower));
        while (true) {
            String message = "Уведіть рівень свіжості квітки";
            number = Command.inputNumber(lineTab, message);
            if (ValidFlower.isValidFreshnessLevel(number)) {
                return number;
            }
            System.out.println(lineTab + "\tОберіть значення з пункту!");
        }
    }

    static public double inputPriceFlower(int countTab) {
        String lineTab = Command.getLineTab(countTab);
        String validRangeStr = new StringBuilder("").append(minPrice).append("; ").append(maxPrice).toString();
        double number;
        while (true) {
            String message = "Уведіть ціну квітки в діапазоні [" + validRangeStr + "]";
            number = Command.inputFractionNumber(lineTab, message);
            if (ValidFlower.isValidPrice(number)) {
                return (int) (number * 100.0) / 100.0;
            }
            System.out.println(lineTab + "\tОберіть значення з діапазону!");
        }
    }
}
