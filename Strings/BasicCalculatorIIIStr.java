import java.util.*;
public class BasicCalculatorIIIStr {

    public int calculate(String s) { Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) if (c != ' ') q.add(c);
        q.add('+');
        return cal(q);
    } private int cal(Queue<Character> q) { char sign = '+';
        int num = 0;
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty()) { char c = q.poll();
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            else if (c == '(') num = cal(q);
            else { if (sign == '+') st.push(num);
                else if (sign == '-') st.push(-num);
                else if (sign == '*') st.push(st.pop() * num);
                else if (sign == '/') st.push(st.pop() / num);
                num = 0;
                sign = c;
                if (c == ')') break;
            } } int sum = 0;
        for (int i : st) sum += i;
        return sum;
    };
}
