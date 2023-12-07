package flowers.types;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static flowers.ValidFlower.FLOWER_COLOR;
import static flowers.ValidFlower.FLOWER_TYPE;

public class RoseTest {

    @Test
    public void testRoseCreationValidParametersObjectCreatedSuccessfully() { // Успішне створення об'єкту класу
        try {
            Rose rose = new Rose(30, 3, 90.0, FLOWER_COLOR.RED, "Red Rose", FLOWER_TYPE.ROSE);
            assertNotNull(rose);
            assertEquals(30, rose.getStemLength());
            assertEquals(3, rose.getFreshnessLevel());
            assertEquals(90.0, rose.getPrice());
            assertEquals(FLOWER_COLOR.RED, rose.getColor());
            assertEquals("Red Rose", rose.getName());
            assertEquals(FLOWER_TYPE.ROSE, rose.getType());
        } catch (Exception e) {
            fail("Неочікуване виключення: " + e.getMessage());
        }
    }

    @Test
    public void testRoseCreationInvalidParametersExceptionThrown() { // Помилкові параметри при створенні об'єкту класу
        assertThrows(Exception.class, () -> new Rose(-1, 3, 20.0, FLOWER_COLOR.RED, "Red Rose", FLOWER_TYPE.ROSE));
        assertThrows(Exception.class, () -> new Rose(12, 100, 20.0, FLOWER_COLOR.RED, "Red Rose", FLOWER_TYPE.ROSE));
        assertThrows(Exception.class, () -> new Rose(12, 3, -5.0, FLOWER_COLOR.RED, "Red Rose", FLOWER_TYPE.ROSE));
    }
}
