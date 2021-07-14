
public class PlusOne {

    public int[] plusOne(int[] d) { for (int i = d.length - 1;
        i >= 0;
        i--) { if (d[i] < 9) { d[i]++;
                return d;
            } d[i] = 0;
        } int[] res = new int[d.length + 1];
        res[0] = 1;
        return res;
    };
}
