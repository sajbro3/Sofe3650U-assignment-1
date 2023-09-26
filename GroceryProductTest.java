import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Define the GroceryProduct interface
interface GroceryProduct {
    String getName();
    double getPrice();
    String getDescription();
    void setPrice(double price);
}

// Define the GroceryProductFactory interface
interface GroceryProductFactory {
    GroceryProduct createProduct();
}

// Define Banana and Apple classes implementing GroceryProduct
class Banana implements GroceryProduct {
    private final String name;
    private double price;
    private final String description;

    public Banana() {
        this.name = "Banana";
        this.description = "Fresh bananas";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}

class Apple implements GroceryProduct {
    private final String name;
    private double price;
    private final String description;

    public Apple() {
        this.name = "Apple";
        this.description = "Delicious apples";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}

// Define BananaFactory and AppleFactory implementing GroceryProductFactory
class BananaFactory implements GroceryProductFactory {
    @Override
    public GroceryProduct createProduct() {
        return new Banana();
    }
}

class AppleFactory implements GroceryProductFactory {
    @Override
    public GroceryProduct createProduct() {
        return new Apple();
    }
}

public class GroceryProductTest {
    public static void main(String[] args) {
        // Create concrete factories
        GroceryProductFactory bananaFactory = new BananaFactory();
        GroceryProductFactory appleFactory = new AppleFactory();

        // Read prices from the data file
        Map<String, Double> productPrices = readPricesFromFile("product_prices.csv");

        // Create grocery products using factories and set prices
        GroceryProduct banana = bananaFactory.createProduct();
        banana.setPrice(productPrices.get("Banana"));

        GroceryProduct apple = appleFactory.createProduct();
        apple.setPrice(productPrices.get("Apple"));

        // Display product information
        displayProductInfo(banana);
        displayProductInfo(apple);
    }

    // Helper method to read prices from a CSV file
    private static Map<String, Double> readPricesFromFile(String fileName) {
        Map<String, Double> productPrices = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String productName = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    productPrices.put(productName, price);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading prices from the file: " + e.getMessage());
        }

        return productPrices;
    }

    // Helper method to display product information
    private static void displayProductInfo(GroceryProduct product) {
        System.out.println("Product: " + product.getName());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: $" + product.getPrice());
        System.out.println();
    }
}
