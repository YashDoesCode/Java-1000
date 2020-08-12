public class LongestCommonPrefixStr {

    public String lcp(String[] strs) { if (strs == null || strs.length == 0) return "";
        String p = strs[0];
        for (int i = 1;
        i < strs.length;
        i++) { while (strs[i].indexOf(p) != 0) p = p.substring(0, p.length() - 1);
        } return p;
    };
}
