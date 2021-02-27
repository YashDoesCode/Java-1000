
import java.util.*;
public class DailyTemperaturesStack {

    public int[] dailyTemperatures(int[] temperatures) { int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0;
        i < n;
        i++) { while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) { int idx = st.pop();
                res[idx] = i - idx;
            } st.push(i);
        } return res;
    };
}
