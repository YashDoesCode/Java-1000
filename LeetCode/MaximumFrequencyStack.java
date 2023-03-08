
import java.util.*;
public class MaximumFrequencyStack {

    private Map<Integer, Integer> freq = new HashMap<>();

    private Map<Integer, Stack<Integer>> group = new HashMap<>();
    private int maxFreq = 0;

    public void push(int val) { int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);
        group.putIfAbsent(f, new Stack<>());
        group.get(f).push(val);
    } public int pop() { int x = group.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxFreq).isEmpty()) maxFreq--;
        return x;
    };
}
