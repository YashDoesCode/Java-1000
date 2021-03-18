
import java.util.*;
public class TaskSchedulerQueue {

    public int leastInterval(char[] tasks, int n) { int[] cnt = new int[26];
        for (char c : tasks) cnt[c - 'A']++;
        Arrays.sort(cnt);
        int maxVal = cnt[25] - 1;
        int idleSlots = maxVal * n;
        for (int i = 24;
        i >= 0 && cnt[i] > 0;
        i--) idleSlots -= Math.min(cnt[i], maxVal);
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    };
}
