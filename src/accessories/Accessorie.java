package accessories;

public class Accessorie {

    public static final double MAX_PRICE = 10000;
    public static final double MIN_PRICE = 5;

    public static boolean isValidPrice(double price) {
        return price <= MAX_PRICE && price >= MIN_PRICE;
    }

    public static boolean isValidNameOrDescription(String nameOrDescription) {
        return !nameOrDescription.isEmpty();
    }

    String name;
    String description;
    double price;

    public Accessorie(String name, String description, double price) throws Exception {
        boolean valid = isValidNameOrDescription(name) && isValidNameOrDescription(description) && isValidPrice(price);
        if (valid) {
            this.name = name;
            this.description = description;
            this.price = price;
        } else {
            throw new Exception("При створенні об'єкта були задані невірні параметри!");
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (isValidPrice(price)){
            this.price = price;
        }
    }

    public String getInitData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append("\n");
        stringBuilder.append(description).append("\n");
        stringBuilder.append(price).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name).append(" {");
        stringBuilder.append("Опис = ").append(description).append(", ");
        stringBuilder.append("Ціна = ").append(price).append(" }");
        return stringBuilder.toString();
    }
}
