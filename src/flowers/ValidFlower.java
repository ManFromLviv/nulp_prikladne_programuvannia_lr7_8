package flowers;

public interface ValidFlower {
    int maxStemLength = 100;
    int minStemLength = 10;

    int maxFreshnessLevel = 3;
    int minFreshnessLevel = 0;

    double maxPrice = 1000;
    double minPrice = 5;

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
        return stemLength <= maxStemLength && stemLength >= minStemLength;
    }

    static boolean isValidFreshnessLevel(int freshnessLevel) {
        return freshnessLevel <= maxFreshnessLevel && freshnessLevel >= minFreshnessLevel;
    }

    static boolean isValidPrice(double price) {
        return price <= maxPrice && price >= minPrice;
    }
}
