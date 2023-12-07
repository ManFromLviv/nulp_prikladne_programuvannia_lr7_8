package flowers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidFlowerTest {

    @Test
    public void testValidStemLength() { // Тестування правильності довжини стебла
        assertTrue(ValidFlower.isValidStemLength(50));
        assertFalse(ValidFlower.isValidStemLength(-1));
        assertFalse(ValidFlower.isValidStemLength(15000));
    }

    @Test
    public void testValidFreshnessLevel() { // Тестування правильності рівня свіжості
        assertTrue(ValidFlower.isValidFreshnessLevel(2));
        assertFalse(ValidFlower.isValidFreshnessLevel(-1));
        assertFalse(ValidFlower.isValidFreshnessLevel(5));
    }

    @Test
    public void testValidPrice() { // Тестування правильності ціни
        assertTrue(ValidFlower.isValidPrice(100));
        assertFalse(ValidFlower.isValidPrice(-34));
        assertFalse(ValidFlower.isValidPrice(2000000));
    }

    @Test
    public void testValidNumberParametersFlower() { // Тестування правильності усіх даних
        assertTrue(ValidFlower.isValidNumberParametersFlower(50, 2, 100));
        assertFalse(ValidFlower.isValidNumberParametersFlower(-4, 2, 100));
        assertFalse(ValidFlower.isValidNumberParametersFlower(50, -4, 100));
        assertFalse(ValidFlower.isValidNumberParametersFlower(50, 2, -4));
    }
}
