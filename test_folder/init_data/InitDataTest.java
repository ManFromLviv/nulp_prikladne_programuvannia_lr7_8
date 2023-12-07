package init_data;

import org.junit.jupiter.api.Test;
import init_data.InitData.*;

import static files.Files.*;
import static init_data.InitData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InitDataTest {
    @Test
    public void testInitData() { // Перевірка цілісноті даних
        int sizeFlowers1 = flowersNow.size();
        int sizeAccessorie1 = accessoriesNow.size();
        int sizeBouquet1 = bouquetsNow.size();
        int sizeFlowers2 = readFileFlowers(initPathFlowers).size();
        int sizeAccessorie2 = readFileAccessories(initPathAccessories).size();
        int sizeBouquet2 = getStringNamesRecordFiles(initPathBouquet).size();
        assertEquals(sizeFlowers1, sizeFlowers2);
        assertEquals(sizeAccessorie1, sizeAccessorie2);
        assertEquals(sizeBouquet1, sizeBouquet2);
    }
}