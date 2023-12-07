package flowers.types;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static flowers.ValidFlower.FLOWER_COLOR;
import static flowers.ValidFlower.FLOWER_TYPE;

public class AsterTest {
    @Test
    public void testAsterCreationValidParametersObjectCreatedSuccessfully() { // Успішне створення об'єкту класу
        try {
            Aster aster = new Aster(22, 2, 100.0, FLOWER_COLOR.BLACK, "Black Aster", FLOWER_TYPE.ASTER);
            assertNotNull(aster);
            assertEquals(22, aster.getStemLength());
            assertEquals(2, aster.getFreshnessLevel());
            assertEquals(100.0, aster.getPrice());
            assertEquals(FLOWER_COLOR.BLACK, aster.getColor());
            assertEquals("Black Aster", aster.getName());
            assertEquals(FLOWER_TYPE.ASTER, aster.getType());
        } catch (Exception e) {
            fail("Неочікуване виключення: " + e.getMessage());
        }
    }

    @Test
    public void testAsterCreationInvalidParametersExceptionThrown() { // Помилкові параметри при створенні об'єкту класу
        assertThrows(Exception.class, () -> new Aster(-1, 3, 20.0, FLOWER_COLOR.BLACK, "Black Aster", FLOWER_TYPE.ASTER));
        assertThrows(Exception.class, () -> new Aster(12, 100, 20.0, FLOWER_COLOR.BLACK, "Black Aster", FLOWER_TYPE.ASTER));
        assertThrows(Exception.class, () -> new Aster(12, 3, -5.0, FLOWER_COLOR.BLACK, "Black Aster", FLOWER_TYPE.ASTER));
    }
}