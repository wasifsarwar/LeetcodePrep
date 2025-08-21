package AmazonContractOOP.CoffeeShopOrderSystem;

import java.util.*;

public class CoffeeShopOrderSystem {
    /**
     * Initial Requirements:
     * 
     * Customers can order different types of coffee (Espresso, Latte, Cappuccino)
     * Each coffee has a base price
     * Customers can add extras (milk, sugar, whipped cream)
     * Calculate total price
     * Print order receipt
     * 
     * Design Challenge:
     * Design a system that can easily:
     * 
     * Add new coffee types
     * Add new extras/add-ons
     * Apply discounts/promotions
     * Handle different sizing (Small, Medium, Large)
     * 
     * Extension Questions (Amazon Style):
     * 
     * "How would you handle seasonal drinks?"
     * "What if we want to add loyalty program discounts?"
     * "How would you scale this for multiple store locations?"
     * "How would you handle inventory management?"
     * 
     * @param args
     */

    Map<String, Integer> coffeeMap;
    Map<String, Integer> extraMap;
    Map<String, Integer> sizeMap;

    public CoffeeShopOrderSystem() {
        coffeeMap = new HashMap<>();
        extraMap = new HashMap<>();
        sizeMap = new HashMap<>();
    }

    public void addCoffeeType(String coffee, int price) {
        if (coffee == "" || coffee == " " || price < 0)
            throw new IllegalArgumentException();
        coffeeMap.put(coffee, price);
    }

    public void addExtraType(String extra, int val) {
        if (extra == "" || extra == " " || val < 0)
            throw new IllegalArgumentException();

        extraMap.put(extra, val);
    }

    public void addSizeType(String size, int val) {
        if (size == "" || size == " " || val < 0)
            sizeMap.put(size, val);
    }

    public int getPrice(String coffee, String size, List<String> extras) {
        int price = 0;
        if (!coffeeMap.containsKey(coffee) || !sizeMap.containsKey(size))
            throw new IllegalArgumentException();
        price += coffeeMap.get(coffee) + sizeMap.get(size);
        if (!extras.isEmpty()) {
            for (String extra : extras) {
                if (extraMap.containsKey(extra))
                    price += extraMap.get(extra);
            }

        }
        return price;
    }

    public int applyDiscount(int price, int discount) {
        return price - (price * discount / 100);
    }

    public static void main(String[] args) {

    }
}
