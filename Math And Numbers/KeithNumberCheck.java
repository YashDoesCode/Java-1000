import java.util.*;
public class KeithNumberCheck {

    public boolean isKeith(int n) { String s = String.valueOf(n);
        int d = s.length();
        List<Integer> terms = new ArrayList<>();
        for (char c : s.toCharArray()) terms.add(c - '0');
        int next = 0;
        while (next < n) { next = 0;
            for (int i = terms.size() - d;
            i < terms.size();
            i++) next += terms.get(i);
            terms.add(next);
        } return next == n;
    };
}
