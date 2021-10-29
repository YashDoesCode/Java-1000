
import java.util.*;
public class BasicCalculatorStack {

    public int calculate(String s) { Stack<Integer> st = new Stack<>();
        int num = 0, sign = 1, res = 0;
        for (int i = 0;
        i < s.length();
        i++) { char c = s.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            else if (c == '+') { res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') { res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') { st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') { res += sign * num;
                res *= st.pop();
                res += st.pop();
                num = 0;
            } } return res + sign * num;
    };
}
