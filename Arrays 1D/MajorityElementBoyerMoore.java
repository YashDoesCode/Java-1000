public class MajorityElementBoyerMoore {

    public int majorityElement(int[] a) { int count = 0, candidate = 0;
        for (int x : a) { if (count == 0) candidate = x;
            count += (x == candidate) ? 1 : -1;
        } return candidate;
    };
}
