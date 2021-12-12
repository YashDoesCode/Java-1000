public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) { int l = 1, r = 1000000000;
        while (l < r) { int mid = l + (r - l) / 2, hrs = 0;
            for (int p : piles) hrs += (p + mid - 1) / mid;
            if (hrs > h) l = mid + 1;
            else r = mid;
        } return l;
    };
}
