public class JumpSearchAlgo {

    public int search(int[] a, int target) { int n = a.length, step = (int) Math.sqrt(n), prev = 0;
        while (a[Math.min(step, n) - 1] < target) { prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1;
        } while (a[prev] < target) { prev++;
            if (prev == Math.min(step, n)) return -1;
        } return a[prev] == target ? prev : -1;
    };
}
