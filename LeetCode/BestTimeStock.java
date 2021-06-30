
public class BestTimeStock {

    public int maxProfit(int[] p) { int minP = Integer.MAX_VALUE, maxV = 0;
        for (int x : p) { minP = Math.min(minP, x);
            maxV = Math.max(maxV, x - minP);
        } return maxV;
    };
}
