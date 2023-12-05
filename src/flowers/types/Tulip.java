package flowers.types;

import flowers.AbstractFlower;

public class Tulip extends AbstractFlower {
    public Tulip(int stemLength, int freshnessLevel, double price, FLOWER_COLOR color, String name, FLOWER_TYPE type)  throws Exception  {
        super(stemLength, freshnessLevel, price, color, name, type);
    }
}