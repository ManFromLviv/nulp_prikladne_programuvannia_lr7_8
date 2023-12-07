package bouquet;

import accessories.Accessorie;
import flowers.AbstractFlower;
import flowers.types.Aster;
import flowers.types.Lily;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static flowers.ValidFlower.FLOWER_COLOR;
import static flowers.ValidFlower.FLOWER_TYPE;

public class BouquetTest {

    @Test
    public void testBouquetCreation() { // Створення букету
        Bouquet bouquet = new Bouquet();
        assertNotNull(bouquet);
        assertEquals(0, bouquet.getCountFlowers());
        assertEquals(0, bouquet.getCountAccessories());
        assertEquals(0.0, bouquet.getPrice());
    }

    @Test
    public void testAppendFlower() throws Exception { // Долучення квітки для букету
        Bouquet bouquet = new Bouquet();
        AbstractFlower lily = new Lily(28, 3, 85.0, FLOWER_COLOR.WHITE, "White Lily", FLOWER_TYPE.LILY);
        bouquet.appendFlower(lily);
        assertEquals(1, bouquet.getCountFlowers());
        assertEquals(85.0, bouquet.getPrice());
    }

    @Test
    public void testDeleteFlower() throws Exception { // Видалити квітку з букету
        Bouquet bouquet = new Bouquet();
        AbstractFlower aster = new Aster(22, 2, 100.0, FLOWER_COLOR.BLACK, "Black Aster", FLOWER_TYPE.ASTER);
        bouquet.appendFlower(aster);
        assertEquals(1, bouquet.getCountFlowers());
        assertEquals(100.0, bouquet.getPrice());

        bouquet.deleteFlower(1);
        assertEquals(0, bouquet.getCountFlowers());
        assertEquals(0.0, bouquet.getPrice());
    }

    @Test
    public void testAppendAccessorie() throws Exception { // Долучення аксесуара для букету
        Bouquet bouquet = new Bouquet();
        Accessorie accessorie = new Accessorie("Name", "Description", 10.0);
        bouquet.appendAccessorie(accessorie);
        assertEquals(1, bouquet.getCountAccessories());
        assertEquals(10.0, bouquet.getPrice());
    }

    @Test
    public void testDeleteAccessorie() throws Exception { // Видалити аксесуар з букету
        Bouquet bouquet = new Bouquet();
        Accessorie accessorie = new Accessorie("Name", "Description", 10.0);
        bouquet.appendAccessorie(accessorie);
        assertEquals(1, bouquet.getCountAccessories());
        assertEquals(10.0, bouquet.getPrice());

        bouquet.deleteAccessorie(1);
        assertEquals(0, bouquet.getCountAccessories());
        assertEquals(0.0, bouquet.getPrice());
    }
}
