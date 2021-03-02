import java.util.*;
public class KeysAndRoomsTopicGraph {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) { boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int cnt = 1;
        while (!q.isEmpty()) { int cur = q.poll();
            for (int key : rooms.get(cur)) if (!vis[key]) { vis[key] = true;
                q.add(key);
                cnt++;
            } } return cnt == rooms.size();
    };
}
