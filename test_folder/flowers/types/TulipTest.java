package flowers.types;

import org.junit.jupiter.api.Test;
import flowers.AbstractFlower;
import static org.junit.jupiter.api.Assertions.*;

import static flowers.ValidFlower.FLOWER_COLOR;
import static flowers.ValidFlower.FLOWER_TYPE;

public class TulipTest {

    @Test
    public void testTulipCreationValidParametersObjectCreatedSuccessfully() { // Успішне створення об'єкту класу
        try {
            Tulip tulip = new Tulip(25, 3, 80.0, FLOWER_COLOR.YELLOW, "Yellow Tulip", FLOWER_TYPE.TULIP);
            assertNotNull(tulip);
            assertEquals(25, tulip.getStemLength());
            assertEquals(3, tulip.getFreshnessLevel());
            assertEquals(80.0, tulip.getPrice());
            assertEquals(FLOWER_COLOR.YELLOW, tulip.getColor());
            assertEquals("Yellow Tulip", tulip.getName());
            assertEquals(FLOWER_TYPE.TULIP, tulip.getType());
        } catch (Exception e) {
            fail("Неочікуване виключення: " + e.getMessage());
        }
    }

    @Test
    public void testTulipCreationInvalidParametersExceptionThrown() { // Помилкові параметри при створенні об'єкту класу
        assertThrows(Exception.class, () -> new Tulip(-1, 3, 20.0, FLOWER_COLOR.YELLOW, "Yellow Tulip", FLOWER_TYPE.TULIP));
        assertThrows(Exception.class, () -> new Tulip(12, 100, 20.0, FLOWER_COLOR.YELLOW, "Yellow Tulip", FLOWER_TYPE.TULIP));
        assertThrows(Exception.class, () -> new Tulip(12, 3, -5.0, FLOWER_COLOR.YELLOW, "Yellow Tulip", FLOWER_TYPE.TULIP));
    }
}
