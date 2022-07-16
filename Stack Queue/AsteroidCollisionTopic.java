import java.util.*;
public class AsteroidCollisionTopic {

    public int[] asteroidCollision(int[] a) { Stack<Integer> st = new Stack<>();
        for (int x : a) { if (x > 0) st.push(x);
            else { while (!st.isEmpty() && st.peek() > 0 && st.peek() < -x) st.pop();
                if (st.isEmpty() || st.peek() < 0) st.push(x);
                else if (st.peek() == -x) st.pop();
            } } int[] res = new int[st.size()];
        for (int i = res.length - 1;
        i >= 0;
        i--) res[i] = st.pop();
        return res;
    };
}
