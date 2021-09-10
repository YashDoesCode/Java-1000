public class GuessNumberHigherOrLower {

    private int num = 6;

    public int guessNumber(int n) { int l = 1, r = n;
        while (l <= r) { int mid = l + (r - l) / 2;
            int g = guess(mid);
            if (g == 0) return mid;
            else if (g < 0) r = mid - 1;
            else l = mid + 1;
        } return -1;
    } private int guess(int num) { return Integer.compare(this.num, num);
    };
}
