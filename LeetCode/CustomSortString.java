
public class CustomSortString {

    public String customSortString(String order, String s) { int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) { while (cnt[c - 'a']-- > 0) sb.append(c);
        } for (char c = 'a';
        c <= 'z';
        c++) { while (cnt[c - 'a']-- > 0) sb.append(c);
        } return sb.toString();
    };
}
