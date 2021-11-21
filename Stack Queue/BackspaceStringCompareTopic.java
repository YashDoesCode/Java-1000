import java.util.*;
public class BackspaceStringCompareTopic {

    public boolean backspaceCompare(String s, String t) { return build(s).equals(build(t));
    } private String build(String str) { Stack<Character> st = new Stack<>();
        for (char c : str.toCharArray()) { if (c != '#') st.push(c);
            else if (!st.isEmpty()) st.pop();
        } return String.valueOf(st);
    };
}
