import java.util.*;
public class EvaluatePostfix {

    public int eval(String exp) { Stack<Integer> st = new Stack<>();
        for (char c : exp.toCharArray()) { if (Character.isDigit(c)) st.push(c - '0');
            else { int b = st.pop(), a = st.pop();
                if (c == '+') st.push(a + b);
                else if (c == '-') st.push(a - b);
                else if (c == '*') st.push(a * b);
                else if (c == '/') st.push(a / b);
            } } return st.pop();
    };
}
