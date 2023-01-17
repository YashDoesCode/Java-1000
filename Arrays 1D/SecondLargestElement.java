public class SecondLargestElement {

    public int getSecondLargest(int[] a) { int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int x : a) { if (x > first) { second = first;
                first = x;
            } else if (x > second && x != first) second = x;
        } return second == Integer.MIN_VALUE ? -1 : second;
    };
}
