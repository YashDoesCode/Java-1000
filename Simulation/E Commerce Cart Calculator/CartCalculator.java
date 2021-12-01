import java.util.*;
public class CartCalculator {

    public static class Item {

        String name;
        double price;
        int qty;

        public Item(String name, double price, int qty) {
            this.name = name;
            this.price = price;
            this.qty = qty;
        }
    }

    public double calculateTotal(List<Item> items, double discountPercent, double taxPercent) {
        double subtotal = 0;
        for (Item item : items) subtotal += item.price * item.qty;
        double discounted = subtotal * (1.0 - discountPercent / 100.0);
        return discounted * (1.0 + taxPercent / 100.0);
    }
}
