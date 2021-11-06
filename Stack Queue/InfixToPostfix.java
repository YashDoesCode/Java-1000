import java.util.*;
public class InfixToPostfix {

    public String convert(String exp) { StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (char c : exp.toCharArray()) { if (Character.isLetterOrDigit(c)) res.append(c);
            else if (c == '(') st.push(c);
            else if (c == ')') { while (!st.isEmpty() && st.peek() != '(') res.append(st.pop());
                st.pop();
            } else { while (!st.isEmpty() && prec(c) <= prec(st.peek())) res.append(st.pop());
                st.push(c);
            } } while (!st.isEmpty()) res.append(st.pop());
        return res.toString();
    } private int prec(char ch) { if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    };
}
