package flowers.types;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static flowers.ValidFlower.FLOWER_COLOR;
import static flowers.ValidFlower.FLOWER_TYPE;

public class LilyTest {

    @Test
    public void testLilyCreationValidParametersObjectCreatedSuccessfully() { // Успішне створення об'єкту класу
        try {
            Lily lily = new Lily(25, 3, 80.0, FLOWER_COLOR.WHITE, "White Lily", FLOWER_TYPE.LILY);
            assertNotNull(lily);
            assertEquals(25, lily.getStemLength());
            assertEquals(3, lily.getFreshnessLevel());
            assertEquals(80.0, lily.getPrice());
            assertEquals(FLOWER_COLOR.WHITE, lily.getColor());
            assertEquals("White Lily", lily.getName());
            assertEquals(FLOWER_TYPE.LILY, lily.getType());
        } catch (Exception e) {
            fail("Неочікуване виключення: " + e.getMessage());
        }
    }

    @Test
    public void testLilyCreationInvalidParametersExceptionThrown() { // Помилкові параметри при створенні об'єкту класу
        assertThrows(Exception.class, () -> new Lily(-1, 3, 20.0, FLOWER_COLOR.WHITE, "White Lily", FLOWER_TYPE.LILY));
        assertThrows(Exception.class, () -> new Lily(12, 100, 20.0, FLOWER_COLOR.WHITE, "White Lily", FLOWER_TYPE.LILY));
        assertThrows(Exception.class, () -> new Lily(12, 3, -5.0, FLOWER_COLOR.WHITE, "White Lily", FLOWER_TYPE.LILY));
    }
}
