package bouquet;

import accessories.Accessorie;
import flowers.AbstractFlower;

import java.util.ArrayList;

public class Bouquet {
    private ArrayList<AbstractFlower> flowers;
    private ArrayList<Accessorie> accessories;
    private double price;

    public Bouquet() {
        flowers = new ArrayList<>();
        accessories = new ArrayList<>();
        price = 0;
    }

    public void clear() {
        flowers.clear();
        accessories.clear();
        price = 0;
    }

    public void appendFlower(AbstractFlower flower) {
        flowers.add(flower);
        price += flower.getPrice();
    }

    public void deleteFlower(int number) throws Exception {
        if (number <= flowers.size() && number > 0) {
            price -= flowers.get(number - 1).getPrice();
            flowers.remove(number - 1);
        } else {
            throw new Exception("Під час вилучення елемента з букету був помилково введений номер не існуючого об'єкта!");
        }
    }

    public void appendAccessorie(Accessorie accessorie) {
        accessories.add(accessorie);
        price += accessorie.getPrice();
    }

    public void deleteAccessorie(int number) throws Exception {
        if (number <= accessories.size() && number > 0) {
            price -= accessories.get(number - 1).getPrice();
            accessories.remove(number - 1);
        } else {
            throw new Exception("Під час вилучення елемента з букету був помилково введений номер не існуючого об'єкта!");
        }
    }

    public int getCountFlowers() {
        return flowers.size();
    }

    public int getCountAccessories() {
        return accessories.size();
    }

    public double getPrice() {
        return price;
    }

    private <T> String getListFlowersOrAccesories(int countTab, ArrayList<T> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringTab = new StringBuilder();
        for (int i = 1; i <= countTab; i++) {
            stringTab.append("\t");
        }
        if (!arrayList.isEmpty()) {
            int counter = 1;
            for (T obj : arrayList) {
                stringBuilder.append(stringTab).append(counter++).append(") ").append(obj).append("\n");
            }
        } else {
            stringBuilder.append(stringTab).append("Немає в букеті").append("\n");
        }
        return stringBuilder.toString();
    }

    public String getListFlowers(int countTab) {
        return getListFlowersOrAccesories(countTab, flowers);
    }

    public String getListAccessories(int countTab) {
        return getListFlowersOrAccesories(countTab, accessories);
    }

    public void sortFlowersByFreshnessLevel() {
        for (int i = 1; i < flowers.size(); i++) {
            for (int j = 0; j < flowers.size() - i; j++) {
                AbstractFlower flower1 = flowers.get(j);
                AbstractFlower flower2 = flowers.get(j + 1);
                if (flower1.getFreshnessLevel() > flower2.getFreshnessLevel()) {
                    flowers.set(j, flower2);
                    flowers.set(j + 1, flower1);
                }
            }
        }
    }

    public String findRangeByStemLengthFlowers(int minStemLength, int maxStemLength, int countTab) {
        StringBuilder lineTab = new StringBuilder("");
        for (int i = 1; i <= countTab; i++) {
            lineTab.append("\t");
        }
        StringBuilder stringBuilder = new StringBuilder(lineTab);
        stringBuilder.append("Список квітів заданим діпазоном стебла [").append(minStemLength).append("; ").append(maxStemLength).append("]:\n");
        int count = 0, counter = 1;
        for (AbstractFlower flower : flowers) {
            if (flower.getStemLength() >= minStemLength && flower.getStemLength() <= maxStemLength) {
                stringBuilder.append(lineTab).append("\t").append(counter++).append(") ").append(flower).append("\n");
                count++;
            }
        }
        if (count == 0) {
            stringBuilder.append(lineTab).append("\tЗа заданим діапазоном нічого не знайдено").append("\n");
        } else {
            stringBuilder.append(lineTab).append("\tЗАГАЛЬНА КІЛЬКІСТЬ: ").append(count).append("\n");
        }
        return stringBuilder.toString();
    }

    public String getInitData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(price).append("\n");
        stringBuilder.append(flowers.size()).append("\n");
        stringBuilder.append(accessories.size()).append("\n");
        for (AbstractFlower flower : flowers) {
            stringBuilder.append(flower.getInitData());
        }
        for (Accessorie accessorie : accessories) {
            stringBuilder.append(accessorie.getInitData());
        }
        return stringBuilder.toString();
    }

    public String toStringForList(int number, int countTab) {
        double priceFormatted = (int) (price * 100.0) / 100.0;
        StringBuilder lineTab = new StringBuilder();
        for (int i = 1; i <= countTab; i++) {
            lineTab.append("\t");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lineTab).append("Букет № ").append(number).append("\n");
        stringBuilder.append(lineTab).append("\tКвіти:\n");
        stringBuilder.append(getListFlowers(countTab + 2));
        stringBuilder.append(lineTab).append("\tАксесуари:\n");
        stringBuilder.append(getListAccessories(countTab + 2));
        stringBuilder.append(lineTab).append("\tЦІНА ЗА БУКЕТ: ").append(priceFormatted);
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        double priceFormatted = (int) (price * 100.0) / 100.0;
        final int countTabForList = 2;
        StringBuilder stringBuilder = new StringBuilder("Букет:\n");
        stringBuilder.append("\tКвіти:\n");
        stringBuilder.append(getListFlowers(countTabForList));
        stringBuilder.append("\tАксесуари:\n");
        stringBuilder.append(getListAccessories(countTabForList));
        stringBuilder.append("\tЦІНА ЗА БУКЕТ: ").append(priceFormatted);
        return stringBuilder.toString();
    }
}
