import java.util.*;
public class LargestRectangleHistogramTopic {

    public int largestRectangleArea(int[] heights) { int n = heights.length, maxA = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0;
        i <= n;
        i++) { int h = (i == n) ? 0 : heights[i];
            while (!st.isEmpty() && heights[st.peek()] >= h) { int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxA = Math.max(maxA, height * width);
            } st.push(i);
        } return maxA;
    };
}
