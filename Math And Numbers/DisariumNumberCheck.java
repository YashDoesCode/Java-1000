public class DisariumNumberCheck {

    public boolean isDisarium(int n) { String s = String.valueOf(n);
        int sum = 0;
        for (int i = 0;
        i < s.length();
        i++) sum += Math.pow(s.charAt(i) - '0', i + 1);
        return sum == n;
    };
}
