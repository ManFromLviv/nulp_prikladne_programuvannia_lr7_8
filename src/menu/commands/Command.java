package menu.commands;

import bouquet.Bouquet;

import java.util.ArrayList;
import java.util.Scanner;


public interface Command {
    int countCommandHeadMenu = 18;
    int countCommandSubMenu1And2 = 6;

    void execute(ArrayList<Bouquet> bouquets) throws Exception;

    static String getLineTab(int countTab) {
        StringBuilder line = new StringBuilder("");
        for (int i = 1; i <= countTab; i++) {
            line.append("\t");
        }
        return line.toString();
    }

    static int inputNumber(String lineTab, String message) {
        while (true) {
            try {
                System.out.print(lineTab + message + ": ");
                return new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println(lineTab + "\tТут порібно ввести число!");
            }
        }
    }

    static double inputFractionNumber(String lineTab, String message) {
        while (true) {
            try {
                System.out.print(lineTab + message + ": ");
                double number = new Scanner(System.in).nextDouble();
                return Math.round(number * 100.0) / 100.0;
            } catch (Exception e) {
                System.out.println(lineTab + "\tТут порібно ввести число!");
            }
        }
    }

    static String inputString(String lineTab, String message) {
        while (true) {
            try {
                System.out.print(lineTab + message + ": ");
                return new Scanner(System.in).next();
            } catch (Exception e) {
                System.out.println(lineTab + "\tПомилка вводу рядка!");
            }
        }
    }

    static boolean comfirmOperation(String lineTab, String comfirmMessage) {
        System.out.print(lineTab + "Для підтвердження операції уведіть '" + comfirmMessage + "': ");
        return new Scanner(System.in).nextLine().equals(comfirmMessage);
    }
}
