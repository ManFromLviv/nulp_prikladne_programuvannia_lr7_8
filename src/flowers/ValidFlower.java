package flowers;

public interface ValidFlower {
    int MAX_STEM_LENGTH = 100;
    int MIN_STEM_LENGTH = 10;

    int MAX_FRESHNESS_LEVEL = 3;
    int MIN_FRESHNESS_LEVEL = 0;

    double MAX_PRICE = 1000;
    double MIN_PRICE = 5;

    enum FLOWER_COLOR {
        RED, ORANGE, YELLOW,
        BLACK, WHITE
    }

    enum FLOWER_TYPE {
        ROSE,
        TULIP,
        ASTER,
        LILY
    }

    static String getValidStringColor(FLOWER_COLOR color) {
        return switch (color) {
            case RED -> "Червоний";
            case ORANGE -> "Оранжевий";
            case YELLOW -> "Жовтий";
            case BLACK -> "Чорний";
            case WHITE -> "Білий";
        };
    }

    static public String getValidStringFreshnessLevel(int freshnessLevel) {
        return switch (freshnessLevel) {
            case 0 -> "Зів'яла";
            case 1 -> "В'яла";
            case 2 -> "Свіжа";
            case 3 -> "Максимально свіжа";
            default -> null;
        };
    }

    static String getValidStringType(FLOWER_TYPE type) {
        return switch (type) {
            case ROSE -> "Роза";
            case TULIP -> "Тюльпан";
            case ASTER -> "Айстра";
            case LILY -> "Лілія";
        };
    }

    static boolean isValidNumberParametersFlower(int stemLength, int freshnessLevel, double price) {
        return isValidStemLength(stemLength) && isValidFreshnessLevel(freshnessLevel) && isValidPrice(price);
    }

    static boolean isValidStemLength(int stemLength) {
        return stemLength <= MAX_STEM_LENGTH && stemLength >= MIN_STEM_LENGTH;
    }

    static boolean isValidFreshnessLevel(int freshnessLevel) {
        return freshnessLevel <= MAX_FRESHNESS_LEVEL && freshnessLevel >= MIN_FRESHNESS_LEVEL;
    }

    static boolean isValidPrice(double price) {
        return price <= MAX_PRICE && price >= MIN_PRICE;
    }
}
