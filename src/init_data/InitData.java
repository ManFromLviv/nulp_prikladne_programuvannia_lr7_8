package init_data;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import flowers.ValidFlower;
import flowers.types.Aster;
import flowers.types.Lily;
import flowers.types.Rose;
import flowers.types.Tulip;

import java.util.ArrayList;

import static files.Files.*;
import static flowers.ValidFlower.getValidStringType;
import static menu.commands.Command.getLineTab;

public class InitData {
    static public final String initPathBouquet = "src/init_data/bouquet/";
    static public final String initPathFlowers = "src/init_data/flowers/flowers.txt";
    static public final String initPathAccessories = "src/init_data/accessories/accessories.txt";

    public static ArrayList<Accessorie> accessoriesNow = readFileAccessories(initPathAccessories);
    public static ArrayList<AbstractFlower> flowersNow = readFileFlowers(initPathFlowers);
    public static ArrayList<Bouquet> bouquetsNow = getBouquetsNow();

    public static AbstractFlower createFlower(ValidFlower.FLOWER_TYPE type, int stemLength, int freshnessLevel, double price, ValidFlower.FLOWER_COLOR color)  throws Exception {
        String name = getValidStringType(type) + " (" + ValidFlower.getValidStringColor(color) + ")";
        return switch (type) {
            case ROSE -> new Rose(stemLength, freshnessLevel, price, color, name, type);
            case TULIP -> new Tulip(stemLength, freshnessLevel, price, color, name, type);
            case ASTER -> new Aster(stemLength, freshnessLevel, price, color, name, type);
            case LILY -> new Lily(stemLength, freshnessLevel, price, color, name, type);
        };
    }

    static public String getListAllTypesFlowerNow(int countTab, ArrayList<AbstractFlower> flowers) {
        String lineTab = getLineTab(countTab);
        StringBuilder stringBuilder = new StringBuilder(lineTab).append("Список наявних квітів:").append("\n");
        int counter = 1;
        for (AbstractFlower flower : flowers) {
            stringBuilder.append(lineTab).append("\t").append(counter++).append(") ").append(flower).append("\n");
        }
        return stringBuilder.toString();
    }

    static public String getListAllTypesAccessorieNow(int countTab, ArrayList<Accessorie> accessories) {
        String lineTab = getLineTab(countTab);
        StringBuilder stringBuilder = new StringBuilder(lineTab).append("Список наявних аксесуарів:").append("\n");
        int counter = 1;
        for (Accessorie accessorie : accessories) {
            stringBuilder.append(lineTab).append("\t").append(counter++).append(") ").append(accessorie).append("\n");
        }
        return stringBuilder.toString();
    }

    static public ArrayList<Bouquet> getBouquetsNow() {
        ArrayList<String> filenames = getStringNamesRecordFiles(initPathBouquet);
        ArrayList<Bouquet> bouquets = new ArrayList<>();
        for (String filename : filenames) {
            bouquets.add(readFileBouquet(initPathBouquet + filename));
        }
        return bouquets;
    }

    static public void updateAllInitData(ArrayList<Bouquet> bouquets, ArrayList<AbstractFlower> flowers, ArrayList<Accessorie> accessories) {
        try {
            deleteAllFiles(initPathBouquet);
            int counter = 1;
            for (Bouquet bouquet : bouquets) {
                createFileBouquet(initPathBouquet, "bouquet", bouquet.getInitData(), Integer.toString(counter++));
            }

            int sizeFlowers = flowers.size();
            StringBuilder dataFlowers = new StringBuilder().append(sizeFlowers).append("\n");
            for (AbstractFlower flower : flowers) {
                dataFlowers.append(flower.getInitData());
            }
            createFileFlowersOrAccessories(initPathFlowers, dataFlowers.toString());

            int sizeAccessories = accessories.size();
            StringBuilder dataAccessories = new StringBuilder().append(sizeAccessories).append("\n");
            for (Accessorie accessorie : accessories) {
                dataAccessories.append(accessorie.getInitData());
            }
            createFileFlowersOrAccessories(initPathAccessories, dataAccessories.toString());
        } catch (Exception e) {
            System.out.println("Сталася помилка під час оновлення ініціалізуючих даних!" + e);
        }
    }
}
