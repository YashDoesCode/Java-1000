public class ReverseStringRecursion {

    public String reverse(String s) { return s.isEmpty() ? "" : reverse(s.substring(1)) + s.charAt(0);
    };
}
