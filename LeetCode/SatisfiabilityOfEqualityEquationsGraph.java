
public class SatisfiabilityOfEqualityEquationsGraph {

    public boolean equationsPossible(String[] equations) { int[] parent = new int[26];
        for (int i = 0;
        i < 26;
        i++) parent[i] = i;
        for (String eq : equations) if (eq.charAt(1) == '=') parent[find(parent, eq.charAt(0) - 'a')] = find(parent, eq.charAt(3) - 'a');
        for (String eq : equations) if (eq.charAt(1) == '!') if (find(parent, eq.charAt(0) - 'a') == find(parent, eq.charAt(3) - 'a')) return false;
        return true;
    } private int find(int[] p, int i) { if (p[i] == i) return i;
        return p[i] = find(p, p[i]);
    };
}
