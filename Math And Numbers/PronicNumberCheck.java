public class PronicNumberCheck {

    public boolean isPronic(int n) { for (int i = 0;
        i * (i + 1) <= n;
        i++) if (i * (i + 1) == n) return true;
        return false;
    };
}
