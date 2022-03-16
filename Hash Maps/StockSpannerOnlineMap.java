import java.util.*;
public class StockSpannerOnlineMap {

    private Stack<int[]> st = new Stack<>();

    public int next(int price) { int w = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) w += st.pop()[1];
        st.push(new int[]{price, w});
        return w;
    };
}
