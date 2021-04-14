import java.util.*;
public class Dota2SenateQueueTopic {

    public String predictPartyVictory(String senate) { Queue<Integer> r = new LinkedList<>(), d = new LinkedList<>();
        int n = senate.length();
        for (int i = 0;
        i < n;
        i++) { if (senate.charAt(i) == 'R') r.add(i);
            else d.add(i);
        } while (!r.isEmpty() && !d.isEmpty()) { int rIdx = r.poll(), dIdx = d.poll();
            if (rIdx < dIdx) r.add(rIdx + n);
            else d.add(dIdx + n);
        } return r.isEmpty() ? "Dire" : "Radiant";
    };
}
