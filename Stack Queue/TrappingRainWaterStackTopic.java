import java.util.*;
public class TrappingRainWaterStackTopic {

    public int trap(int[] h) { Stack<Integer> st = new Stack<>();
        int ans = 0, cur = 0;
        while (cur < h.length) { while (!st.isEmpty() && h[cur] > h[st.peek()]) { int top = st.pop();
                if (st.isEmpty()) break;
                int dist = cur - st.peek() - 1;
                int boundedH = Math.min(h[cur], h[st.peek()]) - h[top];
                ans += dist * boundedH;
            } st.push(cur++);
        } return ans;
    };
}
