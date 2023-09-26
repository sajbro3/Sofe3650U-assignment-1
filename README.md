# Sofe3650U-assignment-1

-The code defines two interfaces: GroceryProduct and GroceryProductFactory.
-GroceryProduct defines methods for getting and setting the name, price, and description of a grocery product.
-GroceryProductFactory declares a method for creating instances of grocery products.
-Two concrete classes, Banana and Apple, implement the GroceryProduct interface.
-Each class represents a specific grocery product (Banana and Apple) and provides implementations for the interface methods.
-Two concrete factory classes, BananaFactory and AppleFactory, implement the GroceryProductFactory interface.
-These factory classes create instances of Banana and Apple, respectively, and return them as GroceryProduct objects.
-The main method in the GroceryProductTest class serves as the entry point of the application.
-It creates instances of the concrete product factories (BananaFactory and AppleFactory).
-The code includes a method, readPricesFromFile, to read product prices from a CSV data file named "product_prices.csv."
-The prices are stored in a Map<String, Double> where the product names are the keys, and the prices are the values.
-The main method reads prices from the data file, creates grocery products using the factories, sets the prices based on the data, and displays product information.
-The displayProductInfo method is used to print the product name, description, and price to the console.
The code includes basic error handling for file reading, displaying an error message if there's an issue reading the data file.

![image](https://github.com/sajbro3/Sofe3650U-assignment-1/assets/130171415/50dd9be1-2520-4b79-84f0-54e54a292e4a)
