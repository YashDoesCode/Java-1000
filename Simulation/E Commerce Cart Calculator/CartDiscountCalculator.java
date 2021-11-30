import java.util.*;

public class CartDiscountCalculator {

    public static class Item {

        public String id;
        public double price;
        public int quantity;

        public Item(String id, double price, int quantity) {
            this.id = id;
            this.price = price;
            this.quantity = quantity;
        }
    }

    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateSubtotal() {
        double total = 0;
        for (Item item : items) {
            total += item.price * item.quantity;
        }
        return total;
    }

    public double calculateTotal(double taxRatePercentage, double discountPercentage) {
        double subtotal = calculateSubtotal();
        double discountAmount = subtotal * (discountPercentage / 100.0);
        double taxableAmount = subtotal - discountAmount;
        double taxAmount = taxableAmount * (taxRatePercentage / 100.0);
        return taxableAmount + taxAmount;
    }
}
