
import java.util.*;
public class ScoreOfParenthesesStack {

    public int scoreOfParentheses(String s) { Stack<Integer> st = new Stack<>();
        st.push(0);
        for (char c : s.toCharArray()) { if (c == '(') st.push(0);
            else { int v = st.pop(), w = st.pop();
                st.push(w + Math.max(2 * v, 1));
            } } return st.pop();
    };
}
