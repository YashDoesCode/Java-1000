public class ZAlgorithmSearch {

    public int search(String text, String pattern) { String concat = pattern + "$" + text;
        int l = concat.length();
        int[] z = new int[l];
        int L = 0, R = 0;
        for (int i = 1;
        i < l;
        i++) { if (i > R) { L = R = i;
                while (R < l && concat.charAt(R - L) == concat.charAt(R)) R++;
                z[i] = R - L;
                R--;
            } else { int k = i - L;
                if (z[k] < R - i + 1) z[i] = z[k];
                else { L = i;
                    while (R < l && concat.charAt(R - L) == concat.charAt(R)) R++;
                    z[i] = R - L;
                    R--;
                } } } for (int i = 0;
        i < l;
        i++) if (z[i] == pattern.length()) return i - pattern.length() - 1;
        return -1;
    };
}
