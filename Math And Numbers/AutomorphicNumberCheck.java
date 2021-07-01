public class AutomorphicNumberCheck {

    public boolean isAutomorphic(int n) { long sq = (long) n * n;
        return String.valueOf(sq).endsWith(String.valueOf(n));
    };
}
