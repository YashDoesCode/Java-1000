import java.util.*;
public class StockSim {

    private double price;

    private Random random = new Random();

    public StockSim(double initialPrice) {
        price = initialPrice;
    }

    public double tick() {
        double changePercent = (random.nextDouble() - 0.5) * 0.05;
        price += price * changePercent;
        return price;
    }

    public double getPrice() {
        return price;
    }
}
