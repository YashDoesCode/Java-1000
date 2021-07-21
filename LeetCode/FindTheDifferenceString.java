
public class FindTheDifferenceString {

    public char findTheDifference(String s, String t) { char c = 0;
        for (char x : s.toCharArray()) c ^= x;
        for (char x : t.toCharArray()) c ^= x;
        return c;
    };
}
