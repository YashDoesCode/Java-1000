
public class BestTimeStockII {

    public int maxProfit(int[] p) { int maxV = 0;
        for (int i = 1;
        i < p.length;
        i++) if (p[i] > p[i - 1]) maxV += p[i] - p[i - 1];
        return maxV;
    };
}
