package files;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import flowers.ValidFlower.FLOWER_COLOR;
import flowers.ValidFlower.FLOWER_TYPE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;

import static init_data.InitData.createFlower;
import static menu.commands.Command.getLineTab;

public class Files {
    public static String createFileBouquet(String directoryPath, String nameObjectInFile, String data, String idFile) {
        String filename = directoryPath + nameObjectInFile + "_" + idFile + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            System.out.println("Помилка запису файлу! " + e);
        }
        return filename;
    }

    public static Bouquet readFileBouquet(String filename) {
        Bouquet bouquet = new Bouquet();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            double price = Double.parseDouble(line);
            line = reader.readLine();
            int countFlower = Integer.parseInt(line);
            line = reader.readLine();
            int countAcessorie = Integer.parseInt(line);
            for (int i = 1; i <= countFlower; i++) {
                line = reader.readLine();
                FLOWER_TYPE type = FLOWER_TYPE.valueOf(line);
                line = reader.readLine();
                int stemLength = Integer.parseInt(line);
                line = reader.readLine();
                int freshnessLevel = Integer.parseInt(line);
                line = reader.readLine();
                double priceFlower = Double.parseDouble(line);
                line = reader.readLine();
                FLOWER_COLOR color = FLOWER_COLOR.valueOf(line);
                bouquet.appendFlower(createFlower(type, stemLength, freshnessLevel, priceFlower, color));
            }
            for (int i = 1; i <= countAcessorie; i++) {
                line = reader.readLine();
                String name = line;
                line = reader.readLine();
                String description = line;
                line = reader.readLine();
                double priceAccessorie = Double.parseDouble(line);
                bouquet.appendAccessorie(new Accessorie(name, description, priceAccessorie));
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Помилка зчитування файлу! " + e);
        }
        return bouquet;
    }

    public static void createFileFlowersOrAccessories(String filename, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            System.out.println("Помилка запису файлу! " + e);
        }
    }

    public static ArrayList<AbstractFlower> readFileFlowers(String filename) {
        ArrayList<AbstractFlower> flowers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            int countFlower = Integer.parseInt(line);
            for (int i = 1; i <= countFlower; i++) {
                line = reader.readLine();
                FLOWER_TYPE type = FLOWER_TYPE.valueOf(line);
                line = reader.readLine();
                int stemLength = Integer.parseInt(line);
                line = reader.readLine();
                int freshnessLevel = Integer.parseInt(line);
                line = reader.readLine();
                double priceFlower = Double.parseDouble(line);
                line = reader.readLine();
                FLOWER_COLOR color = FLOWER_COLOR.valueOf(line);
                flowers.add(createFlower(type, stemLength, freshnessLevel, priceFlower, color));
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Помилка зчитування файлу! " + e);
        }
        return flowers;
    }

    public static ArrayList<Accessorie> readFileAccessories(String filename) {
        ArrayList<Accessorie> accessories = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            int countFlower = Integer.parseInt(line);
            for (int i = 1; i <= countFlower; i++) {
                line = reader.readLine();
                String name = line;
                line = reader.readLine();
                String description = line;
                line = reader.readLine();
                double priceAccessorie = Double.parseDouble(line);
                accessories.add(new Accessorie(name, description, priceAccessorie));
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Помилка зчитування файлу! " + e);
        }
        return accessories;
    }

    public static String getTextFromFileMenu(int countTab, String filename) {
        String lineTab = getLineTab(countTab);
        StringBuilder data = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(lineTab).append(line).append("\n");
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Помилка зчитування файлу! " + e.toString());
        }
        return data.toString();
    }

    public static ArrayList<String> getStringNamesRecordFiles(String directoryPath) {
        ArrayList<String> stringNames = new ArrayList<>();
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    stringNames.add(file.getName());
                }
            }
        }
        return stringNames;
    }

    public static boolean deleteFile(String filename) {
        try {
            File fileToDelete = new File(filename);
            if (fileToDelete.delete()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Помилка видалення файлу! " + e);
        }
        return false;
    }

    public static boolean deleteAllFiles(String directoryPath) {
        ArrayList<String> stringNamesRecordFiles = getStringNamesRecordFiles(directoryPath);
        int countFiles = stringNamesRecordFiles.size();
        for (String name : stringNamesRecordFiles) {
            deleteFile(directoryPath + name);
            countFiles--;
        }
        return countFiles == 0;
    }
}
