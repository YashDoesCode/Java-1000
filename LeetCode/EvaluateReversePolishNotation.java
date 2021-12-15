
import java.util.*;
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) { Stack<Integer> st = new Stack<>();
        for (String t : tokens) { if (t.equals("+")) st.push(st.pop() + st.pop());
            else if (t.equals("-")) { int b = st.pop(), a = st.pop();
                st.push(a - b);
            } else if (t.equals("*")) st.push(st.pop() * st.pop());
            else if (t.equals("/")) { int b = st.pop(), a = st.pop();
                st.push(a / b);
            } else st.push(Integer.parseInt(t));
        } return st.pop();
    };
}
