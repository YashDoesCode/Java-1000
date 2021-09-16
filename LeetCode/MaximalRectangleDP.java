
import java.util.*;
public class MaximalRectangleDP {

    public int maximalRectangle(char[][] matrix) { if (matrix.length == 0) return 0;
        int r = matrix.length, c = matrix[0].length;
        int[] h = new int[c];
        int maxA = 0;
        for (int i = 0;
        i < r;
        i++) { for (int j = 0;
            j < c;
            j++) h[j] = matrix[i][j] == '1' ? h[j] + 1 : 0;
            maxA = Math.max(maxA, largestInHist(h));
        } return maxA;
    } private int largestInHist(int[] heights) { int n = heights.length, maxA = 0;
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
