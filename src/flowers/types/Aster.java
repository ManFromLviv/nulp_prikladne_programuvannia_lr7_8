package flowers.types;

import flowers.AbstractFlower;

public class Aster extends AbstractFlower {
    public Aster(int stemLength, int freshnessLevel, double price, FLOWER_COLOR color, String name, FLOWER_TYPE type)  throws Exception  {
        super(stemLength, freshnessLevel, price, color, name, type);
    }
}
