package application;

import java.util.ArrayList;
import java.util.List;

public class FoodStorage {
    private static List<FoodItem> foodItems = new ArrayList<>();

    static {
        // Add some sample data when the class loads
        foodItems.add(new FoodItem("1", "Apple", 1.20, 50, "2023-10-01", "2023-11-15", true));
        foodItems.add(new FoodItem("2", "Milk", 2.50, 30, "2023-10-05", "2023-10-25", false));
        foodItems.add(new FoodItem("3", "Bread", 3.10, 25, "2023-10-10", "2023-10-30", true));
    }

    public static void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
    }

    public static List<FoodItem> getAllFoodItems() {
        return new ArrayList<>(foodItems);
    }

    public static void clearStorage() {
        foodItems.clear();
    }
}