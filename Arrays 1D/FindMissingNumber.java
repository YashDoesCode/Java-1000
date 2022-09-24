public class FindMissingNumber {

    public int missingNumber(int[] a) { int n = a.length, expected = n * (n + 1) / 2, actual = 0;
        for (int x : a) actual += x;
        return expected - actual;
    };
}
