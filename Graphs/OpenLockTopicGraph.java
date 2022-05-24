import java.util.*;
public class OpenLockTopicGraph {

    public int openLock(String[] deadends, String target) { Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        Set<String> vis = new HashSet<>();
        vis.add("0000");
        int steps = 0;
        while (!q.isEmpty()) { int size = q.size();
            for (int i = 0;
            i < size;
            i++) { String cur = q.poll();
                if (cur.equals(target)) return steps;
                for (int j = 0;
                j < 4;
                j++) { char c = cur.charAt(j);
                    String s1 = cur.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + cur.substring(j + 1);
                    String s2 = cur.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + cur.substring(j + 1);
                    if (!dead.contains(s1) && vis.add(s1)) q.add(s1);
                    if (!dead.contains(s2) && vis.add(s2)) q.add(s2);
                } } steps++;
        } return -1;
    };
}
