import java.util.*;
public class LongestValidParenthesesStr {

    public int longestValidParentheses(String s) { Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxV = 0;
        for (int i = 0;
        i < s.length();
        i++) { if (s.charAt(i) == '(') st.push(i);
            else { st.pop();
                if (st.isEmpty()) st.push(i);
                else maxV = Math.max(maxV, i - st.peek());
            } } return maxV;
    };
}
