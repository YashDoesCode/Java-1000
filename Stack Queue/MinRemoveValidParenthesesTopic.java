import java.util.*;
public class MinRemoveValidParenthesesTopic {

    public String minRemoveToMakeValid(String s) { StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i = 0;
        i < sb.length();
        i++) { if (sb.charAt(i) == '(') st.push(i);
            else if (sb.charAt(i) == ')') { if (!st.isEmpty()) st.pop();
                else sb.setCharAt(i, '*');
            } } while (!st.isEmpty()) sb.setCharAt(st.pop(), '*');
        return sb.toString().replace("*", "");
    };
}
