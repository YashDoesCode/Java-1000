public class CartPricingEngine {

    public double applyDiscount(double price, double discountPercent) {
        return price - (price * (discountPercent / 100.0));
    }
}
