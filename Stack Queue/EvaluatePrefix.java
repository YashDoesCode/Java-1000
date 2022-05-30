import java.util.*;
public class EvaluatePrefix {

    public int eval(String exp) { Stack<Integer> st = new Stack<>();
        for (int i = exp.length() - 1;
        i >= 0;
        i--) { char c = exp.charAt(i);
            if (Character.isDigit(c)) st.push(c - '0');
            else { int a = st.pop(), b = st.pop();
                if (c == '+') st.push(a + b);
                else if (c == '-') st.push(a - b);
                else if (c == '*') st.push(a * b);
                else if (c == '/') st.push(a / b);
            } } return st.pop();
    };
}
