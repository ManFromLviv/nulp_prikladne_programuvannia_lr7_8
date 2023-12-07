package files;

import accessories.Accessorie;
import bouquet.Bouquet;
import flowers.AbstractFlower;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static files.Files.*;
import static org.junit.jupiter.api.Assertions.*;

public class FilesTest {

    @Test
    public void testCreateAndReadFileBouquet() { // Створення й зчитування файлу для букета
        String directoryPath = "test_folder/files_txt/";
        String nameObjectInFile = "bouquet";
        String data = "100.0\n" +
                "1\n" +
                "1\n" +
                "LILY\n" +
                "25\n" +
                "1\n" +
                "50.0\n" +
                "WHITE\n" +
                "Accessorie\n" +
                "Description\n" +
                "50.0\n";

        String filename = Files.createFileBouquet(directoryPath, nameObjectInFile, data, "1");

        Bouquet bouquet = Files.readFileBouquet(filename);

        assertNotNull(bouquet);
        assertEquals(1, bouquet.getCountFlowers());
        assertEquals(1, bouquet.getCountAccessories());
        assertEquals(100.0, bouquet.getPrice());

        deleteFile(filename);
    }

    @Test
    public void testCreateAndReadFileFlowers() { // Створення й зчитування файлу для квіток
        String filename = "test_folder/files_txt/flowers.txt";
        String data = "3\n" +
                "ROSE\n" +
                "20\n" +
                "3\n" +
                "35.0\n" +
                "RED\n" +
                "TULIP\n" +
                "15\n" +
                "1\n" +
                "25.0\n" +
                "YELLOW\n" +
                "ASTER\n" +
                "18\n" +
                "2\n" +
                "20.0\n" +
                "BLACK\n";

        Files.createFileFlowersOrAccessories(filename, data);

        ArrayList<AbstractFlower> flowers = Files.readFileFlowers(filename);

        assertNotNull(flowers);
        assertEquals(3, flowers.size());

        deleteFile(filename);
    }

    @Test
    public void testCreateAndReadFileAccessories() { // Створення й зчитування файлу для аксесуара
        String filename = "test_folder/files_txt/accessorie.txt";
        String data = "2\n" +
                "Name1\n" +
                "Description1\n" +
                "10.0\n" +
                "Name2\n" +
                "Description2\n" +
                "5.0\n";

        Files.createFileFlowersOrAccessories(filename, data);

        ArrayList<Accessorie> accessories = Files.readFileAccessories(filename);

        assertNotNull(accessories);
        assertEquals(2, accessories.size());

        deleteFile(filename);
    }

    @Test void testStringNamesRecordsFiles() { // Зчитування імен файлів з заданої директорії
        String directoryPath = "test_folder/files_txt/";
        String filename = "test_folder/files_txt/test.txt";
        Files.createFileFlowersOrAccessories(filename, "test");

        assertEquals(Files.getStringNamesRecordFiles(directoryPath).size(), 1);
    }

    @Test
    public void testDeleteFile() { // Видалення файлу
        String filename = "test_folder/files_txt/test.txt";

        Files.createFileFlowersOrAccessories(filename, "test");

        assertTrue(Files.deleteFile(filename));
    }

    @Test
    public void testDeleteAllFiles() { // Видалення усіх файлів
        String directoryPath = "test_folder/files_txt/";
        String filename = "test_folder/files_txt/test1.txt";
        Files.createFileFlowersOrAccessories(filename, filename);
        filename = "test_folder/files_txt/test2.txt";
        Files.createFileFlowersOrAccessories(filename, filename);

        assertTrue(Files.deleteAllFiles(directoryPath));
    }
}
