package flowers;

public abstract class AbstractFlower implements ValidFlower {
    int stemLength;
    int freshnessLevel;
    double price;
    FLOWER_COLOR color;
    String name;

    FLOWER_TYPE type;

    public AbstractFlower(int stemLength, int freshnessLevel, double price, FLOWER_COLOR color, String name, FLOWER_TYPE type) throws Exception {
        boolean valid = ValidFlower.isValidNumberParametersFlower(stemLength, freshnessLevel, price);
        if (valid) {
            this.stemLength = stemLength;
            this.freshnessLevel = freshnessLevel;
            this.price = price;
            this.color = color;
            this.name = name;
            this.type = type;
        } else {
            throw new Exception("При створенні об'єкта були задані невірні параметри!");
        }
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) throws Exception {
        if (ValidFlower.isValidStemLength(stemLength)) {
            this.stemLength = stemLength;
        } else {
            throw new Exception("Невірна задана довжина стебла.");
        }
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public String getStringFreshnessLevel() {
        return ValidFlower.getValidStringFreshnessLevel(freshnessLevel);
    }

    public void setFreshnessLevel(int freshnessLevel) throws Exception {
        if (ValidFlower.isValidFreshnessLevel(freshnessLevel)) {
            this.freshnessLevel= freshnessLevel;
        } else {
            throw new Exception("Невірно задано рівень свіжості.");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if (ValidFlower.isValidPrice(price)) {
            this.price= price;
        } else {
            throw new Exception("Невірно задана ціна.");
        }
    }

    public FLOWER_COLOR getColor() {
        return color;
    }

    public String getStringColor() {
        return ValidFlower.getValidStringColor(color);
    }

    public void setColor(FLOWER_COLOR color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public FLOWER_TYPE getType() {
        return type;
    }

    public String getStringType() {
        return ValidFlower.getValidStringType(type);
    }

    public String getInitData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type).append("\n");
        stringBuilder.append(stemLength).append("\n");
        stringBuilder.append(freshnessLevel).append("\n");
        stringBuilder.append(price).append("\n");
        stringBuilder.append(color).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name).append(" {");
        stringBuilder.append("Довжина стебла = ").append(stemLength).append(", ");
        stringBuilder.append("Рівень свіжості = ").append(getStringFreshnessLevel()).append(", ");
        stringBuilder.append("Ціна = ").append(price).append(", ");
        stringBuilder.append("Колір = ").append(getStringColor()).append(" }");
        return stringBuilder.toString();
    }
}
