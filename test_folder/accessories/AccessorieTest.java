package accessories;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccessorieTest {
    @Test
    void isValidPriceValidPriceReturnsTrue() {
        assertTrue(Accessorie.isValidPrice(50)); // Перевіряємо коректну ціну
    }

    @Test
    void isValidPricePriceAboveMaxReturnsFalse() {
        assertFalse(Accessorie.isValidPrice(100000)); // Перевіряємо ціну, що перевищує максимальну допустиму
    }

    @Test
    void isValidPricePriceBelowMinReturnsFalse() {
        assertFalse(Accessorie.isValidPrice(2)); // Перевіряємо ціну, яка менша за мінімально допустиму
    }

    @Test
    void isValidNameOrDescriptionValidNameOrDescriptionReturnsTrue() {
        assertTrue(Accessorie.isValidNameOrDescription("Test description")); // Перевіряємо коректний опис
    }

    @Test
    void isValidNameOrDescriptionEmptyNameOrDescription_ReturnsFalse() {
        assertFalse(Accessorie.isValidNameOrDescription("")); // Перевіряємо порожній опис
    }

    @Test
    void accessorieConstructorValidParametersObjectCreatedSuccessfully() {
        try {
            Accessorie validAccessorie = new Accessorie("ValidName", "ValidDescription", 50);
            assertNotNull(validAccessorie);
            assertEquals("ValidName", validAccessorie.getName());
            assertEquals("ValidDescription", validAccessorie.getDescription());
            assertEquals(50, validAccessorie.getPrice());
        } catch (Exception e) {
            fail("Неочікуване виключення: " + e.getMessage());
        }
    }

    @Test
    void accessorieConstructorInvalidParametersExceptionThrown() {
        assertThrows(Exception.class, () -> new Accessorie("", "Description", 50)); // Перевіряємо порожнє ім'я
        assertThrows(Exception.class, () -> new Accessorie("Name", "", 50)); // Перевіряємо порожній опис
        assertThrows(Exception.class, () -> new Accessorie("Name", "Description", 100000)); // Перевіряємо ціну, що перевищує максимальну допустиму
    }

    @Test
    void setPriceValidPricePriceUpdated() throws Exception {
        Accessorie accessorie = new Accessorie("Name", "Description", 50);
        accessorie.setPrice(70); // Встановлюємо коректну ціну
        assertEquals(70, accessorie.getPrice());
    }

    @Test
    void setPriceInvalidPricePriceNotUpdated() throws Exception {
        Accessorie accessorie = new Accessorie("Name", "Description", 50);
        accessorie.setPrice(3); // Встановлюємо ціну, яка менша за мінімально допустиму
        assertEquals(50, accessorie.getPrice()); // Ціна не повинна змінитися
    }

    @Test
    void getInitDataReturnsCorrectData() throws Exception {
        Accessorie accessorie = new Accessorie("Name", "Description", 50);
        String expectedData = "Name\nDescription\n50.0\n";
        assertEquals(expectedData, accessorie.getInitData());
    }
}
