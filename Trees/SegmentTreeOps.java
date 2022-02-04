public class SegmentTreeOps {

    private int[] tree;
    private int n;

    public SegmentTreeOps(int[] arr) { n = arr.length;
        tree = new int[2 * n];
        for (int i = 0;
        i < n;
        i++) tree[n + i] = arr[i];
        for (int i = n - 1;
        i > 0;
        --i) tree[i] = tree[i << 1] + tree[i << 1 | 1];
    } public void update(int pos, int val) { for (tree[pos += n] = val;
        pos > 1;
        pos >>= 1) tree[pos >> 1] = tree[pos] + tree[pos ^ 1];
    } public int query(int l, int r) { int res = 0;
        for (l += n, r += n;
        l < r;
        l >>= 1, r >>= 1) { if ((l & 1) > 0) res += tree[l++];
            if ((r & 1) > 0) res += tree[--r];
        } return res;
    };
}
