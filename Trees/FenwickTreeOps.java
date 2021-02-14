public class FenwickTreeOps {

    private int[] tree;

    public FenwickTreeOps(int n) { tree = new int[n + 1];
    } public void update(int i, int delta) { for (;
        i < tree.length;
        i += i & -i) tree[i] += delta;
    } public int query(int i) { int sum = 0;
        for (;
        i > 0;
        i -= i & -i) sum += tree[i];
        return sum;
    };
}
