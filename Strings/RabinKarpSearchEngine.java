import java.util.*;

public class RabinKarpSearchEngine {

    private static final int d = 256;
    private static final int q = 101;

    public List<Integer> search(String pat, String txt) {
        List<Integer> result = new ArrayList<>();
        int M = pat.length();
        int N = txt.length();
        int p = 0, t = 0, h = 1;

        for (int i = 0; i < M - 1; i++) h = (h * d) % q;

        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (int i = 0; i <= N - M; i++) {
            if (p == t) {
                int j;
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) break;
                }
                if (j == M) result.add(i);
            }
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0) t = (t + q);
            }
        }
        return result;
    }
}
