package flowers;

import flowers.types.Aster;
import flowers.types.Lily;
import flowers.types.Rose;
import flowers.types.Tulip;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static flowers.ValidFlower.FLOWER_COLOR;
import static flowers.ValidFlower.FLOWER_TYPE;

public class AbstractFlowerTest {

    @Test
    public void testAbstractFlowerCreationValidParametersObjectCreatedSuccessfully() { // Успішне створення об'єктів класу Rose, Lily, Tulip, Aister
        try {
            AbstractFlower rose = new Rose(30, 3, 90.0, FLOWER_COLOR.RED, "Red Rose", FLOWER_TYPE.ROSE);
            assertNotNull(rose);
            assertEquals(30, rose.getStemLength());
            assertEquals(3, rose.getFreshnessLevel());
            assertEquals(90.0, rose.getPrice());
            assertEquals(FLOWER_COLOR.RED, rose.getColor());
            assertEquals("Red Rose", rose.getName());
            assertEquals(FLOWER_TYPE.ROSE, rose.getType());

            AbstractFlower tulip = new Tulip(25, 3, 80.0, FLOWER_COLOR.YELLOW, "Yellow Tulip", FLOWER_TYPE.TULIP);
            assertNotNull(tulip);
            assertEquals(25, tulip.getStemLength());
            assertEquals(3, tulip.getFreshnessLevel());
            assertEquals(80.0, tulip.getPrice());
            assertEquals(FLOWER_COLOR.YELLOW, tulip.getColor());
            assertEquals("Yellow Tulip", tulip.getName());
            assertEquals(FLOWER_TYPE.TULIP, tulip.getType());

            AbstractFlower lily = new Lily(28, 1, 85.0, FLOWER_COLOR.WHITE, "White Lily", FLOWER_TYPE.LILY);
            assertNotNull(lily);
            assertEquals(28, lily.getStemLength());
            assertEquals(1, lily.getFreshnessLevel());
            assertEquals(85.0, lily.getPrice());
            assertEquals(FLOWER_COLOR.WHITE, lily.getColor());
            assertEquals("White Lily", lily.getName());
            assertEquals(FLOWER_TYPE.LILY, lily.getType());

            AbstractFlower aster = new Aster(22, 2, 100.0, FLOWER_COLOR.BLACK, "Black Aster", FLOWER_TYPE.ASTER);
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
    public void testAbstractFlowerCreationInvalidParametersExceptionThrown() { // Помилкові параметри для об'єктів класу Rose, Lily, Tulip, Aister
        assertThrows(Exception.class, () -> new Rose(-1, 6, 20.0, FLOWER_COLOR.RED, "Red Rose", FLOWER_TYPE.ROSE));
        assertThrows(Exception.class, () -> new Tulip(12, 100, 20.0, FLOWER_COLOR.YELLOW, "Yellow Tulip", FLOWER_TYPE.TULIP));
        assertThrows(Exception.class, () -> new Lily(30, -3, 85.0, FLOWER_COLOR.WHITE, "White Lily", FLOWER_TYPE.LILY));
        assertThrows(Exception.class, () -> new Aster(12, 6, -5.0, FLOWER_COLOR.BLACK, "Black Aster", FLOWER_TYPE.ASTER));
    }
}
